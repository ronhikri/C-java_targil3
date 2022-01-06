package ServetsCreateOrder;

import Utils.sessionAtt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class servetSelectStoreStatic extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            if (Att.getSelectorder() == 1) {
                String idStorestring = request.getParameter("selectStore");
                int index = idStorestring.indexOf(',');
                String idstoreSt = idStorestring.substring(0, index);
                int idstoreselect = Integer.parseInt(idstoreSt);
                Att.setIdstore(idstoreselect);
                session.setAttribute("Username", Att);
                out.println("sucess");
            }

        }
        catch (Exception e)
        {
            out.println("no success");
        }
    }
}

