package clasinEx;

public class showItemsToOrder  {

    private Integer idofItem;
    private String idofstoreofitem;
    private String nameStoreOfItem;
    private String nameitem;
    private String howtobuy;
    private String priceUnitItem;

    public Integer getIdofItem()
    {
        return this.idofItem;
    }
    public void setIdofItem(int value)
    {
        this.idofItem=value;
    }

    public String getIdofstoreofitem()
    {
        return this.idofstoreofitem;
    }
    public void setIdofstoreofitem(String  value)
    {
        this.idofstoreofitem=value;
    }

    public String getNameitem() {
        return nameitem;
    }

    public void setNameitem(String nameitem) {
        this.nameitem = nameitem;
    }

    public String getHowtobuy() {
        return howtobuy;
    }

    public void setHowtobuy(String howtobuy) {
        this.howtobuy = howtobuy;
    }

    public String getPriceUnitItem() {
        return priceUnitItem;
    }

    public void setPriceUnitItem(String priceUnitItem) {
        this.priceUnitItem = priceUnitItem;
    }
    public String getNameStoreOfItem()
    {
        return this.nameStoreOfItem;
    }
    public void setNameStoreOfItem(String value)
    {
        this.nameStoreOfItem=value;
    }
}
