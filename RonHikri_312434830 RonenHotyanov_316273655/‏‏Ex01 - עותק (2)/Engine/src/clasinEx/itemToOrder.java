package clasinEx;

import java.io.Serializable;
import java.util.ArrayList;

public class itemToOrder implements Serializable {
    private int id;
    private String nameItem;
    private String purItem;
    private double priceItem;
    private double countItemToOrder;
    private double sumPriceItem;
    private ArrayList<discount>discs;
    private double quantityemaindDisc;
    private double pricemadeDiscount;
    private boolean dogitten;
    private int idStore;
    private String nameStore;
    private String nameStoreManegerOfItem;


    public itemToOrder(int Id, String name, String purc, double price, double count, double sum,ArrayList<discount>diss) {
        this.id = Id;
        this.nameItem = name;
        this.purItem = purc;
        this.priceItem = price;
        this.countItemToOrder = count;
        this.sumPriceItem = sum;
        this.discs=diss;
    }
    public itemToOrder(ArrayList<discount>diss)
    {
        this.discs=diss;
        this.dogitten=false;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }


    public itemToOrder()
    {
        this.id=0;
    }
   public int getId()
   {
       return this.id;
   }
   public void setId(int value)
   {
       this.id=value;
   }
   public String getNameItem()
   {
       return this.nameItem;
   }
   public void setNameItem(String value)
   {
       this.nameItem=value;
   }
   public String getPurItem()
   {
       return this.purItem;
   }
   public void setPurIt(String value)
   {
       this.purItem=value;
   }
   public double getPriceItem()
   {
       return this.priceItem;
   }
   public void setPriceItem(double value)
   {
       this.priceItem=value;
   }
   public double getCountItemToOrder()
   {
       return this.countItemToOrder;
   }
   public  void setCountItemToOrder(double value)
   {
       this.countItemToOrder=value;
   }
   public double getSumPriceItem()
   {
       return (this.priceItem*this.countItemToOrder);
   }
public void setDogitten(boolean value){this.dogitten=value;}
public boolean isDogitten()
{
    return this.dogitten;
}
    public double getQuantityemaindDisc() {
        return quantityemaindDisc;
    }

    public double getPricemadeDiscount() {
        return pricemadeDiscount;
    }

    public void setQuantityemaindDisc(double quantityemaindDisc) {
        this.quantityemaindDisc = quantityemaindDisc;
    }

    public void setPricemadeDiscount(double pricemadeDiscount) {
        this.pricemadeDiscount = pricemadeDiscount;
    }

    public ArrayList<discount>getDiscs()
   {
       if(this.discs==null)
           discs=new ArrayList<discount>();
       return discs;
   }
   public void setSumPriceItem(double value)
   {
       this.sumPriceItem=value;
   }
   public void printidofitem()
   {
       System.out.println("The id of item of Order is: "+String.format("%d",this.id));
   }
   public void printnaneitem()
   {
       System.out.println("The Nmae Of Item Of Order is: "+String.format("%s",this.nameItem));
   }
   public void printWayToBuyItem()
   {
       System.out.println("The way to buy item in order according to: "+String.format("%s",this.purItem));
   }
   public void printprceunititem()
   {
       System.out.println("The unit price item is: "+String.format("%.2f",this.priceItem));
   }
   public void printcountitems()
   {
       System.out.println("THe Count Of Items That You give is: "+String.format("%.2f",this.countItemToOrder));
   }
   public void printSumPrice()
   {
       System.out.println("The Sum Price in order is: "+String.format("%.2f",(double)(this.priceItem*this.countItemToOrder)));
   }

    public String getNameStoreManegerOfItem() {
        return nameStoreManegerOfItem;
    }

    public void setNameStoreManegerOfItem(String nameStoreManegerOfItem) {
        this.nameStoreManegerOfItem = nameStoreManegerOfItem;
    }
}
