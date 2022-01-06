package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.Order;
import clasinEx.classManeger;
import clasinEx.orderDinamy;
import clasinEx.showItemsConclusionOrder;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShowItemsOrderInStore extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj=user.searchList(Att.getNameZone());
            ArrayList<showItemsConclusionOrder> list = new ArrayList<>();
            String orderSelecting=request.getParameter("selectOrderinStore");
            if(orderSelecting==null)
                out.println("You not select order");
            else
            {
                int order=Integer.parseInt(orderSelecting);
                list=tempobj.createNodeInStore(order,Att.getIdstore());
            }
            Gson gson=new Gson();
            String json=gson.toJson(list);
            out.println(json);
        }
    }
}