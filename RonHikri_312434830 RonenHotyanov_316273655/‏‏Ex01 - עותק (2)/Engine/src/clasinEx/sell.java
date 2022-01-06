package clasinEx;


import generated.SDMSell;

public class sell {

    private double price;
    private int id;

    public  void creaeInstance(SDMSell SDsell, sell s)
    {
        s.setId(SDsell.getItemId());
        s.setPrice((double)SDsell.getPrice());
    }
    public sell()
    {

    }

    public double getPrice()
    {
        return this.price;
    }
    public void setPrice(double value)
    {
        this.price=value;
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
