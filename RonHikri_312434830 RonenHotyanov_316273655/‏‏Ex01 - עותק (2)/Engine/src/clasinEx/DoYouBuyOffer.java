package clasinEx;

import generated.IfYouBuy;

public class DoYouBuyOffer  {
    private double quantity;
    private int id;

    public void createBuyOffer(IfYouBuy sdmBuy, DoYouBuyOffer Buy)
    {
        Buy.setId(sdmBuy.getItemId());
        Buy.setQuantity(sdmBuy.getQuantity());

    }

    public int getId()
    {
        return this.id;
    }
    public void setId(int value)
    {
        this.id=value;
    }
    public double getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(double value)
    {
        this.quantity=value;
    }

}
