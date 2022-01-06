package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.showItemsToOrder;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShowDataItemsServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            ArrayList<showItemsToOrder> ListItemsOrder = new ArrayList<>();
            if (Att.getSelectorder() == 1) {
                ListItemsOrder = tempobj.builditemsContinueOrder(Att.getIdstore());
            } else {
                ListItemsOrder = tempobj.buildItemsDinamy();
            }
            Gson gson=new Gson();
            String json=gson.toJson(ListItemsOrder);
            out.println(json);
        }
    }
}
