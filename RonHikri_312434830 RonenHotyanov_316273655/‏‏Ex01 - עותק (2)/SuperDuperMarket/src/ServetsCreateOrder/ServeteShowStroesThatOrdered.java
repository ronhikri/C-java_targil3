package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.itemToOrder;
import clasinEx.store;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ServeteShowStroesThatOrdered extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
     PrintWriter out = response.getWriter();
        try
        {
        HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            ArrayList<String> argss = new ArrayList<>();
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            Gson gson = new Gson();
            String name="";
            if (Att.getSelectorder() == 1) {
                for(store st:tempobj.getStores().getStoress())
                {
                    if(st.getId()==Att.getIdstore())
                    {
                        name=st.getName();
                        break;
                    }
                }
                argss.add((String.format("%d",Att.getIdstore()))+","+name);


            }
            else
            {
                int count=0;
                for(int i=0;i<Att.getItemsdinamyorder().size()-1;i++)
                {
                    count=0;
                    for(int j=i+1;j<Att.getItemsdinamyorder().size();j++)
                    {
                        if(Att.getItemsdinamyorder().get(i).getIdOfStoreOfItem()==Att.getItemsdinamyorder().get(j).getIdOfStoreOfItem())
                            count++;
                    }
                    if(count==0)
                    {
                        String idstr=String.format("%d",Att.getItemsdinamyorder().get(i).getIdOfStoreOfItem());
                        name=Att.getItemsdinamyorder().get(i).getNameStoreOfItem();
                        argss.add(idstr+","+name);
                    }
                }
                String idstr=String.format("%d",Att.getItemsdinamyorder().get(Att.getItemsdinamyorder().size()-1).getIdOfStoreOfItem());
                name=Att.getItemsdinamyorder().get(Att.getItemsdinamyorder().size()-1).getNameStoreOfItem();
                argss.add(idstr+","+name);
            }
            String json=gson.toJson(argss);
            out.println(json);

        }
        catch (Exception e)
        {
            out.println("no sucess");
        }
    }
}

