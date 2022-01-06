package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.Feedback.Feedback;
import clasinEx.Notifications.FeedbackNotification.FeedbackNotification;
import clasinEx.UsersWeb.UserWeb;
import clasinEx.classManeger;
import clasinEx.store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServeteSendFeedback extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
         PrintWriter out = response.getWriter();
         try
         {
             String name="";
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            String strstore=request.getParameter("selectStoreThatOrder");
            int index=strstore.indexOf(",");
            String idstrstore=strstore.substring(0,index);
            int idstore=Integer.parseInt(idstrstore);
            String checkedrate=request.getParameter("valuecheckeed");
            int checkrate=Integer.parseInt(checkedrate);
            String tetfeed=request.getParameter("textfeed");
            for(store st:tempobj.getStores().getStoress())
            {
                if(st.getId()==idstore)
                {
                    name=st.getNameStoreManege();
                    break;
                }
            }
             UserWeb use=user.searchUser(name);
             FeedbackNotification feed=new FeedbackNotification(Att.getUsername(),checkedrate,tetfeed,Att.getDate().toString());
             Feedback fed=new Feedback(tetfeed,checkrate,Att.getUsername());
             use.addFeedbackToStoreManager(fed);
           use.addFeedbackUpdate(feed);
            user.removeUser(use.getUserName());
            user.AddUser(use);
            out.println("suceess");
        }
         catch (Exception e)
         {
             out.println("no sucess");
         }
    }
}
