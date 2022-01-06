package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
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

public class ServeteOpp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            String name_opp = Att.getDiscer().getGetoffer().getOperator();
                ArrayList<String>Listopp=new ArrayList<>();
                    if(name_opp.equals("ALL-OR-NOTHING"))
                    {
                        Listopp.add("Select-all");
                        Listopp.add("Not-Select");
                    }
                    else
                    {
                        Listopp.add("Selct_Item");
                        Listopp.add("not-Select");
                    }
                Gson gson=new Gson();
                String json=gson.toJson(Listopp);
                out.println(json);
            }
        }
    }

