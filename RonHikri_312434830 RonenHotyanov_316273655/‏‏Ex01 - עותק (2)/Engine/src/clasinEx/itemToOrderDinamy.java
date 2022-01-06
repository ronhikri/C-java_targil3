package clasinEx;

import java.io.Serializable;
import java.util.ArrayList;

public class itemToOrderDinamy extends itemToOrder implements Serializable {
    private String nameStoreOfItem;
    private int idOfStoreOfItem;
    private location space;
    private int ppk;


public itemToOrderDinamy(int idofstore,String namestore,int ppkStore,location l,int Id, String name, String purc, double price, double count, double sum,ArrayList<discount>diss)
{
    super(Id,name , purc, price, count,  sum,diss);
    this.idOfStoreOfItem=idofstore;
    this.nameStoreOfItem=namestore;
    this.space=l;
    this.ppk=ppkStore;
}
public itemToOrderDinamy(ArrayList<discount>disx)
{
    super(disx);
}
public itemToOrderDinamy()
{

}
public  int getIdOfStoreOfItem()
{
    return this.idOfStoreOfItem;
}
public void setIdOfStoreOfItem(int value)
{
    this.idOfStoreOfItem=value;
}
public String getNameStoreOfItem()
{
    return this.nameStoreOfItem;
}
public void setNameStoreOfItem(String value)
{
    this.nameStoreOfItem=value;
}
public int getPpk()
{
    return this.ppk;
}
public void setPpk(int value)
{
    this.ppk=value;
}

public  location getSpace()
{
    return this.space;
}
public void setSpace(location value)
{
    this.space=value;
}
public void printIOfStoreOfItem()
{
    System.out.println("The Id Of Store That Items is: "+String.format("%d",this.getIdOfStoreOfItem()));
}
public void nameStoreOfItem()
{
    System.out.println("The Nmae Of Store Of Item is: "+String.format("%s",this.getNameStoreOfItem()));
}

}
