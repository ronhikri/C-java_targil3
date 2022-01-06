package clasinEx.Feedback;

public class Feedback {
    private String messageFeed;
    private int rateFeed;
    private String nameOfCustomer;

    public Feedback(String message,int rate,String nameOfCustomer)
    {
        this.messageFeed=message;
        this.rateFeed=rate;
        this.nameOfCustomer = nameOfCustomer;
    }

    public int getRate() {
        return rateFeed;
    }

    public String getMessage() {
        return messageFeed;
    }


    public String getNameOfPassenger() {
        return nameOfCustomer;
    }
}


