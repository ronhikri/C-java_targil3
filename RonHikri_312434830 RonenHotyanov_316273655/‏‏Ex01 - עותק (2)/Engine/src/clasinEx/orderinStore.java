package clasinEx;


public class orderinStore {
    private Integer idOrd;
    private String date;
    private String nameCust;
    private int cordinataX;
    private int CordinataY;
    private Double countItems;
    private Double SumPriceItems;
    private Double priceSending;
    private Double costOrder;

    public Integer getId() {
        return idOrd;
    }

    public void setId(Integer id) {
        this.idOrd = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameCust() {
        return nameCust;
    }

    public void setNameCust(String nameCust) {
        this.nameCust = nameCust;
    }

    public int getCordinataX() {
        return cordinataX;
    }

    public void setCordinataX(int cordinataX) {
        this.cordinataX = cordinataX;
    }

    public int getCordinataY() {
        return CordinataY;
    }

    public void setCordinataY(int cordinataY) {
        CordinataY = cordinataY;
    }

    public Double getCountItems() {
        return countItems;
    }

    public void setCountItems(Double countItems) {
        this.countItems = countItems;
    }

    public Double getSumPriceItems() {
        return SumPriceItems;
    }

    public void setSumPriceItems(Double sumPriceItems) {
        SumPriceItems = sumPriceItems;
    }

    public Double getPriceSending() {
        return priceSending;
    }

    public void setPriceSending(Double priceSending) {
        this.priceSending = priceSending;
    }

    public Double getCostOrder() {
        return costOrder;
    }

    public void setCostOrder(Double costOrder) {
        this.costOrder = costOrder;
    }
}
