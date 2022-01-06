package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.privateDataOrder;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ServetShowOrders extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger obj=user.searchList(Att.getNameZone());
            ArrayList<privateDataOrder> orders=new ArrayList<>();

               if(obj.getIcostomers()!=null) {
                   ArrayList<privateDataOrder> priOrd = obj.CreateListPrivateorder(Att.getValue());
                   for(privateDataOrder o:priOrd)
                       orders.add(o);
               }
            Gson gson=new Gson();
           String json=gson.toJson(orders);
           out.println(json);
        }
    }
}
