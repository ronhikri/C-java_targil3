package clasinEx;
import java.lang.String;

public class printitem {
private item Item;
private sell sel;

    public printitem(item product,sell sold)
{
    Item=product;
    sel=sold;
}
public item getItem()
{
    return this.Item;
}
public void setItem(item value)
{
    this.Item=value;
}
public  sell getSel()
{
    return this.sel;
}
public void setSel(sell value)
{
    this.sel=value;
}
public void aid()
{
    System.out.println("The Id Of Item Is: "+String.format("%d",Item.getId()));
}
public void nameItem()
    {
        System.out.println("The Name Of Item Is: "+String.format("%s",Item.getName()));
    }
    public void WayToBuy()
    {
        System.out.println("The Way To Purchase is: "+String.format("%s",Item.getPurchasecategory()));
    }

    public void priceunit()
    {
        System.out.println("The Price Of Item per Unit in Store is: "+String.format("%.2f",sel.getPrice()));
    }

}


