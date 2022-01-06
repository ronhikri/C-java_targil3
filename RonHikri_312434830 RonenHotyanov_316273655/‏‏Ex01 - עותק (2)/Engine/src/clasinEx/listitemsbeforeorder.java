package clasinEx;

import java.util.ArrayList;

public class listitemsbeforeorder {
    private store Store;
    private items Items;

    public listitemsbeforeorder(store s,items I)
    {
        Store=s;
        Items=I;
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
    public void PrintItems()
    {
        boolean found=false;
        for(item Item:Items.getItems()) {
            found=false;
            int i=0;
            while (!found && i < Store.getPrice().getSells().size()) {
                if (Item.getId() == Store.getPrice().getSells().get(i).getId())
                    found = true;
                else
                    i++;
            }

            System.out.println("The Id of item is: " + String.format("%d", Item.getId()));
            System.out.println("The name of item is: "+String.format("%s",Item.getName()));
            System.out.println("The way to buy the item according to: "+String.format("%s",Item.getPurchasecategory()));
            if(found)
            {
                System.out.println("The Price of unit item is: "+String.format("%.2f",Store.getPrice().getSells().get(i).getPrice()));
            }
            else
            {
                System.out.println("The Item"+String.format("%s",Item.getName())+"is not sold in the store");
            }

        }
    }
}
