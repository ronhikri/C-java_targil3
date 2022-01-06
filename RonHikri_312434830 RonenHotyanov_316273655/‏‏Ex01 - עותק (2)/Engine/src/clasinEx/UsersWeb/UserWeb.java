package clasinEx.UsersWeb;

import clasinEx.Feedback.Feedback;
import clasinEx.Notifications.FeedbackNotification.FeedbackNotification;
//import clasinEx.Notifications.ScheduleNotification.ScheduleNotification;
import clasinEx.Notifications.FeedbackNotification.NewStoreNotification;
import clasinEx.Notifications.FeedbackNotification.OrderNotification;
import clasinEx.TimeAndDate.TransClock;

import java.util.ArrayList;
import java.util.List;



public class UserWeb
{
    private static final int FIRST_VOTE = 1;
    private static final boolean STORE_MANAGER = true;
    private static final boolean CUSTOMER= false;

    public String userName;
    public double userMoney;
    private List<FinancialAction> financialActionList;
    private List<Feedback> feedbackList;
    private List<FeedbackNotification> feedbackUpdates;
    private List<NewStoreNotification> newStoreUpdates;
    private List<OrderNotification> orderUpdates;
    private double averageGrade;
    private int numOfVoters = 0;
    private Boolean role;

    private int numOfCheckedFeedbackNotifications = 0;
    private int numOfFeedbackNotifications = 0;
    private int numOfCheckedNewStoreNotifications = 0;
    private int numOfNewStoreNotifications = 0;
    private int numOfCheckedOrderNotifications = 0;
    private int numOfOrderNotifications = 0;

    private static final String[] bankAction = {"Transfer Money", "Receive Money", "Charge Money"};

    public UserWeb(String userName, String role)
    {
        feedbackList = new ArrayList<>();
        financialActionList = new ArrayList<>();
        this.userName = userName;
        this.userMoney = 0.0f;
        if(role.equals("Customer"))
        {
            this.role = CUSTOMER;
        }
        else
        {
            this.role = STORE_MANAGER;
        }

        if(this.role == STORE_MANAGER)
        {
            feedbackUpdates = new ArrayList<>();
            newStoreUpdates = new ArrayList<>();
            orderUpdates = new ArrayList<>();
           // scheduleUpdates = new ArrayList<>();
        }
    }

    public void addFeedbackUpdate(FeedbackNotification newFeedbackNotification)
    {
        feedbackUpdates.add(newFeedbackNotification);
        numOfFeedbackNotifications++;
    }

    public void addNewStoreUpdate(NewStoreNotification newStoreNotification)
    {
        newStoreUpdates.add(newStoreNotification);
        numOfNewStoreNotifications++;
    }

    public void addOrderUpdate(OrderNotification newOrderNotification)
    {
        orderUpdates.add(newOrderNotification);
        numOfOrderNotifications++;
    }

    public int getNumOfCheckedFeedbackNotifications() {
        return numOfCheckedFeedbackNotifications;
    }

    public int getNumOfFeedbackNotifications() {
        return numOfFeedbackNotifications;
    }

    public int getNumOfCheckedNewStoreNotifications() {
        return numOfCheckedNewStoreNotifications;
    }

    public int getNumOfNewStoreNotifications() {
        return numOfNewStoreNotifications;
    }

    public int getNumOfCheckedOrderNotifications() {
        return numOfCheckedOrderNotifications;
    }

    public int getNumOfOrderNotifications() {
        return numOfOrderNotifications;
    }

    public double getUserMoney() {
        return userMoney;
    }

    public Boolean getRole() {
        return role;
    }

    public void setFinancialAction(String date, double amount, int actionNameNum)
    {
        switch (actionNameNum)
        {

            //customer give money to store manager
            case 0:{
                financialActionList.add(new FinancialAction(date, amount, userMoney, userMoney - amount, bankAction[actionNameNum]));
                userMoney -= amount;
                break;
            }

            //store manager get money from customer
            case 1: {
                financialActionList.add(new FinancialAction(date, amount, userMoney, userMoney + amount, bankAction[actionNameNum] ));
                userMoney += amount;
                break;
            }

            //user charge money
            case 2: {
                financialActionList.add(new FinancialAction(date, amount, userMoney, userMoney + amount, bankAction[actionNameNum] ));
                userMoney += amount;
                break;
            }
        }
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getNumOfVoters() {
        return numOfVoters;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void addFeedbackToStoreManager(Feedback currentFeedback) {
        double newAvgGrade = 0;
        if (!currentFeedback.getMessage().equals("")) {
            feedbackList.add(currentFeedback);
        }
        numOfVoters++;
        if (numOfVoters == FIRST_VOTE) {
            averageGrade = currentFeedback.getRate();
        } else {
            newAvgGrade = (((averageGrade) * (double) (numOfVoters - 1)) / (double) (numOfVoters)) + (((double) (currentFeedback.getRate())) / (double) (numOfVoters));
            averageGrade = newAvgGrade;
        }
    }

    public String getUserName() {
        return userName;
    }

    public List<FeedbackNotification> getFeedbackUpdates() {
        return feedbackUpdates;
    }

    public List<NewStoreNotification> getNewStoreUpdates() {
        return newStoreUpdates;
    }

    public List<OrderNotification> getOrderUpdates() {
        return orderUpdates;
    }


    public void updateNotificationsNum(int numOfCheckedFeedbackNotifications, int numOfCheckedNewStoreNotifications, int numOfCheckedOrderNotifications )
    {
      //  this.numOfCheckedScheduleNotifications = numOfCheckedScheduleNotifications;
        this.numOfCheckedFeedbackNotifications = numOfCheckedFeedbackNotifications;
        this.numOfCheckedNewStoreNotifications = numOfCheckedNewStoreNotifications;
        this.numOfCheckedOrderNotifications = numOfCheckedOrderNotifications;
    }

}
