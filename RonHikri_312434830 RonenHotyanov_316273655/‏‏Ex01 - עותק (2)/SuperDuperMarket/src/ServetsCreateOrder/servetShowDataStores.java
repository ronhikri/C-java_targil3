package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.ShowStoreToOrder;
import clasinEx.classManeger;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class servetShowDataStores extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
             try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj=user.searchList(Att.getNameZone());
            ArrayList<ShowStoreToOrder>ListDataStores=null;
            if(Att.getSelectorder()==1)
            {
                ListDataStores=tempobj.buildListStoresInOrderStatic(Att.getValue());
            }
            else
            {
                ListDataStores=tempobj.buildListStoresInOrderDinamy(Att.getValue());
            }
            Gson gson=new Gson();
            String json=gson.toJson(ListDataStores);
            out.println(json);

        }
        catch (Exception e)
        {
            out.println("no success");
        }
    }
}
