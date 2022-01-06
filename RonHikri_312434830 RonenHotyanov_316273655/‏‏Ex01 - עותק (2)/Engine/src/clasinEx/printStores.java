package clasinEx;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;

public class printStores {
    private store Store;
    private items Items;
    private ArrayList<Order>Listorder;
    private ArrayList<orderDinamy>Listorderdinamy;

    public printStores(store s, items it, ArrayList<Order>ListOrder,ArrayList<orderDinamy>od)
    {
        Store=s;
        Items=it;
        Listorder=ListOrder;
        Listorderdinamy=od;
    }
    public store getStore()
    {
        return this.Store;
    }
    public void setStore(store value)
    {
        this.Store=value;
    }
    public items getItems()
    {
        return this.Items;
    }
    public void setItems(items value)
    {
        this.Items=value;
    }

    public void printId()
    {
        System.out.println("The Id Of Store is: "+String.format("%d",Store.getId()));
    }
    public void printName()
    {
        System.out.println("The Name Of The Store is: "+String.format("%s",Store.getName()));
    }
    public void Listconclusion()
    {
        int temp=0;
        System.out.println("ListItems Of The Store: ");
        for(sell sel:Store.getPrice().getSells())
        {
            item product=null;
            for(item Item:Items.getItems())
            {
                if(sel.getId()==Item.getId()) {
                    product=Item;
                    temp=sel.getId();
                    break;

                }
            }
            printitem pitems=new printitem(product,sel);
            pitems.aid();
            pitems.nameItem();
            pitems.WayToBuy();
            pitems.priceunit();
            printCountItemInOrdersOfStore(temp);

        }
        if(Listorder.size()==0)
        {
         System.out.println("no orders in store");
        }
        else {
            System.out.println("The static Orders Of this store: ");
            for (Order order : Listorder) {
                System.out.println("The order: ");
                order.printDate();
                order.printCountOfItems();
                order.sumCostitems();
                order.printPriceSending();
                order.costOrder();

            }
        }
        if(Listorderdinamy.size()==0)
        {
            System.out.println("no orders Dinamy in the store ");
        }
        else
        {
            System.out.println("The Dinamy orders: ");
            for(orderDinamy order:Listorderdinamy)
            {
                System.out.println("The Order: ");
                order.PrintDateOrder();
                order.printCountItems();
                order.SumPriceItems();
                order.costSending();
                order.costsumorder();
            }
        }
        System.out.println("The ppk Of Store is: "+String.format("%d",this.Store.getDelivery()));
        if((Listorder.size()==0)&&(Listorderdinamy.size()==0))
        {
            System.out.println("no orders in store and so the sum counts items is 0");
        }
        else
        {
            printSumSending();
        }
    }
    public void printCountItemsSold()
    {
        double count=0;
        for(Order order:Listorder)
        {
            for(itemToOrder itemtoordr:order.getItemtoorder())
            {
                count=count+itemtoordr.getCountItemToOrder();
            }
        }
        for(orderDinamy order:Listorderdinamy)
        {
            count=count+order.getItemsdinamy().get(0).getCountItemToOrder();
        }
        System.out.println("The sum of items that are sold in store is: "+String.format("%.2f",count));
    }
    public void printCountItemsSoldDinamy()
    {
        double count=0;
        for(orderDinamy order:Listorderdinamy)
        {
            for(itemToOrder itemtoordr:order.getItemsdinamy())
            {
                count=count+itemtoordr.getCountItemToOrder();
            }
        }
        System.out.println("The sum of items that are sold in store is: "+String.format("%.2f",count));
    }

    public void printSumSending()
    {
        double costOrder=0;
        for(Order order:Listorder) {
            double distanceX = (order.getCordinata_x()-order.getLoation().getX());
            double distanceY = (order.getCordinata_y() - order.getLoation().getY());
            double distance = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
            double distancesqrt = (double) Math.sqrt(distance);
            double priceSending = (double) (distancesqrt * order.getPpk());
            double sumprice=0;
            for(itemToOrder itemtoorder:order.getItemtoorder())
            {
                sumprice=sumprice+itemtoorder.getSumPriceItem();
            }
            costOrder=costOrder+(sumprice+priceSending);
        }
        for (orderDinamy order:Listorderdinamy)
        {
            double distancex=(order.getCordinata_x()-order.getItemsdinamy().get(0).getSpace().getX());
            double distancey=(order.getCordinata_y()-order.getItemsdinamy().get(0).getSpace().getY());
            double distance=Math.pow(distancex,2)+Math.pow(distancey,2);
            double distanceqrt=(double)Math.sqrt(distance);
            double priceSending=(double)(distanceqrt*(order).getItemsdinamy().get(0).getPpk());
            double sumprice=0;
            for(itemToOrderDinamy itemdinamy:order.getItemsdinamy())
            {
                sumprice=sumprice+itemdinamy.getSumPriceItem();
            }
            costOrder=costOrder+(sumprice+priceSending);
        }
        System.out.println("The cost of sending of the store is: "+String.format("%.2f",costOrder));
    }
     public void printCountItemInOrdersOfStore(int temp)
     {
         double count=0;
         for(Order order:Listorder)
         {
             for(itemToOrder itemtoorder:order.getItemtoorder())
             {
                 if(itemtoorder.getId()==temp)
                 {
                     count=count+itemtoorder.getCountItemToOrder();
                     break;
                 }
             }
         }
         for(orderDinamy order:Listorderdinamy)
         {
             for(itemToOrderDinamy itemstoordrdinamy:order.getItemsdinamy())
             {
                 if(itemstoordrdinamy.getId()==temp)
                 {
                     count=count+itemstoordrdinamy.getCountItemToOrder();
                     break;
                 }
             }
         }
         System.out.println("The count of this item that sold in store: "+String.format("%.2f",count));
     }




}
