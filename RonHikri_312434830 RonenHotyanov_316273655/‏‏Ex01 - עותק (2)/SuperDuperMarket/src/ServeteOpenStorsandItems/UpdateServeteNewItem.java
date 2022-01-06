package ServeteOpenStorsandItems;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.itemToSystem;
import exceptions.tryadditemthatsoldinstore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class UpdateServeteNewItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNanecurrentZoneToAddItem());
            String idStrname=request.getParameter("idsstor");
            int index=idStrname.indexOf(",");
            String idstorestr=idStrname.substring(0,index);
            int id_stor=Integer.parseInt(idstorestr);
            String price_item=request.getParameter("pricerittToStore");
            double priceit=Double.parseDouble(price_item);
            itemToSystem ited=Att.getItemed();
            int counter=Att.getCountStoresToItem();
            tempobj.AddItemToSys(Att.getItemed(),id_stor,priceit,counter);
            counter++;
            Att.setCountStoresToItem(counter);
            session.setAttribute("Username", Att);
            user.Removi(Att.getNameZone());
            user.AddObj(tempobj);
            out.println(1);

        }
        catch (tryadditemthatsoldinstore e)
        {
            out.println(e.create());
        }
        catch (InputMismatchException e) {
            out.println("please enter number");
        }
        catch (IllegalFormatException e)
        {
            out.println("pleaee enter according to instruction");
        }
        catch (Exception e)
        {
            out.println("no success");
        }
    }
}
