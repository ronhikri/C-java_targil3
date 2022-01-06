package clasinEx;

public class privateDataOrder {

    private  int idorder;
    private String Date;
    private int CordinataX;
    private int CordinataY;
    private int SumStores;
    private double SumCountItems;
    private double sumPriceItems;
    private double sumSending;
    private double CostSumOrder;

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getCordinataX() {
        return CordinataX;
    }

    public void setCordinataX(int cordinataX) {
        CordinataX = cordinataX;
    }

    public int getCordinataY() {
        return CordinataY;
    }

    public void setCordinataY(int cordinataY) {
        CordinataY = cordinataY;
    }

    public int getSumStores() {
        return SumStores;
    }

    public void setSumStores(int sumStores) {
        SumStores = sumStores;
    }

    public double getSumCountItems() {
        return SumCountItems;
    }

    public void setSumCountItems(double sumCountItems) {
        SumCountItems = sumCountItems;
    }

    public double getSumPriceItems() {
        return sumPriceItems;
    }

    public void setSumPriceItems(double sumPriceItems) {
        this.sumPriceItems = sumPriceItems;
    }

    public double getSumSending() {
        return sumSending;
    }

    public void setSumSending(double sumSending) {
        this.sumSending = sumSending;
    }

    public double getCostSumOrder() {
        return CostSumOrder;
    }

    public void setCostSumOrder(double costSumOrder) {
        CostSumOrder = costSumOrder;
    }
}
