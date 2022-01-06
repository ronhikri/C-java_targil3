package clasinEx;

import java.util.ArrayList;

public class storesInSystem {

    private Integer idStore;
    private String nameSore;
    private String StoreManeger;
    private String locationOfStore;
    private Integer sumordersOfStore;
    private double costOfItemsThatSold;
    private Integer ppk;
    private double sumCostOfOrdersInStore;
    private ArrayList<itemInStore>list;

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {

        this.idStore = idStore;
    }

    public String getNameSore() {
        return nameSore;
    }

    public void setNameSore(String nameSore) {
        this.nameSore = nameSore;
    }

    public String getStoreManeger() {
        return StoreManeger;
    }

    public void setStoreManeger(String storeManeger) {
        StoreManeger = storeManeger;
    }

    public String getLocationOfStore() {
        return locationOfStore;
    }

    public void setLocationOfStore(String locationOfStore) {
        this.locationOfStore = locationOfStore;
    }

    public int getSumordersOfStore() {
        return sumordersOfStore;
    }

    public void setSumordersOfStore(int sumordersOfStore) {
        this.sumordersOfStore = sumordersOfStore;
    }

    public double getCostOfItemsThatSold() {
        return costOfItemsThatSold;
    }

    public void setCostOfItemsThatSold(double costOfItemsThatSold) {
        this.costOfItemsThatSold = costOfItemsThatSold;
    }

    public int getPpk() {
        return ppk;
    }

    public void setPpk(int ppk) {
        this.ppk = ppk;
    }

    public double getSumCostOfOrdersInStore() {
        return sumCostOfOrdersInStore;
    }

    public void setSumCostOfOrdersInStore(double sumCostOfOrdersInStore) {
        this.sumCostOfOrdersInStore = sumCostOfOrdersInStore;
    }

    public ArrayList<itemInStore> getList() {
        return list;
    }

    public void setList(ArrayList<itemInStore> list) {
        this.list = list;
    }
}
