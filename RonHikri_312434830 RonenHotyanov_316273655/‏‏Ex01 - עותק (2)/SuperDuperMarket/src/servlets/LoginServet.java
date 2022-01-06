package servlets;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.UsersWeb.UserWeb;
import clasinEx.roleAndNaneUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServet extends HttpServlet {


    private final String LOGINError = "/pages/errorhtmli/errorLogin.html";
    private final String fileLoading = "../fileUploadWeb/filerchooseri.html";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        sessionAtt Att = null;
        HttpSession session = request.getSession(false);
        if (session == null)
            Att = null;
        else {
            Att = (sessionAtt) session.getAttribute("Username");
        }
        userManegerToServet user = UserUtils.getuser(getServletContext());
        if (Att == null) {
            String name = request.getParameter("Name");
            String select = request.getParameter("role");
            if ( (name == null) || (select == null)) {
                getServletContext().getRequestDispatcher(LOGINError).forward(request, response);
            } else {
                if (user.checkeistinsystem(name))
                    getServletContext().getRequestDispatcher(LOGINError).forward(request, response);

                else {
                    session = request.getSession(true);
                    int x = user.getCurrentId();
                    user.setCurrentId(x + 1);
                    int y = user.getCurrentId();
                    int z = 0;
                    if (select.equals("Store-Manager")) {
                        roleAndNaneUser r = new roleAndNaneUser();
                        r.setNamei(name);
                        r.setRolei("storemanager");
                        user.AddName(r);
                        z = 1;
                        request.getSession().setAttribute("Username", new sessionAtt(y, name, z));
                        UserWeb use=new UserWeb(name,"StoreManeger");
                        user.AddUser(use);
                    } else {
                        roleAndNaneUser r = new roleAndNaneUser();
                        r.setNamei(name);
                        r.setRolei("customer");
                        user.AddName(r);
                        z = 2;
                        request.getSession(true).setAttribute("Username", new sessionAtt(y, name, z));
                        UserWeb use=new UserWeb(name,"Customer");
                        user.AddUser(use);
                    }
                    response.sendRedirect(fileLoading);


                }
            }

        } else {
            response.sendRedirect(fileLoading);

        }
    }
}
