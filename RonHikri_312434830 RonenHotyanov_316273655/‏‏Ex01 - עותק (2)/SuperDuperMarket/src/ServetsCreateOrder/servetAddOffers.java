package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.offerToOrder;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.item;
import clasinEx.offer;
import com.google.gson.Gson;
import com.sun.deploy.security.SelectableSecurityManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class servetAddOffers extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            ArrayList<offerToOrder> offs=new ArrayList<>();
            for(offer oks:Att.getDiscer().getGetoffer().getSdmoffer())
            {
                offerToOrder ofser=new offerToOrder();
                ofser.setIdoffer(oks.getId());
                String name="";
                for(item it:tempobj.getItems().getItems())
                {
                    if(oks.getId()==it.getId())
                    {
                        name=it.getName();
                        break;
                    }
                }
                ofser.setNameofOffer(name);
                ofser.setQuantityOffer(oks.getQuantity());
                ofser.setPriceOffer(oks.getPriceone());
                offs.add(ofser);
            }
            Gson gson=new Gson();
            String json=gson.toJson(offs);
            out.println(json);
        }
    }
}