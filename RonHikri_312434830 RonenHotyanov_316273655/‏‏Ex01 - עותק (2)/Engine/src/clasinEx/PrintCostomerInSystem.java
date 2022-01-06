package clasinEx;

public class PrintCostomerInSystem {
    private Integer idOfCostomer;
    private String NameCostomer;
    private Integer CordnataX;
    private Integer CordinataY;
    private Integer SumOrders;
    private Double avgPriceOrders;
    private Double avgSendingOrders;


    public Integer getIdOfCostomer() {
        return idOfCostomer;
    }

    public void setIdOfCostomer(Integer idOfCostomer) {
        this.idOfCostomer = idOfCostomer;
    }

    public String getNameCostomer() {
        return NameCostomer;
    }

    public void setNameCostomer(String nameCostomer) {
        NameCostomer = nameCostomer;
    }

    public Integer getCordnataX() {
        return CordnataX;
    }

    public void setCordnataX(Integer cordnataX) {
        CordnataX = cordnataX;
    }

    public Integer getCordinataY() {
        return CordinataY;
    }

    public void setCordinataY(Integer cordinataY) {
        CordinataY = cordinataY;
    }

    public Integer getSumOrders() {
        return SumOrders;
    }

    public void setSumOrders(Integer sumOrders) {
        SumOrders = sumOrders;
    }

    public Double getAvgPriceOrders() {
        return avgPriceOrders;
    }

    public void setAvgPriceOrders(Double avgPriceOrders) {
        this.avgPriceOrders = avgPriceOrders;
    }

    public Double getAvgSendingOrders() {
        return avgSendingOrders;
    }

    public void setAvgSendingOrders(Double avgSendingOrders) {
        this.avgSendingOrders = avgSendingOrders;
    }
}
