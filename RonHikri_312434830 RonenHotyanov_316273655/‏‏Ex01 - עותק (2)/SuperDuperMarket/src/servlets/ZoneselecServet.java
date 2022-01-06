package servlets;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.Zone;
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

public class ZoneselecServet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            userManegerToServet users=UserUtils.getuser(getServletContext());
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            ArrayList<Zone>zoness=new ArrayList<>();
            if(Att.getRole()==2) {
                for (classManeger obj : users.getObjs()) {
                    zoness.add(obj.getZoni());
                }
            }
            else
            {
                for (classManeger obj : users.getObjs()) {
                    zoness.add(obj.getZoni());
                }
            }
            Gson gson = new Gson();
            String json=gson.toJson(zoness);
            out.println(json);


        }
    }
}
