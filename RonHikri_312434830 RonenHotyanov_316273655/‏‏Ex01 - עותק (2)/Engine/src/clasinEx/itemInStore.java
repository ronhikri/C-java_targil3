package clasinEx;

public class itemInStore {

    private Integer idOfItem;
    private String nameOfItem;
    private String howToBuy;
    private Double priceUnitOfItem;
    private Double SUMitemSold;

    public  itemInStore(int id,String name,String watyobuy,double priceitem,double sumitemssold)
    {
        this.idOfItem=id;
        this.nameOfItem=name;
        this.howToBuy=watyobuy;
        this.priceUnitOfItem=priceitem;
        this.SUMitemSold=sumitemssold;
    }
    public Integer getIdOfItem()
    {
        return this.idOfItem;
    }
    public void setIdOfItem(int value)
    {
        this.idOfItem=value;
    }
    public String getNameOfItem()
    {
        return this.nameOfItem;
    }
    public void setNameOfItem(String value)
    {
        this.nameOfItem=value;
    }
    public String getHowToBuy()
    {
        return this.howToBuy;
    }
    public void setHowToBuy(String value)
    {
        this.howToBuy=value;
    }
    public Double getPriceUnitOfItem()
    {
        return this.priceUnitOfItem;
    }
    public void setPriceUnitOfItem(double value)
    {
        this.priceUnitOfItem=value;
    }
    public Double getSUMitemSold()
    {
        return this.SUMitemSold;
    }
    public void setSUMitemSold(double value)
    {
        this.SUMitemSold=value;
    }
}
