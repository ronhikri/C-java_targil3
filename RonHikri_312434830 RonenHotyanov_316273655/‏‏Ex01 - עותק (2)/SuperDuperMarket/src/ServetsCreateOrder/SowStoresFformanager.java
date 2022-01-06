package ServetsCreateOrder;


import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.orderinStore;
import clasinEx.store;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Handler;

public class SowStoresFformanager extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
          ArrayList<String>storesss=new ArrayList<>();
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj=null;
              for(classManeger obj:user.getObjs())
              {
                  if(obj.getZoni().getNameZone().equals(Att.getNameZone()))
                  {
                      tempobj=obj;
                      break;
                  }
              }
              for(store st:tempobj.getStores().getStoress())
              {
                  if(st.getNameStoreManege().equals(Att.getUsername())) {
                      storesss.add((String.format("%d", st.getId())) + "," + st.getName());
                  }
              }
            Gson gson=new Gson();
          String json=gson.toJson(storesss);
          out.println(json);

        }
    }
}
