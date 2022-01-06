package ServeteOpenStorsandItems;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.Notifications.FeedbackNotification.NewStoreNotification;
import clasinEx.UsersWeb.UserWeb;
import clasinEx.classManeger;
import clasinEx.sell;
import clasinEx.store;
import clasinEx.storeToSystem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServeteFinishCreateStore extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            store s = null;
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            storeToSystem stro = Att.getStored();
            for (store st : tempobj.getStores().getStoress()) {
                if (st.getId() == stro.getIdofStore()) {
                    s = st;
                    break;
                }
            }
            String name_store = s.getName();
            String nameStoreManeger = s.getNameStoreManege();
            int x = s.getLocation().getX();
            int y = s.getLocation().getY();
            int count = 0;
            for (sell sel : s.getPrice().getSells()) {
                count++;
            }
            int countermanage = 0;
            for (int i = 0; i < tempobj.getStores().getStoress().size() - 1; i++) {
                countermanage = 0;
                for (int j = i + 1; j < tempobj.getStores().getStoress().size(); j++) {
                    if (tempobj.getStores().getStoress().get(i).getNameStoreManege() == tempobj.getStores().getStoress().get(j).getNameStoreManege())
                        countermanage++;
                }
                if (countermanage == 0) {
                    String corx = String.format("%d", x);
                    String cory = String.format("%d", y);
                    String countItems = String.format("%d", count);
                    NewStoreNotification newStoreNotification = new NewStoreNotification(Att.getUsername(), name_store, corx, cory, countItems);
                    UserWeb use = user.searchUser(tempobj.getStores().getStoress().get(i).getNameStoreManege());
                 use.addNewStoreUpdate(newStoreNotification);
                    out.println("Sucess");
                }

            }
            int i=tempobj.getStores().getStoress().size()-1;
            String corx = String.format("%d", x);
            String cory = String.format("%d", y);
            String countItems = String.format("%d", count);
            NewStoreNotification newStoreNotification = new NewStoreNotification(Att.getUsername(), name_store, corx, cory, countItems);
            UserWeb use = user.searchUser(tempobj.getStores().getStoress().get(i).getNameStoreManege());
            use.addNewStoreUpdate(newStoreNotification);
            out.println("Sucess");

        }
        catch (Exception e)
        {
            out.println("no sucess");
        }
    }
}
