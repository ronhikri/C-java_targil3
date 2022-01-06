package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.orderinStore;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class ShowOrdrerInStore extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            ArrayList<orderinStore> ordersinstore = new ArrayList<>();
            ArrayList<orderinStore> orderStaticorder = new ArrayList<>();
            ArrayList<orderinStore> orderDinamy = new ArrayList<>();
            String idstoreStr = request.getParameter("StoreSelectBring");
            int index=idstoreStr.indexOf(",");
            String idd=idstoreStr.substring(0,index);
            int idstore = Integer.parseInt(idd);
            Att.setIdstore(idstore);
            orderStaticorder = tempobj.Staticcreateordersstore(idstore);
            orderDinamy = tempobj.createDinamyOrdersStore(idstore);
            for (orderinStore order : orderStaticorder)
                ordersinstore.add(order);
            for (orderinStore order : orderDinamy)
                ordersinstore.add(order);
            Gson gson=new Gson();
            String json=gson.toJson(ordersinstore);
            out.println(json);
        }
        catch (NumberFormatException e)
        {
            out.println("no select store");
        }
        catch (IllegalFormatException e)
        {
            out.println("no select store");
        }
        catch (Exception e)
        {
            out.println("no sucess");
        }
    }
}
