package ServeteOpenStorsandItems;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.storeToSystem;
import exceptions.idsameitemsorstoresexceptions;
import exceptions.trytoaddLocationInStorethatfound;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.IllegalFormatException;

public class bringnewStoreToSystem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            String stridstore=request.getParameter("iddsstore");
            int idstore=Integer.parseInt(stridstore);
            String name_store=request.getParameter("nameSTOre");
            String strppkstore=request.getParameter("ppkastore");
            int ppk=Integer.parseInt(strppkstore);
            String cordix=request.getParameter("cordX");
            int cox=Integer.parseInt(cordix);
            String cordiy=request.getParameter("cordY");
            int coy=Integer.parseInt(cordiy);
            tempobj.checkidOfStoreAddFix(idstore,cox,coy);
            storeToSystem stora=new storeToSystem();
            stora.setIdofStore(idstore);
            stora.setNameOfStore(name_store);
            stora.setPpkOfStore(ppk);
            stora.setCordinataXofStore(cox);
            stora.setCordinataYofStore(coy);
            Att.setStored(stora);
            Att.setCountitemToNewStore(0);
            session.setAttribute("Username", Att);
            out.println("1");

        }
        catch (idsameitemsorstoresexceptions e)
        {
            out.println(e.create());
        }
        catch (trytoaddLocationInStorethatfound e)
        {
            out.println(e.create());
        }
        catch (NumberFormatException e)
        {
            out.println("please enter Integer number");
        }
        catch (IllegalFormatException e)
        {
            out.println("Enter please data integer");
        }
        catch (Exception e)
        {
            out.println("not sucess");
        }
    }
}
