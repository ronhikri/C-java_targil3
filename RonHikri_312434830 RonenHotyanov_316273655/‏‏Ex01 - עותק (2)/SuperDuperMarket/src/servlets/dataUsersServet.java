package servlets;

import Utils.DataUsers;
import Utils.RoliAndUseri;
import Utils.UserUtils;
import Utils.userManegerToServet;
import clasinEx.roleAndNaneUser;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class dataUsersServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            userManegerToServet users = UserUtils.getuser(getServletContext());
            ArrayList<RoliAndUseri>usersin=new ArrayList<>();
        if(users.getNames().size()!=0) {
            for (roleAndNaneUser rt : users.getNames()) {
                RoliAndUseri r = new RoliAndUseri();
                r.setNameyi(rt.getNamei());
                r.setRoliey(rt.getRolei());
                usersin.add(r);
            }
        }
        Gson gson=new Gson();
        String json=gson.toJson(usersin);
        out.println(json);


        }
    }

}
