package ServeteControllPanel;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.UsersWeb.UserWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ChargeMoneyServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            UserWeb use=user.searchUser(Att.getUsername());
            String moneyChargeStr=request.getParameter("chargeMoneyForAccount");
            double amount=Double.parseDouble(moneyChargeStr);
            if(amount<=0)
            {
                out.println("-1");
            }
            else {
                String date = request.getParameter("chargeDatei");
                if (date == "")
                    out.println("-2");
                else {
                    use.setFinancialAction(date, amount, 2);
                    out.println("1");
                }
            }

        }
        catch (Exception e)
        {
            out.println("no sucesss or you select not number");
        }
    }
}
