package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BringmeOrdersInStoreSelect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
                HttpSession session = request.getSession();
                sessionAtt Att = (sessionAtt) session.getAttribute("Username");
                userManegerToServet user = UserUtils.getuser(getServletContext());
                classManeger tempobj = user.searchList(Att.getNameZone());
                String idOfstr=request.getParameter("StoreSelectBring");
                int index=idOfstr.indexOf(",");
                String idstore=idOfstr.substring(0,index);
                int idStore=Integer.parseInt(idstore);
            ArrayList<String>ords=new ArrayList<>();
                for(Order ord:tempobj.getListorder())
                {
                    if(ord.getIdOfStore()==idStore)
                        ords.add(String.format("%d",ord.getIdCountOrder()));
                }
                int ido=0;
                boolean found=false;
                for(orderDinamy ord:tempobj.getListDinamyOrder())
                {
                    for(itemToOrderDinamy it:ord.getItemsdinamy())
                    {
                        if(it.getIdOfStoreOfItem()==idStore)
                        {
                            ido=ord.getIdCountOrder();
                            found=true;
                            break;
                        }
                    }
                    if(found)
                    ords.add(String.format("%d",ido));
                    found=false;
                }
            Gson gson=new Gson();
                String json=gson.toJson(ords);
                out.println(json);
            }
        }
    }

