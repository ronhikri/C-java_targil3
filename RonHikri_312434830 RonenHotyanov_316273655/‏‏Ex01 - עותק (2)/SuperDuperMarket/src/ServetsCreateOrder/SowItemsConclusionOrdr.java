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

public class SowItemsConclusionOrdr extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger obj=user.searchList(Att.getNameZone());
            ArrayList<showItemsConclusionOrder> itemsord = new ArrayList<>();
            String selectOrd = request.getParameter("SelectOrder");
            int orderint = Integer.parseInt(selectOrd);
            classManeger ttempobj = null;
            Order order=null;
            orderDinamy orderdinamy=null;
            int selected=0;
            boolean found=false;
                for(Order ord:obj.getListorder())
                {
                    if(ord.getIdCountOrder()==orderint)
                    {
                        order=ord;
                        selected=1;
                        found=true;
                        break;
                    }
                }
                if(found)
                {
                    ttempobj=obj;
                }
                else
                {
                    for(orderDinamy ord:obj.getListDinamyOrder())
                    {
                        if(ord.getIdCountOrder()==orderint)
                        {
                            orderdinamy=ord;
                            selected=2;
                            found=true;
                            break;
                        }
                    }
                    if(found)
                    {
                        ttempobj=obj;
                    }
                }
            if(selected==1)
            {
                ttempobj.initiall();
                for(itemToOrder it:order.getItemtoorder()) {
                    ttempobj.additemorder(it);
                }
                itemsord=ttempobj.creatListNode(1);
                ttempobj.initiall();
            }
            else
            {
                ttempobj.initiall2();
                for(itemToOrderDinamy it:orderdinamy.getItemsdinamy()) {
                    ttempobj.additemdinamyorder(it);
                }
                itemsord=ttempobj.creatListNode(2);
                ttempobj.initiall2();
            }
            Gson gson=new Gson();
           String json= gson.toJson(itemsord);
            out.println(json);

        }
    }
}
