package servlets;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.IdAndNameStore;
import clasinEx.classManeger;
import clasinEx.store;
import clasinEx.storesInSystem;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class servetCreateStores extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            String selectidStore=request.getParameter("storeselect");
            int index=selectidStore.indexOf(",");
            String idstoreStr=selectidStore.substring(0,index);
            int idstore=Integer.parseInt(idstoreStr);
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger obj= user.searchList(Att.getNameZone());
            storesInSystem storesList=new storesInSystem();
            storesList=obj.createStores(idstore);
            Gson gson=new Gson();
            String json=gson.toJson(storesList);
            out.println(json);

        }
    }
}
