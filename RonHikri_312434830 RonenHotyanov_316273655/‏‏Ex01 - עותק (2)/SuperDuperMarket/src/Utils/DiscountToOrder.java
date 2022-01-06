package Utils;

public class DiscountToOrder {

    private String nameofDiscount;
    private int idOfDisc;
    private String nameItemDiscount;
    private double quantityitemDisc;
    private String OperationDiscount;

    public String getNameofDiscount() {
        return nameofDiscount;
    }

    public void setNameofDiscount(String nameofDiscount) {
        this.nameofDiscount = nameofDiscount;
    }

    public int getIdOfDisc() {
        return idOfDisc;
    }

    public void setIdOfDisc(int idOfDisc) {
        this.idOfDisc = idOfDisc;
    }

    public String getNameItemDiscount() {
        return nameItemDiscount;
    }

    public void setNameItemDiscount(String nameItemDiscount) {
        this.nameItemDiscount = nameItemDiscount;
    }

    public double getQuantityitemDisc() {
        return quantityitemDisc;
    }

    public void setQuantityitemDisc(double quantityitemDisc) {
        this.quantityitemDisc = quantityitemDisc;
    }

    public String getOperationDiscount() {
        return OperationDiscount;
    }

    public void setOperationDiscount(String operationDiscount) {
        OperationDiscount = operationDiscount;
    }
}