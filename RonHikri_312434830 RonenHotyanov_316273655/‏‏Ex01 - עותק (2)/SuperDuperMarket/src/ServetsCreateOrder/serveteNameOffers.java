package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.item;
import clasinEx.offer;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class serveteNameOffers extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            ArrayList<String>namesOffs=new ArrayList<>();
            for(offer of:Att.getDiscer().getGetoffer().getSdmoffer())
            {
                int id=of.getId();
                String name="";
                for(item it:tempobj.getItems().getItems())
                {
                    if(of.getId()==it.getId())
                    {
                        name=it.getName();
                        break;
                    }
                }
                String attributeoff=String.format("%d",id)+","+name;
                namesOffs.add(attributeoff);
            }
            Gson gson=new Gson();
            String json=gson.toJson(namesOffs);
            out.println(json);
        }
    }
}
