package servlets;

import Utils.sessionAtt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServeteBackToZone extends HttpServlet {

    private final String ShowStoresAndItemsInZone="../pages/storesInZone/stoesAndItemsZone.html";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.sendRedirect(ShowStoresAndItemsInZone);
    }
}
