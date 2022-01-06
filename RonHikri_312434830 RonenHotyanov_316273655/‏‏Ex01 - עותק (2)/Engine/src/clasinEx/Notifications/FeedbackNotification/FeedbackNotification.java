package clasinEx.Notifications.FeedbackNotification;

public class FeedbackNotification {

    private String dateOfNotification;
    private String nameOfCustomer;
    private String ratingNumber;
    private String messageFeedback;

    public FeedbackNotification(String nameOfCustomer, String ratingNumber, String messageFeedback, String dateOfNotification) {
        this.dateOfNotification = dateOfNotification;
        this.nameOfCustomer = nameOfCustomer;
        this.ratingNumber = ratingNumber;
        this.messageFeedback = messageFeedback;
    }

    public String getDateOfNotification() { return dateOfNotification; }

    public String getNameOfPassenger() {
        return nameOfCustomer;
    }


    public String getRatingNumber() {
        return ratingNumber;
    }

    public String getMessageFeedback() {
        return messageFeedback;
    }
}
