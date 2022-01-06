package ServeteControllPanel;

import Utils.UserUtils;
import Utils.userManegerToServet;
import clasinEx.roleAndNaneUser;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UsersListServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            userManegerToServet user = UserUtils.getuser(getServletContext());
            ArrayList<String>usersList=new ArrayList<>();
            for(roleAndNaneUser users: user.getNames())
            {
                usersList.add(users.getNamei());
            }
            Gson gson=new Gson();
            String json=gson.toJson(usersList);
            out.println(json);
        }
        catch (Exception e) {
            out.println("no success");
        }
    }

}
