package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class servetAddItemOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            String striditem=request.getParameter("idkItem");
            String countItemstr=request.getParameter("CountItem");
            try {
                int index=striditem.indexOf(",");
                String stri=striditem.substring(0,index);
                int iditem = Integer.parseInt(stri);
                HttpSession session = request.getSession();
                sessionAtt Att = (sessionAtt) session.getAttribute("Username");
                userManegerToServet user = UserUtils.getuser(getServletContext());
                classManeger tempobj = user.searchList(Att.getNameZone());
                String howbuy = tempobj.howToBuy(iditem);
                double count=0;
                if (howbuy.equals("Quantity"))
                {
                    int countItem=Integer.parseInt(countItemstr);
                    count=(double)countItem;
                }
                else
                {
                    count=Double.parseDouble(countItemstr);
                }

                if (Att.getSelectorder() == 1) {
                    Att.addToListorder(tempobj, Att.getIdstore(),iditem,count );
                    session.setAttribute("Username", Att);
                    out.println("success");
                }
                else
                {
                    int idStor=tempobj.idOfStoreItemMinimumPrice(iditem);
                    Att.AddListItemdinamyOrder(tempobj,iditem,idStor,count);
                    session.setAttribute("Username", Att);
                    out.println("success");
                }
            }
         catch (NumberFormatException e) {
           out.println("please select int number");
        } catch (InputMismatchException e) {
          out.println("please double number");

        } catch (IllegalFormatException e) {
          out.println("please select number according to instructions");
        } catch (Exception e) {
           out.println("please make accordimg to instructions");
        }



    }
    }


}
