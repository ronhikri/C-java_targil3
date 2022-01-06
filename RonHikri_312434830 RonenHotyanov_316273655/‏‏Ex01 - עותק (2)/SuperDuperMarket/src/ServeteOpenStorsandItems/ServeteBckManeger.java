package ServeteOpenStorsandItems;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServeteBckManeger extends HttpServlet {

    private final String sHObackYeaher = "../StoreManagerWeb/LinkAppStoreManege.html";
    //                                             pages/storesInZone/storesAndItemsZone.html

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.sendRedirect(sHObackYeaher);

    }
}
