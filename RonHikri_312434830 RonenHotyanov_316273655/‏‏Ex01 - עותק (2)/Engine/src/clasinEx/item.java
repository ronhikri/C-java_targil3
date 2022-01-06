package clasinEx;

import generated.SDMItem;

public class item {

    protected String name;

    protected String Purchasecategory;

protected int id;


     public void createInstanceBySDM(SDMItem sdmItem, item i)
     {
         i.setId(sdmItem.getId());
         i.setName(sdmItem.getName());
         i.setPurchasecategory(sdmItem.getPurchaseCategory());

     }
     public String getName()
{
    return this.name;
}
public void setName(String value)
{
    this.name=value;
}
public String getPurchasecategory()
{
    return this.Purchasecategory;
}
public void setPurchasecategory(String value)
{
    this.Purchasecategory=value;
}
public int getId()
{
    return this.id;
}
public void setId(int value)
    {
        this.id=value;
    }




}

