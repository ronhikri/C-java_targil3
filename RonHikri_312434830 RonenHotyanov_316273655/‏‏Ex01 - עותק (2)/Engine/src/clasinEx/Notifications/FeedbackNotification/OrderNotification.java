package clasinEx.Notifications.FeedbackNotification;

import clasinEx.classManeger;
import clasinEx.customer;
import clasinEx.itemToOrder;
import clasinEx.store;

import java.util.ArrayList;

public class OrderNotification {

    private String numberOfOrder;
    private String name_customer;
    private String kindItems;
    private String SumCostItems;
    private String CostSend;

    public OrderNotification(String countOrder,String nameCustomer,String countKindItems,String costSumItems,String SendingCost)
    {
        this.numberOfOrder=countOrder;
        this.name_customer=nameCustomer;
        this.kindItems=countKindItems;
        this.SumCostItems=costSumItems;
        this.CostSend=SendingCost;
    }

}
