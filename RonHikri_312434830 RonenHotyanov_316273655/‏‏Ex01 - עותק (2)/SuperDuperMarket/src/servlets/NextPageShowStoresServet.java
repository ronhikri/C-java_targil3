package servlets;

import Utils.sessionAtt;
import clasinEx.classManeger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class NextPageShowStoresServet extends HttpServlet {
// 1.   localhost:8080/SDM..._EXPLODED/NextPageShowStoresServet
    // 2. localhost:8080/SDM..._EXPLODED/pages/storesInZone/storesAndItemsZone.html
    //    localhost:8080/SDM..._EXPLODED/pages/storesInZone/storesAndItemsZone.html
    private final String ShowStoresAndItemsInZone="../storesInZone/stoesAndItemsZone.html";
    //                                             pages/storesInZone/storesAndItemsZone.html

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String nameZone=request.getParameter("zonin");
        HttpSession session = request.getSession();
        sessionAtt Att = (sessionAtt) session.getAttribute("Username");
       Att.setNameZone(nameZone);
        session.setAttribute("Username", Att);
        response.sendRedirect(ShowStoresAndItemsInZone);


    }
}
