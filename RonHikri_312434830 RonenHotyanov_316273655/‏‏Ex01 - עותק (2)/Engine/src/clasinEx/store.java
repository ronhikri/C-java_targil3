package clasinEx;


import generated.SDMStore;

public class store {
    protected String name;
    protected int delivery;
    protected location Location;
    protected prices price;
    protected int id;
    private discounts discs;
    private String nameStoreManege;

    public  void createnewInstance(SDMStore SdStore, store s)
    {
        s.SetId(SdStore.getId());
        s.SetName(SdStore.getName());
        s.Setdeliver(SdStore.getDeliveryPpk());
        prices PRICES=new prices();
        PRICES.newInstance(SdStore.getSDMPrices(),PRICES);
        s.setPrice(PRICES);
        location Locate=new location();
        Locate.newInstance(SdStore.getLocation(),Locate);
        s.setLocation(Locate);
        discounts discss=new discounts();
        discss.createDiscounts(SdStore.getSDMDiscounts(),discss);
        s.setDiscs(discss);
    }

    public String getName() {
        return this.name;
    }

    public void SetName(String value) {
        this.name = value;
    }

    public Integer getDelivery() {
        return this.delivery;
    }

    public void Setdeliver(Integer value) {
        this.delivery = value;
    }

    public location getLocation() {
        return this.Location;
    }

    public void setLocation(location value) {
        this.Location = value;
    }

    public prices getPrice() {
        return this.price;
    }

    public void setPrice(prices value) {
        this.price = value;
    }

    public int getId() {
        return this.id;
    }

    public void SetId(int value) {
        this.id = value;
    }
    public discounts getDiscs()
    {
        return this.discs;
    }
    public void setDiscs(discounts value)
    {
        this.discs=value;
    }

    public String getNameStoreManege() {
        return nameStoreManege;
    }

    public void setNameStoreManege(String nameStoreManege) {
        this.nameStoreManege = nameStoreManege;
    }
}


