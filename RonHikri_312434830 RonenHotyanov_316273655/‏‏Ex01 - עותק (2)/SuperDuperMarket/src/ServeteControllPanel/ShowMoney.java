package ServeteControllPanel;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.UsersWeb.UserWeb;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowMoney extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            try {
                Gson gson=new Gson();
                String json=null;
                HttpSession session = request.getSession();
                sessionAtt Att = (sessionAtt) session.getAttribute("Username");
                userManegerToServet user = UserUtils.getuser(getServletContext());
                UserWeb use=user.searchUser(Att.getUsername());
                if(use == null)
                    json = gson.toJson("the user isn't in the system");
                else
                    json=gson.toJson(String.format("%.2f",use.getUserMoney()));
                out.println(json);
                out.flush();

            }
            catch(Exception e)
            {
                out.write("7");
            }

        }
    }
