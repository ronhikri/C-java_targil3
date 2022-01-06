package clasinEx;


public class printItemsInSystem {
    // private item Item;
    //private stores Stores;

    private int idofItem;
    private String nameitem;
    private String buyitem;
    private  int countitemsStores;
    private double avgpriceofitem;
    private double countItemsInOrders;


    /*/  public printItemsInSystem(item It,stores st)
      {
          this.Item=It;
          this.Stores=st;

      }/*/
    public printItemsInSystem(int id, String name, String buyiten, Integer countitemstores, double avg, double countitemsorders) {
        this.idofItem = id;
        this.nameitem = name;
        this.buyitem = buyiten;
        this.countitemsStores = countitemstores;
        this.avgpriceofitem = avg;
        this.countItemsInOrders = countitemsorders;
    }

    /*/public item getItem()
    {
        return this.Item;
    }/*/
    /*/public void setItem(item value)
    {
        this.Item=value;
    }/*/
    /*/public stores getStores()
    {
        return this.Stores;
    }/*/
    /*/public void setStores(stores value)
    {
        this.Stores=value;
    }/*/


    /*/public void printId()
    {
        System.out.println("The Id Of Item is: "+String.format("%d",Item.getId()));
    }/*/
    public Integer getIdofItem() {
        return this.idofItem;
    }

    public void setIdofItem(int value) {
        this.idofItem = value;
    }
    public String getNameitem() {
        return this.nameitem;
    }

    public void setNameitem(String value) {
        this.nameitem = value;
    }



    public String getBuyitem() {
        return this.buyitem;
    }
    public void setBuyitem(String value)
    {
        this.buyitem=value;
    }

    public Integer getCountitemsStores() {
        return this.countitemsStores;
    }
    public void setCountitemsStores(int value) {
        this.countitemsStores = value;
    }

    public Double getAvgpriceofitem() {
        return this.avgpriceofitem;
    }


    public void setAvgpriceofitem(double value) {
        this.avgpriceofitem = value;
    }
    public Double getCountItemsInOrders() {
        return this.countItemsInOrders;
    }

    public void setCountItemsInOrders(double value) {
        this.countItemsInOrders = value;
    }

}

  /*/  public int countItemSoldInStores() {
        int count = 0;
        for (store Store : Stores.getStoress()) {
            for (sell sel : Store.getPrice().getSells()) {
                if (Item.getId() == sel.getId()) {
                    count++;
                    break;
                }
            }

        }
        return count;

    }/*/


    /*/public void printMName()
    {
        System.out.println("The Name of item is: "+String.format("%s",Item.getName()));
    }/*/
    /*/public void buyToWay()
    {
        System.out.println("The Way To buy item is: "+String.format("%s",Item.getPurchasecategory()));
    }/*/
    /*/public void CountitemsInStores()
    {
        int count=0;
        for(store Store:Stores.getStoress() )
        {
            for(sell sel: Store.getPrice().getSells())
            {
                if(Item.getId()==sel.getId()) {
                    count++;
                    break;
                }
            }

        }
        System.out.println("Count Of Stores that sold item: "+String.format("%d",count));

    }/*/
    /*/public double AvgPriceItemIntStores()
    {
        double sum=0;
        double avg=0;
        int count=0;
        for(store Store:Stores.getStoress())
        {
            for(sell sel:Store.getPrice().getSells())
            {
                if(Item.getId()==sel.getId())
                {
                    count++;
                    sum+=sel.getPrice();
                    break;
                }
            }
        }
        double counter=(double)count;
        avg=sum/counter;
        return avg;
    }
    public void AvgOfpriceItem()
    {
        double sum=0;
        double avg=0;
        int count=0;
        for(store Store:Stores.getStoress())
        {
            for(sell sel:Store.getPrice().getSells())
            {
                if(Item.getId()==sel.getId())
                {
                    count++;
                    sum+=sel.getPrice();
                    break;
                }
            }
        }
        double counter=(double)count;
        avg=sum/counter;
        System.out.println("The price of the item is: "+String.format("%.2f",avg));
    }
    public void printCountItemsSold()
    {
        System.out.println("The count that item is sold in all the orders is: "+String.format("%.2f",this.getCountItemsInOrders()));
    }/*/
