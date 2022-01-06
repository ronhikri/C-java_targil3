package servlets;

import Utils.sessionAtt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SeveteToCustomer extends HttpServlet {

    private final String Showcustomers="../CustomerOptions/OptionsCustomer.html";
    private final String ShowStoresManeger="../../StoreManagerWeb/LinkAppStoreManege.html";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        sessionAtt Att = (sessionAtt) session.getAttribute("Username");
        PrintWriter out = response.getWriter();
        if(Att.getRole()==2)
        response.sendRedirect(Showcustomers);
        else
            response.sendRedirect(ShowStoresManeger);

    }
}
