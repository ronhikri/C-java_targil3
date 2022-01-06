package ServetsCreateOrder;

import Utils.sessionAtt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServetNextShowOrders extends HttpServlet {

    private final String sHOWordersYeah="../CustomerOptions/OptionsCustomer.html";
    //                                             pages/storesInZone/storesAndItemsZone.html

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        sessionAtt Att = (sessionAtt) session.getAttribute("Username");
        Att.intiaill();
        Att.intiall2();
        session.setAttribute("Username", Att);
        response.sendRedirect(sHOWordersYeah);


    }
}
