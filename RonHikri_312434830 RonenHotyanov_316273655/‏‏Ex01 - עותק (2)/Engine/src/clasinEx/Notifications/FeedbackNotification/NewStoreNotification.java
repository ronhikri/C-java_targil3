package clasinEx.Notifications.FeedbackNotification;

public class NewStoreNotification {

    private String nameMenegerStore;
    private String nameOfStore;
    private String cordinataX;
    private String cordinataY;
    private String countItems;

    public NewStoreNotification(String nameManeger,String nameStore,String cordx,String cordy,String count)
    {
        this.nameMenegerStore=nameManeger;
        this.nameOfStore=nameStore;
        this.cordinataX=cordx;
        this.cordinataY=cordy;
        this.countItems=count;

    }
}
