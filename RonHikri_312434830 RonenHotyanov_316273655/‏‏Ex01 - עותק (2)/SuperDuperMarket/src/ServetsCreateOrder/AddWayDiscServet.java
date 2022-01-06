package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import exceptions.tryAccheiveDiscountThatNoEnough;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AddWayDiscServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            try {
                HttpSession session = request.getSession();
                sessionAtt Att = (sessionAtt) session.getAttribute("Username");
                userManegerToServet user = UserUtils.getuser(getServletContext());
                classManeger tempobj = user.searchList(Att.getNameZone());
                String opp = request.getParameter("SelectOpperator");
                if (opp.equals("Select-all"))
                    Att.UpdateDiscounnts(tempobj, Att.getDiscer(), Att.getSelectorder());
                if (opp.equals("Selct_Item")) {
                    String offSelected = request.getParameter("offer");
                    int index = offSelected.indexOf(",");
                    String itemoffer = offSelected.substring(0, index);
                    int iditemoff = Integer.parseInt(itemoffer);
                    Att.updateAccordingitem(tempobj, Att.getDiscer(), iditemoff, Att.getSelectorder());
                }
                out.println("sucess");


            } catch (tryAccheiveDiscountThatNoEnough e) {
                out.println("no suceess");

            }
        }

    }
}
