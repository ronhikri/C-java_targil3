package clasinEx;

import generated.SDMOffer;

public class offer {
    private double quantity;
    private int id;
    private double priceone;

    public void createOffer(SDMOffer sdmoffer, offer off)
    {
        off.setPriceone((double)sdmoffer.getForAdditional());
        off.setId(sdmoffer.getItemId());
        off.setQuantity(sdmoffer.getQuantity());
    }

    public double getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(double value)
    {
        this.quantity=value;
    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int value)
    {
        this.id=value;
    }
    public double getPriceone()
    {
        return this.priceone;
    }
    public void setPriceone(double value)
    {
        this.priceone=value;
    }
}
