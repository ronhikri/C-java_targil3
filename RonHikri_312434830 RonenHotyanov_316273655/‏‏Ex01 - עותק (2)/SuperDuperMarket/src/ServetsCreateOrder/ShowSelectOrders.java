package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.Order;
import clasinEx.classManeger;
import clasinEx.orderDinamy;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShowSelectOrders extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            ArrayList<String>SelctOrders=new ArrayList<>();
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger obj=user.searchList(Att.getNameZone());
                if (obj.getIcostomers() != null) {
                    for (Order ord : obj.getListorder()) {
                        if (ord.getIdcust() == Att.getValue()) {
                            SelctOrders.add(String.format("%d", ord.getIdCountOrder()));
                        }

                    }
                    for (orderDinamy ord : obj.getListDinamyOrder()) {
                        if (ord.getIdCustomer() == Att.getValue()) {
                            SelctOrders.add(String.format("%d", ord.getIdCountOrder()));
                        }
                    }
                }
            Gson gson=new Gson();
            String json=gson.toJson(SelctOrders);
            out.println(json);
        }
    }

}
