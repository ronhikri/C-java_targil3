package clasinEx;

import generated.SDMDiscount;

public class discount {
    private String name;

    private DoYouBuyOffer Buy;

    private  YouGetOffer getoffer;

    public void createDiscount(SDMDiscount sdmdiscount, discount disc)
    {
        DoYouBuyOffer DoBuy=new DoYouBuyOffer();
        DoBuy.createBuyOffer(sdmdiscount.getIfYouBuy(),DoBuy);
        disc.setBuy(DoBuy);
        YouGetOffer get=new YouGetOffer();
        get.createYouGetOffer(sdmdiscount.getThenYouGet(),get);
        disc.setGetoffer(get);
        disc.setName(sdmdiscount.getName());
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String value)
    {
        this.name=value;
    }
    public DoYouBuyOffer getBuy()
    {
        return this.Buy;
    }
    public void setBuy(DoYouBuyOffer value)
    {
        this.Buy=value;
    }
    public YouGetOffer getGetoffer()
    {
        return this.getoffer;
    }
    public void setGetoffer(YouGetOffer value)
    {
        this.getoffer=value;
    }
}
