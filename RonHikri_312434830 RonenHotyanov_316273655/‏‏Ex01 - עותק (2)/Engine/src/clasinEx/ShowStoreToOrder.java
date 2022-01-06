package clasinEx;

public class ShowStoreToOrder {

    private Integer idOfStore;
    private String nameStore;

    private Integer Cordinatax;
    private Integer Cordinatay;
    private Double Ditance;
    private Integer ppk;
    private Double priceSend;
    private Integer amountKindsItems;
    private Double sumPrices;

    public Integer getIdOfStore() {
        return idOfStore;
    }

    public void setIdOfStore(Integer idOfStore) {
        this.idOfStore = idOfStore;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public Integer getCordinatax() {
        return Cordinatax;
    }

    public void setCordinatax(Integer cordinatax) {
        Cordinatax = cordinatax;
    }

    public Integer getCordinatay() {
        return Cordinatay;
    }

    public void setCordinatay(Integer cordinatay) {
        Cordinatay = cordinatay;
    }

    public Double getDitance() {
        return Ditance;
    }

    public void setDitance(Double ditance) {
        Ditance = ditance;
    }

    public Integer getPpk() {
        return ppk;
    }

    public void setPpk(Integer ppk) {
        this.ppk = ppk;
    }

    public Double getPriceSend() {
        return priceSend;
    }

    public void setPriceSend(Double priceSend) {
        this.priceSend = priceSend;
    }

    public Integer getAmountKindsItems() {
        return amountKindsItems;
    }

    public void setAmountKindsItems(Integer amountKindsItems) {
        this.amountKindsItems = amountKindsItems;
    }

    public Double getSumPrices() {
        return sumPrices;
    }

    public void setSumPrices(Double sumPrices) {
        this.sumPrices = sumPrices;
    }
}
