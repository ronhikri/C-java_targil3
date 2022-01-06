package clasinEx;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class orderDinamy implements Serializable {
    private LocalDate date;
    private int cordinata_x;
    private int cordinata_y;
    private int idCountOrder;
    private int idCustomer;
    private ArrayList<itemToOrderDinamy>itemsdinamy;

    public orderDinamy(int countorder,LocalDate datey,int x,int y,ArrayList<itemToOrderDinamy>Listitemsdinamy)
    {
        this.idCountOrder=countorder;
        this.date=datey;
        this.cordinata_x=x;
        this.cordinata_y=y;
        this.itemsdinamy=Listitemsdinamy;
    }
    public orderDinamy()
    {
        itemsdinamy=new ArrayList<>();

    }
    public LocalDate getDate()
    {
        return this.date;
    }
    public void setDate(LocalDate value)
    {
        this.date=value;
    }
    public int getIdCountOrder()
    {
        return this.idCountOrder;
    }
    public void setIdCountOrder(int value)
    {
        this.idCountOrder=value;
    }
    public int getCordinata_x()
    {
        return this.cordinata_x;
    }
    public void setCordinata_x(int value)
    {
        this.cordinata_x=value;
    }
    public int getCordinata_y()
    {
        return this.cordinata_y;
    }
    public void setCordinata_y(int value)
    {
        this.cordinata_y=value;
    }
    public void setIdCustomer(int value)
    {
        this.idCustomer=value;
    }
    public int getIdCustomer()
    {
        return this.idCustomer;
    }
    public ArrayList<itemToOrderDinamy>getItemsdinamy()
    {
        if(itemsdinamy==null)
            itemsdinamy=new ArrayList<itemToOrderDinamy>();
        return this.itemsdinamy;
    }
    public void conclusion()
    {
        for(itemToOrderDinamy Itemorderdinamy:this.getItemsdinamy())
        {
            Itemorderdinamy.printIOfStoreOfItem();
            Itemorderdinamy.nameStoreOfItem();
            Itemorderdinamy.printidofitem();
            Itemorderdinamy.printnaneitem();
            Itemorderdinamy.printWayToBuyItem();
            Itemorderdinamy.printprceunititem();
            Itemorderdinamy.printcountitems();
            Itemorderdinamy.printSumPrice();
            double distance_x=(double)(this.cordinata_y-Itemorderdinamy.getSpace().getX());
            double distance_y=(double)(this.cordinata_y-Itemorderdinamy.getSpace().getY());
            double distance=Math.pow(distance_x,2)+Math.pow(distance_y,2);
            double distancesqrt=Math.sqrt(distance);
            double priceSending=distancesqrt*(double)(Itemorderdinamy.getPpk());
            double cost=priceSending+Itemorderdinamy.getSumPriceItem();
            System.out.println("The pricesending of dinamy order for this store is: "+String.format("%.2f",priceSending));
            System.out.println("The cost of dinamy order for this store is: "+String.format("%.2f",cost));

        }
    }
    public void printCounterIdOrder()
    {
        System.out.println("The idOfNumberOrder is: "+String.format("%d",this.getIdCountOrder()));
    }
    public void PrintDateOrder()
    {
        System.out.println("The Date of the this order is: "+String.format("%s",this.getDate()));
    }
    public void printidOfStoresandNameStores()
    {
        for(itemToOrderDinamy itemindinamyorder:this.getItemsdinamy())
        {
            System.out.println("The Id Of Store That selected in dinamy order is: "+String.format("%d",itemindinamyorder.getIdOfStoreOfItem()));
            System.out.println("The name of store that selected in dinamy order is: "+String.format("%s",itemindinamyorder.getNameStoreOfItem()));
        }
    }

    public void printCountItems()
    {
        double count=0;
        for (itemToOrderDinamy itemdinamyorder:this.getItemsdinamy())
        {
            count=count+itemdinamyorder.getCountItemToOrder();
        }
        System.out.println("The sum of count of items in dinamy order is: "+String.format("%.2f",count));
    }
    public  void kindsitems()
    {
        int count=this.getItemsdinamy().size();
        System.out.println("The count of kinds items in dinamy order is: "+String.format("%d",count));
    }
    public void SumPriceItems()
    {
        double sum=0;
        for(itemToOrderDinamy itemsdinamy:this.getItemsdinamy())
        {
            sum=sum+(itemsdinamy.getCountItemToOrder()*itemsdinamy.getPriceItem());
        }
        System.out.println("The sum price items in this dinamy order is: "+String.format("%.2f",sum));
    }
    public void costSending() {
        for (itemToOrderDinamy Itemorderdinamy : this.getItemsdinamy()) {
            double distance_x=(double)(this.cordinata_y-Itemorderdinamy.getSpace().getX());
            double distance_y=(double)(this.cordinata_y-Itemorderdinamy.getSpace().getY());
            double distance=Math.pow(distance_x,2)+Math.pow(distance_y,2);
            double distancesqrt=Math.sqrt(distance);
            double priceSending=distancesqrt*(double)(Itemorderdinamy.getPpk());
            System.out.println("The pricesending of dinamy order for this store is: "+String.format("%.2f",priceSending));
        }
    }
    public void costsumorder()
    {
        for(itemToOrderDinamy Itemorderdinamy:this.getItemsdinamy())
        {
            double distance_x=(double)(this.cordinata_y-Itemorderdinamy.getSpace().getX());
            double distance_y=(double)(this.cordinata_y-Itemorderdinamy.getSpace().getY());
            double distance=Math.pow(distance_x,2)+Math.pow(distance_y,2);
            double distancesqrt=Math.sqrt(distance);
            double priceSending=distancesqrt*(double)(Itemorderdinamy.getPpk());
            double cost=priceSending+Itemorderdinamy.getSumPriceItem();
            System.out.println("The cost of dinamy order for this store is: "+String.format("%.2f",cost));
        }
    }
    public void Add(itemToOrderDinamy it)
    {
        itemsdinamy.add(it);
    }

    public double countItemsinorder()
    {
        double count=0;
        for(itemToOrderDinamy it:this.getItemsdinamy())
        {
            count=count+it.getCountItemToOrder();
        }
        return count;
    }
    public double PriceSumItems()
    {
        double price=0;
        for(itemToOrderDinamy it:this.getItemsdinamy())
        {
            price=price+it.getSumPriceItem()+it.getPricemadeDiscount();
        }
        return price;
    }
    public int sumStoreaInOrder()
    {
        int count=0;
        int sumstore=0;
        for(int i=0;i<this.getItemsdinamy().size()-1;i++)
        {
            for(int j=i+1;j<this.getItemsdinamy().size();j++)
            {
                if(this.getItemsdinamy().get(i).getIdOfStoreOfItem()==this.getItemsdinamy().get(j).getIdOfStoreOfItem())
                    count++;
            }
            if(count==1)
                sumstore++;
            count=0;
        }
        return (sumstore+1);
    }
    public double sumsending(int xCust,int yCust)
    {
        double sumsend=0;
        int count=0;
       for (int i=0;i<this.getItemsdinamy().size()-1;i++)
       {
           for(int j=i+1;j<this.getItemsdinamy().size();j++)
           {
               if(this.getItemsdinamy().get(i).getIdOfStoreOfItem()==this.getItemsdinamy().get(j).getIdOfStoreOfItem())
                   count++;
           }
           if(count==0)
           {
               int hefreshX=xCust-itemsdinamy.get(i).getSpace().getX();
               int hefreshY=yCust-itemsdinamy.get(i).getSpace().getY();
               double hefreshribuyi=Math.pow((double)hefreshX,2)+Math.pow((double)hefreshY,2);
               double send=Math.sqrt(hefreshribuyi);
               sumsend=sumsend+send*itemsdinamy.get(i).getPpk();
           }
       }
       int i=this.getItemsdinamy().size()-1;
        int hefreshX=xCust-itemsdinamy.get(i).getSpace().getX();
        int hefreshY=yCust-itemsdinamy.get(i).getSpace().getY();
        double hefreshribuyi=Math.pow((double)hefreshX,2)+Math.pow((double)hefreshY,2);
        double send=Math.sqrt(hefreshribuyi);
        sumsend=sumsend+send*itemsdinamy.get(i).getPpk();
        return sumsend;
    }

}
