package clasinEx;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.security.acl.LastOwnerException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    private int idcust;
    private LocalDate date;
    private int idOfStore;
    private int ppk;
    private int cordinata_x;
    private int cordinata_y;
    private ArrayList<itemToOrder> itemtoorder;
    private location loation;
    private int idCountOrder;
    private String nameStore;

    public Order(LocalDate datetime, int ppkilometer, int x, int y, ArrayList<itemToOrder> Items, location l, int countOrder) {
        this.date = datetime;
        this.idOfStore = 0;
        this.ppk = ppkilometer;
        this.cordinata_x = x;
        this.cordinata_y = y;
        this.itemtoorder = Items;
        loation = l;
        idCountOrder = countOrder;
    }
    public Order()
    {
        itemtoorder=new ArrayList<>();

    }
    public int getIdcust()
    {
        return this.idcust;
    }
    public void setIdcust(int value)
    {
        this.idcust=value;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public ArrayList<itemToOrder> getItemtoorder() {
        if(itemtoorder==null)
            itemtoorder=new ArrayList<>();
        return this.itemtoorder;
    }

    public int getIdOfStore() {
        return this.idOfStore;
    }

    public void setIdOfStore(int value) {
        this.idOfStore = value;
    }

    public int getPpk() {
        return this.ppk;
    }

    public int getCordinata_x() {
        return this.cordinata_x;
    }

    public int getCordinata_y() {
        return this.cordinata_y;
    }

    public void setDate(LocalDate value) {
        this.date = value;
    }

    public void setPpk(int value) {
        this.ppk = value;
    }

    public void setCordinata_x(int value) {
        this.cordinata_y = value;
    }

    public void setCordinata_y(int value) {
        this.cordinata_y = value;
    }

    public String getNameStore() {
        return this.nameStore;
    }

    public void setNameStore(String value) {
        this.nameStore = value;
    }

    public int getIdCountOrder() {
        return this.idCountOrder;
    }
    public void setIdCountOrder(int value)
    {
        this.idCountOrder=value;
    }

    public location getLoation() {
        return this.loation;
    }

    public void printPriceSending() {
        double distanceX = (this.cordinata_x - this.loation.x);
        double distanceY = (this.cordinata_y - this.loation.y);
        double distance = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
        double distancesqrt = (double) Math.sqrt(distance);
        double priceSending = (double) (distancesqrt * this.getPpk());
        System.out.println("The cost PriceSendingOrder is: " + String.format("%.2f", priceSending));
    }

    public void ConclusionInOrder() {
        int i=0;
       while (i<this.getItemtoorder().size())
       {
            this.getItemtoorder().get(i).printidofitem();
            this.getItemtoorder().get(i).printnaneitem();
            this.getItemtoorder().get(i).printWayToBuyItem();
            this.getItemtoorder().get(i).printprceunititem();
            this.getItemtoorder().get(i).printcountitems();
            this.getItemtoorder().get(i).printSumPrice();
            i++;
        }
        printPriceSending();
    }

    public void printDate() {
        System.out.println("The date is: " + this.getDate().toString());
    }

    public void printCountOfItems() {
        double count = 0;
        for (itemToOrder itemorder : this.getItemtoorder()) {
            count = count + itemorder.getCountItemToOrder();
        }
        System.out.println("The count of items is: " + String.format("%.2f", count));
    }

    public void sumCostitems() {
        double sum = 0;
        for (itemToOrder itemorder : this.getItemtoorder()) {
            sum = sum + itemorder.getSumPriceItem();
        }
        System.out.println("The sum of cost items in order: " + String.format("%.2f", sum));
    }

    public void costOrder() {
        double distanceX = (this.cordinata_x - this.loation.x);
        double distanceY = (this.cordinata_y - this.loation.y);
        double distance = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
        double distancesqrt = (double) Math.sqrt(distance);
        double priceSending = (double) (distancesqrt * this.getPpk());
        double sum = 0;
        for (itemToOrder itemorder : this.getItemtoorder()) {
            sum = sum + itemorder.getSumPriceItem();
        }
        double cost = sum + priceSending;
        System.out.println("The Cost Of Oreder is: " + String.format("%.2f", cost));
    }

    public void printIdOfStoreandname() {
        System.out.println("The id of store that made in order is: " + String.format("%d", this.getIdOfStore())+String.format("%S",this.getNameStore()));
    }
    public void printIdOfOrder()
    {
        System.out.println("The id of order is: "+String.format("%d",this.getIdCountOrder()));
    }
    public int countKindOfItems()
    {
        int count=0;
        for(itemToOrder itemtoorder:this.getItemtoorder())
        {
            if(itemtoorder.getId()!=0)
                count++;
        }
        return count;
    }
    public void printCountkindOItemsAndCountSumItems()
    {
        System.out.println("The count Of Kind of items that selected in order is: "+String.format("%d",countKindOfItems()));
        printCountOfItems();
    }
    public void Add(itemToOrder it)
    {
        itemtoorder.add(it);
    }
    public double countItemsinorder()
    {
        double count=0;
        for(itemToOrder it:this.getItemtoorder())
        {
            count=count+it.getCountItemToOrder();
        }
        return count;
    }
    public double PriceSumItems()
    {
        double price=0;
        for(itemToOrder it:this.getItemtoorder())
        {
            price=price+it.getSumPriceItem()+it.getPricemadeDiscount();
        }
        return price;
    }
    public double SendingCost(int xCustomer,int yCustomer,int xStore,int yStore)
    {
        int hefreshX=xCustomer-xStore;
        int hefreshY=yCustomer-yStore;
        double hefreshribuyiX=Math.pow((double)hefreshX,2);
        double hefrshribuyiY=Math.pow((double)hefreshY,2);
        double distance=Math.sqrt(hefreshribuyiX+hefrshribuyiY);
        return (distance*ppk);
    }


}
