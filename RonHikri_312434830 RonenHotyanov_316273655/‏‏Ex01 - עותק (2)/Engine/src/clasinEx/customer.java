package clasinEx;

import generated.Location;
import generated.SDMCustomer;

public class customer {

    private String name;
    private location Location;
    private int id;

    public void createCustomer(SDMCustomer Sdmc,customer cust)
    {
        cust.setName(Sdmc.getName());
        cust.setId(Sdmc.getId());
        location locate=new location();
        locate.newInstance(Sdmc.getLocation(),locate);
        cust.setLocation(locate);
    }
    public customer createcust(String name,int id,int x,int y)
    {
        customer c=new customer();
        c.setId(id);
        c.setName(name);
       location l=new location();
       l.setX(x);
       l.setY(y);
       c.setLocation(l);
       return c;

    }
    public customer()
    {

    }
    public String getName()
    {
        return this.name;
    }
    public  void setName(String value)
    {
        this.name=value;
    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int value)
    {
        this.id=value;
    }
    public location getLocation()
    {
        return this.Location;
    }
    public void setLocation(location value)
    {
        this.Location=value;
    }

}
