package ServeteControllPanel;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.Notifications.FeedbackNotification.FeedbackNotification;
import clasinEx.Notifications.FeedbackNotification.NewStoreNotification;
import clasinEx.Notifications.FeedbackNotification.OrderNotification;
import clasinEx.UsersWeb.UserWeb;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowNotificationsRideServlet extends HttpServlet {

    private static final boolean STORE_MANAGER = true;
    private static final boolean CUSTOMER = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //returning JSON objects, not HTML
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter())
        {
            Gson gson = new Gson();
            String json;
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());

            String nameOfUser = Att.getUsername();
            UserWeb userWebNotification = user.searchUser(nameOfUser);

            if(userWebNotification == null)
                json = "the user isn't in the system";
            else if(userWebNotification.getRole() == CUSTOMER)
                json =  "I am CUSTOMER";
            else
            {
                int numCheckedFeedbackNotifications = userWebNotification.getNumOfCheckedFeedbackNotifications();
                int numFeedbackNotifications = userWebNotification.getNumOfFeedbackNotifications();
                int numCheckedNewStoreNotifications = userWebNotification.getNumOfCheckedNewStoreNotifications();
                int numNewStoreNotifications = userWebNotification.getNumOfNewStoreNotifications();
                int numCheckedOrderNotifications = userWebNotification.getNumOfCheckedOrderNotifications();
                int numOrderNotifications = userWebNotification.getNumOfOrderNotifications();

                if((numCheckedFeedbackNotifications == numFeedbackNotifications) &&
                        (numCheckedNewStoreNotifications == numNewStoreNotifications) &&
                        (numCheckedOrderNotifications == numOrderNotifications) )
                {
                    json =  "The notifications are already updated";
                }
                else
                {
                    FeedbackNotification feedbackNotification;
                    // ScheduleNotification scheduleNotification;
                    NewStoreNotification newStoreNotification;
                    OrderNotification orderNotification;

                    UserWeb userWebSend = new UserWeb(userWebNotification.getUserName(), "Store Manager");
                    for (int i = numCheckedFeedbackNotifications; i < numFeedbackNotifications; i++)
                    {
                        feedbackNotification = userWebNotification.getFeedbackUpdates().get(i);
                        userWebSend.addFeedbackUpdate(feedbackNotification);
                    }

                    for (int i = numCheckedNewStoreNotifications; i < numNewStoreNotifications; i++)
                    {
                        newStoreNotification = userWebNotification.getNewStoreUpdates().get(i);
                        userWebSend.addNewStoreUpdate(newStoreNotification);
                    }

                    for (int i = numCheckedOrderNotifications; i < numOrderNotifications; i++)
                    {
                        orderNotification = userWebNotification.getOrderUpdates().get(i);
                        userWebSend.addOrderUpdate(orderNotification);
                    }

                    userWebNotification.updateNotificationsNum(numFeedbackNotifications, numNewStoreNotifications, numOrderNotifications);
                    json = gson.toJson(userWebSend);
                }
            }

            out.println(json);
            out.flush();
        }
        catch(Exception e)
        {
            PrintWriter out = response.getWriter();
            out.write("Server Error");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

