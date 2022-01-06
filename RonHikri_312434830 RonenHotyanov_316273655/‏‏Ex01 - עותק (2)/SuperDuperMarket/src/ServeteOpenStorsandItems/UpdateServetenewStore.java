package ServeteOpenStorsandItems;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.storeToSystem;
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

public class UpdateServetenewStore extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            String iterStr=request.getParameter("idditem");
            int index=iterStr.indexOf(",");
            String idstring=iterStr.substring(0,index);
            int iditem=Integer.parseInt(idstring);
            String pricered=request.getParameter("priceritt");
            String howbuyitem=tempobj.howtobuyItem(iditem);
            double quant=0;
            if(howbuyitem.equals("Quantity"))
            {
                int quantity=Integer.parseInt(pricered);
                quant=(double)(quantity);
            }
            else
            {
                quant=Double.parseDouble(pricered);
            }
            int counter=Att.getCountitemToNewStore();
            storeToSystem stro=Att.getStored();
            String nameManege=Att.getUsername();
            tempobj.AddItemsToNewStore(nameManege,stro,iditem,quant,counter);
            counter++;
            Att.setCountitemToNewStore(counter);
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
        catch (NumberFormatException e)
        {
            out.println("please number int");
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
