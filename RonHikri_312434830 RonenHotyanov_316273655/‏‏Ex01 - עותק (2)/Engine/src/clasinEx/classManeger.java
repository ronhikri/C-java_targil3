package clasinEx;
import exceptions.*;
import generated.SDMCustomers;
import generated.SuperDuperMarketDescriptor;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class classManeger {

    private stores Stores;
    private items Items;
    private customers Icostomers;
    private ArrayList<itemToOrder> itemtoorder;
    private ArrayList<itemToOrderDinamy> itemsdinamyorder;
    private ArrayList<orderDinamy> ListDinamyOrder;
    private ArrayList<Order> Listorder;
    private Zone zoni;
    private String nameStoreMan;
    private String roleOfUser;

    public void create(SuperDuperMarketDescriptor SDM_Super, classManeger obj) {
        Zone z = new Zone();
        z.create(SDM_Super.getSDMZone(), z);
        obj.setZoni(z);
        SDMCustomers custs = null;
        stores s = new stores();
        s.newinstance(SDM_Super.getSDMStores(), s);
        obj.Stores = s;
        items i = new items();
        i.newInstance(SDM_Super.getSDMItems(), i);
        obj.Items = i;
        customers c = new customers();
        c.createCuatomers(custs, c);
        obj.Icostomers = c;
        obj.initiall();
        Listorder = new ArrayList<Order>();
        ListDinamyOrder = new ArrayList<orderDinamy>();

    }

    public void setNameStoreMan(String name) {
        this.nameStoreMan = name;
    }

    public void setRoleOfUser(String value) {
        this.roleOfUser = value;
    }

    public ArrayList<Order> getListorder() {
        return this.Listorder;
    }

    public ArrayList<orderDinamy> getListDinamyOrder() {
        return this.ListDinamyOrder;
    }

    public void initiall() {
        itemtoorder = new ArrayList<itemToOrder>();

    }

    public ArrayList<itemToOrder> getItemtoorder() {
        return this.itemtoorder;
    }

    public ArrayList<itemToOrderDinamy> getItemsdinamyorder() {
        return this.itemsdinamyorder;
    }

    public void additemorder(itemToOrder it) {
        itemtoorder.add(it);
    }

    public void additemdinamyorder(itemToOrderDinamy it) {
        itemsdinamyorder.add(it);
    }

    public void initiall2() {
        itemsdinamyorder = new ArrayList<itemToOrderDinamy>();
    }

    public void setZoni(Zone z) {
        this.zoni = z;
    }

    public Zone getZoni() {
        return this.zoni;
    }

    public stores getStores() {
        return this.Stores;
    }

    public void setStores(stores value) {
        this.Stores = value;
    }

    public items getItems() {
        return this.Items;
    }

    public void setItems(items value) {
        this.Items = value;
    }

    public customers getIcostomers() {
        return this.Icostomers;
    }

    public void setIcostomers(customers value) {
        this.Icostomers = value;
    }

    public void printStores() {
        for (store Store : Stores.getStoress()) {
            ArrayList<Order> ListOrderOfStore = create(Store.getId());
            ArrayList<orderDinamy> ListorderDinamyofstore = buildListDinamyOrder(Store.getId());
            printStores pstores = new printStores(Store, Items, ListOrderOfStore, ListorderDinamyofstore);
            pstores.printId();
            pstores.printName();
            pstores.Listconclusion();
        }
    }

    public ArrayList<ShowStores> createShowStores() {
        ArrayList<ShowStores> ss = new ArrayList<>();
        for (store s : this.getStores().getStoress()) {
            ShowStores sts = new ShowStores();
            sts.setId(s.getId());
            sts.setName(s.getName());
            sts.setPpk(s.getDelivery());
            sts.setSumsend(sumSendingInStore(s.getId()));
            ss.add(sts);

        }
        return ss;
    }

    public double sumSendingInStore(int idstore) {
        double sumSend = 0;
        store s = null;
        customer cust = null;
        for (store st : this.getStores().getStoress()) {
            if (st.getId() == idstore) {
                s = st;
                break;
            }
        }
        for (Order ord : Listorder) {
            if (ord.getIdOfStore() == idstore) {
                for (customer c : this.getIcostomers().getSdmcustomers()) {
                    if (c.getId() == ord.getIdcust()) {
                        cust = c;
                        break;
                    }
                }
                double hefreshXribuyi = Math.pow((double) (s.getLocation().getX() - cust.getLocation().getX()), 2);
                double hefreshYribuyi = Math.pow((double) (s.getLocation().getY() - cust.getLocation().getY()), 2);
                double sqrtsend = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
                sumSend = sumSend + sqrtsend;
            }
        }
        for (orderDinamy ord : ListDinamyOrder) {
            int i = 0;
            boolean found = false;
            while (!found && i < ord.getItemsdinamy().size()) {
                if (ord.getItemsdinamy().get(i).getIdOfStoreOfItem() == idstore)
                    found = true;
                else
                    i++;
            }
            if (found) {
                for (customer c : this.getIcostomers().getSdmcustomers()) {
                    if (c.getId() == ord.getIdCustomer()) {
                        cust = c;
                        break;
                    }
                }
                double hefreshXribuyi = Math.pow((double) (s.getLocation().getX() - cust.getLocation().getX()), 2);
                double hefreshYribuyi = Math.pow((double) (s.getLocation().getY() - cust.getLocation().getY()), 2);
                double sqrtsend = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
                sumSend = sumSend + sqrtsend;
            }
        }

        return sumSend;
    }

    public ArrayList<orderDinamy> buildListDinamyOrder(int idofstore) {
        int i = 0;
        boolean found = false;
        ArrayList<orderDinamy> listorderD = new ArrayList<orderDinamy>();
        for (orderDinamy order : ListDinamyOrder) {
            i = 0;
            while ((!found) && i < order.getItemsdinamy().size()) {
                if (order.getItemsdinamy().get(i).getIdOfStoreOfItem() == idofstore)
                    found = true;
                else
                    i++;
            }

            if (found) {
                ArrayList<itemToOrderDinamy> LIstitems = new ArrayList<itemToOrderDinamy>();
                LIstitems.add(order.getItemsdinamy().get(i));
                orderDinamy ord = new orderDinamy(order.getIdCountOrder(), order.getDate(), order.getCordinata_x(), order.getCordinata_y(), LIstitems);
                listorderD.add(ord);
            }

        }
        return listorderD;

    }

    public ArrayList<Order> create(int idofstore) {
        ArrayList<Order> storeOrder = new ArrayList<>();
        for (int i = 0; i < Listorder.size(); i++) {
            if (Listorder.get(i).getIdOfStore() == idofstore)
                storeOrder.add(Listorder.get(i));
        }
        return storeOrder;

    }

    /*/ public void printItems() {
         for (item Iten : Items.getItems()) {
             printItemsInSystem itemsystem = new printItemsInSystem(Iten, Stores);
             double count = countItemSoldInOrdrers(Iten.getId());
             itemsystem.setCountItemsInOrders(count);
             itemsystem.printId();
             itemsystem.printMName();
             itemsystem.buyToWay();
             itemsystem.CountitemsInStores();
             itemsystem.AvgOfpriceItem();
             itemsystem.printCountItemsSold();
         }
     }/*/
    public int countItemssoldInStore(int idofitem) {
        int count = 0;
        for (store s : this.getStores().getStoress()) {
            for (sell sel : s.getPrice().getSells()) {
                if (sel.getId() == idofitem) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public double avgpricesitemsinstores(int idofitem) {
        int count = countItemssoldInStore(idofitem);
        double price = 0;
        for (store s : this.getStores().getStoress()) {
            for (sell sel : s.getPrice().getSells()) {
                if (sel.getId() == idofitem) {
                    price = price + sel.getPrice();
                    break;
                }
            }

        }
        double avg = (double) (price / count);
        return avg;
    }

    public ArrayList<printItemsInSystem> CreateItemsInSystem() {
        ArrayList<printItemsInSystem> PrintItems = new ArrayList<>();
        for (item iten : Items.getItems()) {
            int id = iten.getId();
            String name = iten.getName();
            String buyway = iten.Purchasecategory;
            int countitemssoldstores = countItemssoldInStore(id);
            double avg = avgpricesitemsinstores(id);
            double countitemsinorders = countItemSoldInOrdrers(id);
            printItemsInSystem p = new printItemsInSystem(id, name, buyway, countitemssoldstores, avg, countitemsinorders);
            PrintItems.add(p);
        }
        return PrintItems;
    }

    public ArrayList<PrintCostomerInSystem> CreateCustomersInSystem() {
        ArrayList<PrintCostomerInSystem> CusomersSystem = new ArrayList<>();
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            int id = cust.getId();
            String name = cust.getName();
            int cordinatax = cust.getLocation().x;
            int cordinatay = cust.getLocation().y;
            int count = sumOrderdInCustomers(id);
            double avg = avgPriceOrdersinCustomer(id);
            PrintCostomerInSystem pcust = new PrintCostomerInSystem();
            pcust.setIdOfCostomer(id);
            pcust.setNameCostomer(name);
            pcust.setCordnataX(cordinatax);
            pcust.setCordinataY(cordinatay);
            pcust.setSumOrders(count);
            pcust.setAvgPriceOrders(avg);
            pcust.setAvgSendingOrders(avgSendInOrdrs(id));
            CusomersSystem.add(pcust);
        }
        return CusomersSystem;
    }

    public int sumOrderdInCustomers(int idcustomer) {
        int count = 0;
        for (Order ord : Listorder) {
            if (ord.getIdcust() == idcustomer)
                count++;
        }
        for (orderDinamy ord : ListDinamyOrder) {
            if (ord.getIdCustomer() == idcustomer)
                count++;
        }
        return count;
    }

    public double avgPriceOrdersinCustomer(int idcustomer) {
        double sum = 0;
        double sumprice = 0;
        double sumoffers = 0;
        double count = 0;
        double avg = 0;
        for (Order ord : Listorder) {
            if (ord.getIdcust() == idcustomer) {
                count++;
                for (itemToOrder it : ord.getItemtoorder()) {
                    sumprice = sumprice + it.getSumPriceItem();
                    sumoffers = sumoffers + it.getPricemadeDiscount();
                }
            }
        }
        for (orderDinamy ord : ListDinamyOrder) {
            if (ord.getIdCustomer() == idcustomer) {
                count++;
                for (itemToOrderDinamy it : ord.getItemsdinamy()) {
                    sumprice = sumprice + it.getSumPriceItem();
                    sumoffers = sumoffers + it.getPricemadeDiscount();
                }

            }
        }
        sum = sumoffers + sumprice;
        if (count == 0)
            avg = 0;
        else {
            avg = sum / count;
        }

        return avg;
    }

    public double avgSendInOrdrs(int idcustomer) {
        int count = 0;
        int storex = 0;
        int storey = 0;
        double sumSend = 0;
        double countsend = 0;
        double avg = 0;
        customer c = null;
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getId() == idcustomer) {
                c = cust;
                break;
            }
        }
        for (Order ord : Listorder) {
            if (ord.getIdcust() == idcustomer) {
                countsend++;
                for (store s : this.getStores().getStoress()) {
                    if (s.getId() == ord.getIdOfStore()) {
                        storex = s.getLocation().getX();
                        storey = s.getLocation().getY();
                        break;
                    }
                }
                double hefresXribuyi = Math.pow(((double) storex) - (double) (c.getLocation().getX()), 2);
                double hefreshYribuyi = Math.pow(((double) storey) - (double) (c.getLocation().getY()), 2);
                double sendsqrt = Math.sqrt(hefresXribuyi + hefreshYribuyi);
                sumSend = sumSend + ((sendsqrt) * (double) (ord.getPpk()));
            }
        }
        for (orderDinamy ord : ListDinamyOrder) {
            if (ord.getIdCustomer() == idcustomer) {
                count = 0;
                for (int i = 0; i < ord.getItemsdinamy().size() - 1; i++) {
                    for (int j = i + 1; j < ord.getItemsdinamy().size(); j++) {
                        if (ord.getItemsdinamy().get(i).getIdOfStoreOfItem() == ord.getItemsdinamy().get(j).getIdOfStoreOfItem())
                            count++;
                    }
                    if (count == 0) {
                        countsend++;
                        for (store s : this.getStores().getStoress()) {
                            if (s.getId() == ord.getItemsdinamy().get(i).getIdOfStoreOfItem()) {
                                storex = s.getLocation().getX();
                                storey = s.getLocation().getY();
                                break;
                            }
                        }
                        double hefresXribuyi = Math.pow(((double) storex) - (double) (c.getLocation().getX()), 2);
                        double hefreshYribuyi = Math.pow(((double) storey) - (double) (c.getLocation().getY()), 2);
                        double sendsqrt = Math.sqrt(hefresXribuyi + hefreshYribuyi);
                        sumSend = sumSend + ((sendsqrt) * (double) (ord.getItemsdinamy().get(i).getPpk()));
                    }
                    count = 0;
                }
                for (store s : this.getStores().getStoress()) {
                    if (s.getId() == ord.getItemsdinamy().get(ord.getItemsdinamy().size() - 1).getIdOfStoreOfItem()) {
                        storex = s.getLocation().getX();
                        storey = s.getLocation().getY();
                        break;
                    }
                }
                double hefresXribuyi = Math.pow(((double) storex) - (double) (c.getLocation().getX()), 2);
                double hefreshYribuyi = Math.pow(((double) storey) - (double) (c.getLocation().getY()), 2);
                double sendsqrt = Math.sqrt(hefresXribuyi + hefreshYribuyi);
                sumSend = sumSend + ((sendsqrt) * (double) (ord.getItemsdinamy().get(ord.getItemsdinamy().size() - 1).getPpk()));
                countsend++;
            }
        }
        if (countsend == 0)
            avg = 0;
        else
            avg = sumSend / countsend;
        return avg;
    }


    public double countItemSoldInOrdrers(int idOfItem) {
        double count = 0;
        for (Order order : Listorder) {
            boolean found = false;
            int i = 0;
            while (i < order.getItemtoorder().size() && !found) {
                if (order.getItemtoorder().get(i).getId() == idOfItem)
                    found = true;
                else
                    i++;
            }
            if (found) {
                count = count + order.getItemtoorder().get(i).getCountItemToOrder();
            }
        }
        for (orderDinamy order : ListDinamyOrder) {
            boolean found = false;
            int i = 0;
            while (i < order.getItemsdinamy().size() && !found) {
                if (order.getItemsdinamy().get(i).getId() == idOfItem)
                    found = true;
                else
                    i++;
            }
            if (found)
                count = count + order.getItemsdinamy().get(i).getCountItemToOrder();
        }
        return count;
    }

    public void printStoreBeforeOrder() {
        for (store Store : Stores.getStoress()) {
            System.out.println("The Id Of store is: " + String.format("%d", Store.getId()));
            System.out.println("The Name of Store is: " + String.format("%s", Store.getName()));
            System.out.println("The delivery ppk of Store is: " + String.format("%d", Store.getDelivery()));
        }
    }

    public void printItemsBeforeOrder(int idofstore) {
        int i = 0;
        boolean found = false;
        while (!found && i < this.Stores.getStoress().size()) {
            if (idofstore == this.Stores.getStoress().get(i).getId())
                found = true;
            else
                i++;
        }
        store s = this.getStores().getStoress().get(i);
        listitemsbeforeorder itembefore = new listitemsbeforeorder(s, this.getItems());
        itembefore.setItems(this.getItems());
        itembefore.setStore(s);
        itembefore.PrintItems();
    }

    public void printItemsBeforeDinamyOrder() throws IdOfStoreNotFound {
        for (item Item : this.getItems().getItems()) {
            double prices = 0;
            System.out.println("The id of item: " + String.format("%d", Item.getId()));
            System.out.println("The name of item is: " + String.format("%s", Item.getName()));
            System.out.println("The way to buy this item is: " + String.format("%s", Item.getPurchasecategory()));
            int idofstore = idOfStoreItemMinimumPrice(Item.getId());
            store s = Storeret(idofstore);
            for (sell ell : s.getPrice().getSells()) {
                if (ell.getId() == Item.getId()) {
                    prices = ell.getPrice();
                    break;
                }
            }
            System.out.println("The unit price of this item is: " + String.format("%.2f", prices));
        }


    }

    public boolean Storeretbool(int idofstore) throws IdOfStoreNotFound {
        int i = 0;
        boolean foundidofstore = false;
        while ((!(foundidofstore)) && (i < Stores.getStoress().size())) {
            if (idofstore == Stores.getStoress().get(i).getId())
                foundidofstore = true;
            else
                i++;
        }
        if (foundidofstore == false)
            throw new IdOfStoreNotFound();
        else
            foundidofstore = true;
        return foundidofstore;

    }

    public store Storeret(int idofstore) throws IdOfStoreNotFound {
        int i = 0;
        store Store = null;
        boolean foundidofstore = false;
        while ((!(foundidofstore)) && (i < Stores.getStoress().size())) {
            if (idofstore == Stores.getStoress().get(i).getId())
                foundidofstore = true;
            else
                i++;
        }
        if (foundidofstore == false)
            throw new IdOfStoreNotFound();
        else {
            Store = Stores.getStoress().get(i);
            return Store;
        }

    }

    public item searchaccordingtoid(int id) {
        item itemret = null;
        for (item itemid : Items.getItems()) {
            if (id == itemid.getId()) {
                itemret = itemid;
                break;
            }
        }
        return itemret;
    }

    public void idofitemfoundinstore(int idofstore, int idofitem) throws IdOfStoreNotFound, IdOfItemNotFound {
        boolean found = false;
        store st = Storeret(idofstore);
        for (sell sel : st.getPrice().getSells()) {
            if (sel.getId() == idofitem)
                found = true;
        }
        if (!(found))
            throw new IdOfItemNotFound();


    }

    public void legalcheckAddItemToStore(int idofstore, int idofitem) throws IdOfStoreNotFound, tryadditemthatsoldinstore {
        store st = Storeret(idofstore);
        for (sell it : st.getPrice().getSells()) {
            if (it.getId() == idofitem)
                throw new tryadditemthatsoldinstore();
        }
    }

    public boolean searchitem(int id) throws IdOfItemNotFound {
        int i = 0;
        boolean foundItem = false;
        while ((!(foundItem)) && i < Items.getItems().size()) {
            if (Items.getItems().get(i).getId() == id)
                foundItem = true;
            else
                i++;
        }
        if (foundItem == false)
            throw new IdOfItemNotFound();
        else
            return true;

    }

    public void addToListOrderItem(int idofstore, int id, double countItems) throws IdOfItemNotFound, IdOfStoreNotFound {
        int i = 0;
        store Storeorder = null;
        boolean fixidofstore = Storeretbool(idofstore);
        boolean foundStore = false;
        if (fixidofstore) {
            while ((!(foundStore)) && i < Stores.getStoress().size()) {
                if (idofstore == Stores.getStoress().get(i).getId())
                    foundStore = true;
                else
                    i++;
            }
            Storeorder = Stores.getStoress().get(i);
            int j = 0;
            int k = 0;
            double prices = 0;
            boolean foundidinliat = false;
            boolean foundidofitem = false;
            while ((!(foundidofitem)) && (j < Storeorder.getPrice().getSells().size())) {
                if (id == Storeorder.getPrice().getSells().get(j).getId()) {
                    foundidofitem = true;
                    prices = Storeorder.getPrice().getSells().get(j).getPrice();
                } else
                    j++;
            }
            if (foundidofitem == false)
                throw new IdOfItemNotFound();
            else {
                while ((!(foundidinliat)) && (k < itemtoorder.size())) {
                    if (id == itemtoorder.get(k).getId())
                        foundidinliat = true;
                    else
                        k++;


                }
                if (foundidinliat) {
                    itemtoorder.get(k).setCountItemToOrder(itemtoorder.get(k).getCountItemToOrder() + countItems);
                    itemtoorder.get(k).setSumPriceItem((itemtoorder.get(k).getCountItemToOrder()) * (itemtoorder.get(k).getCountItemToOrder()));
                    itemtoorder.get(k).setQuantityemaindDisc(itemtoorder.get(k).getCountItemToOrder());
                } else {
                    k = 0;
                    item itemret = searchaccordingtoid(id);
                    ArrayList<discount> discs = creatediscounts(idofstore, id);
                    itemToOrder itemorder = new itemToOrder(discs);
                    itemorder.setId(id);
                    itemorder.setNameItem(itemret.getName());
                    itemorder.setPurIt(itemret.getPurchasecategory());
                    itemorder.setPriceItem(prices);
                    itemorder.setCountItemToOrder(countItems);
                    itemorder.setSumPriceItem(prices * countItems);
                    itemorder.setQuantityemaindDisc(itemorder.getCountItemToOrder());
                    itemorder.setPricemadeDiscount(0);
                    itemtoorder.add(itemorder);


                }
            }
        } else
            throw new IdOfStoreNotFound();
    }

    public ArrayList<discount> creatediscounts(int idstore, int iditem) {
        ArrayList<discount> diss = new ArrayList<>();
        store s = null;
        for (store st : this.getStores().getStoress()) {
            if (st.getId() == idstore) {
                s = st;
                break;
            }
        }
        if (s.getDiscs() != null) {
            for (discount disc : s.getDiscs().getSdmDiscounts()) {
                if (disc.getBuy().getId() == iditem) {
                    diss.add(disc);
                }
            }
        }
        return diss;
    }

    public void initiallListItemToOrder() {
        itemtoorder = null;
        itemtoorder = new ArrayList<itemToOrder>(Items.getItems().size());
    }

    public void updateinsum() {
        for (itemToOrder itemsino : itemtoorder) {
            itemsino.printSumPrice();
        }

    }

    public void checkLOcationNotExceed(int X, int Y) throws LocationNotFixOfUser {
        if (((X < 1) || (X > 50)) || (Y < 1) || (Y > 50))
            throw new LocationNotFixOfUser();
    }

    public void checkLocationFix(int X, int Y) throws LocationNotFixOfUser {
        for (store st : Stores.getStoress()) {
            if ((X == st.getLocation().getX()) && (Y == st.getLocation().getY()))
                throw new LocationNotFixOfUser();
        }
    }

    public void updateOrder(LocalDate date, int X, int Y, int idOfStore, int countOrder) throws IdOfStoreNotFound, LocationNotFixOfUser {
        store Store = Storeret(idOfStore);
        if (((X < 1) || (X > 50)) || (Y < 1) || (Y > 50))
            throw new LocationNotFixOfUser();
        else {
            checkLocationFix(X, Y);
            location l = storelocation(idOfStore);
            Order ordrr = new Order(date, (Integer) Store.getDelivery(), X, Y, itemtoorder, l, countOrder);
            ordrr.setIdOfStore(idOfStore);
            ordrr.setNameStore(Store.getName());
            ordrr.ConclusionInOrder();
            Listorder.add(ordrr);
        }


    }

    public location storelocation(int id) {
        boolean foundStore = false;
        location l = null;
        int i = 0;
        while (((foundStore == false)) && i < this.Stores.getStoress().size()) {
            if (this.Stores.getStoress().get(i).getId() == id)
                foundStore = true;
            else
                i++;
        }
        if (foundStore)
            l = Stores.getStoress().get(i).getLocation();
        return l;
    }

    public String howToBuy(int idofitem) {
        String str = new String();
        for (item i : Items.getItems()) {
            if (i.getId() == idofitem) {
                str = i.getPurchasecategory();
                break;
            }
        }
        return str;
    }

    public void PrintOrders() {
        if (Listorder.size() == 0) {
            System.out.println("No Selected orders");
        } else {
            for (Order order : Listorder) {
                order.printIdOfOrder();
                order.printDate();
                order.printIdOfStoreandname();
                order.printCountkindOItemsAndCountSumItems();
                order.sumCostitems();
                order.printPriceSending();
                order.costOrder();

            }
        }
        if (ListDinamyOrder.size() == 0) {
            System.out.println("No Selected DinamyOrders");
        } else {
            for (orderDinamy order : ListDinamyOrder) {
                order.printCounterIdOrder();
                order.PrintDateOrder();
                order.printidOfStoresandNameStores();
                order.printCountItems();
                order.kindsitems();
                order.SumPriceItems();
                order.costSending();
                order.costsumorder();
            }

        }
    }

    public double maxprice() {
        double max = 0;
        for (store s : this.getStores().getStoress()) {
            double maxi = 0;
            for (sell sel : s.getPrice().getSells()) {
                if (sel.getPrice() >= maxi)
                    maxi = sel.getPrice();

            }
            if (maxi >= max)
                max = maxi;
        }
        return max;
    }

    public int idOfStoreItemMinimumPrice(int idofitem) {
        int temp = 0;
        double min = maxprice();
        double mini = maxprice();
        for (store s : this.getStores().getStoress()) {
            for (sell sel : s.getPrice().getSells()) {
                if (sel.getId() == idofitem) {
                    if (sel.getPrice() <= mini) {
                        mini = sel.getPrice();
                        temp = s.getId();
                    }
                }
            }
        }

        return temp;
    }

    public void AddListItemdinamyOrder(int idofitem, int idofstore, double countofitems) throws IdOfStoreNotFound, IdOfItemNotFound {

        boolean found = false;
        store s = Storeret(idofstore);
        item Item = searchaccordingtoid(idofitem);
        int k = 0;
        double prices = 0;
        for (sell sel : s.getPrice().getSells()) {
            if (sel.getId() == idofitem)
                prices = sel.getPrice();
        }

        while ((!found) && k < itemsdinamyorder.size()) {
            if (itemsdinamyorder.get(k).getId() == idofitem)
                found = true;
            else
                k++;
        }
        if (found) {
            itemsdinamyorder.get(k).setCountItemToOrder(itemsdinamyorder.get(k).getCountItemToOrder() + countofitems);
            itemsdinamyorder.get(k).setSumPriceItem((itemsdinamyorder.get(k).getCountItemToOrder()) * (itemsdinamyorder.get(k).getPriceItem()));
            itemsdinamyorder.get(k).setQuantityemaindDisc(itemsdinamyorder.get(k).getCountItemToOrder());

        } else {
            ArrayList<discount> disx = creatediscounts(idofstore, idofitem);
            itemToOrderDinamy itemdinamyorder = new itemToOrderDinamy(disx);
            itemdinamyorder.setId(idofitem);
            itemdinamyorder.setNameItem(Item.getName());
            itemdinamyorder.setPurIt(Item.getPurchasecategory());
            itemdinamyorder.setPriceItem(prices);
            itemdinamyorder.setCountItemToOrder(countofitems);
            itemdinamyorder.setIdOfStoreOfItem(idofstore);
            itemdinamyorder.setNameStoreOfItem(s.getName());
            itemdinamyorder.setPpk(s.getDelivery());
            itemdinamyorder.setSpace(s.getLocation());
            itemdinamyorder.setSumPriceItem(prices * countofitems);
            itemdinamyorder.setQuantityemaindDisc(itemdinamyorder.getCountItemToOrder());
            itemdinamyorder.setPricemadeDiscount(0);
            itemsdinamyorder.add(itemdinamyorder);

        }

    }

    public void UpdateDinamyOrfder(LocalDate date, int X, int Y, int countOrder) throws LocationNotFixOfUser {
        if (((X < 1) || (X > 50)) || (Y < 1) || (Y > 50))
            throw new LocationNotFixOfUser();
        else {
            checkLocationFix(X, Y);
            orderDinamy order = new orderDinamy(countOrder, date, X, Y, itemsdinamyorder);
            order.setCordinata_x(X);
            order.setCordinata_y(Y);
            order.setDate(date);
            order.setIdCountOrder(countOrder);
            order.conclusion();
            ListDinamyOrder.add(order);
        }
    }

    public void Additemtostore(int idofstre, int iditem, double Price) throws tryadditemthatsoldinstore, IdOfStoreNotFound, IdOfItemNotFound {
        int i = 0;
        boolean found = false;
        item it = searchaccordingtoid(iditem);
        store st = Storeret(idofstre);
        for (sell sel : st.getPrice().getSells()) {
            if (sel.getId() == iditem) {
                found = true;
                break;


            }
        }
        if (found)
            throw new tryadditemthatsoldinstore();
        else {
            sell s = new sell();
            s.setId(iditem);
            s.setPrice(Price);
            for (i = 0; i < this.getStores().getStoress().size(); i++) {
                if (this.getStores().getStoress().get(i).getId() == idofstre)
                    break;
            }
            this.getStores().getStoress().get(i).getPrice().getSells().add(s);


        }

    }

    public void RemoveItem(int idofstore, int idofitem) throws IdOfStoreNotFound, IdOfItemNotFound, impossiletoremoveitem {
        int k = 0;
        int l = 0;
        boolean found = false;
        int count = 0;
        store s = Storeret(idofstore);
        item it = searchaccordingtoid(idofitem);
        for (sell sel : s.getPrice().getSells()) {
            if (sel.getId() == idofitem) {
                found = true;
                break;
            }
        }
        if (!found)
            throw new IdOfItemNotFound();
        else {
            for (int i = 0; i < this.getStores().getStoress().size(); i++) {
                for (int j = 0; j < this.getStores().getStoress().get(i).getPrice().getSells().size(); j++) {
                    if (this.getStores().getStoress().get(i).getPrice().getSells().get(j).getId() == idofitem)
                        count++;
                }
            }
            if ((count == 1) || ((this.getStores().getStoress().size() == 1) && (this.getStores().getStoress().get(0).getId() == idofitem)))
                throw new impossiletoremoveitem();
            else {
                for (k = 0; k < this.getStores().getStoress().size(); k++) {
                    if (this.getStores().getStoress().get(k).getId() == idofstore)
                        break;
                }
                for (l = 0; l < s.getPrice().getSells().size(); l++) {
                    if (s.getPrice().getSells().get(l).getId() == idofitem)
                        break;
                    ;
                }
                this.getStores().getStoress().get(k).getPrice().getSells().remove(l);
                int indexfound = Discountthatfound(idofstore, idofitem);
                if (indexfound != -1)
                    this.getStores().getStoress().get(k).getDiscs().getSdmDiscounts().remove(indexfound);
            }
        }
    }

    public void updateprice(int idofstore, int idofitem, double Price) throws IdOfStoreNotFound, IdOfItemNotFound {
        int j = 0;
        int i = 0;
        boolean found = false;
        store st = Storeret(idofstore);
        item it = searchaccordingtoid(idofitem);
        for (j = 0; j < st.getPrice().getSells().size(); j++) {
            if (st.getPrice().getSells().get(j).getId() == idofitem) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IdOfItemNotFound();
        } else {
            for (i = 0; i < this.getStores().getStoress().size(); i++) {
                if (this.getStores().getStoress().get(i).getId() == idofstore)
                    break;
            }
            this.getStores().getStoress().get(i).getPrice().getSells().get(j).setPrice(Price);
        }

    }


    public void WriteDataToFile(Path FILE_NAME) throws IOException {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(String.valueOf(FILE_NAME)))) {
            out.writeObject(Listorder);
            out.writeObject(ListDinamyOrder);
            out.flush();
        }

    }

    public void ReadDataFromFile(Path FILE_NAME) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(String.valueOf(FILE_NAME)))) {
            Listorder = (ArrayList<Order>) in.readObject();
            ListDinamyOrder = (ArrayList<orderDinamy>) in.readObject();


        }
    }

    public ArrayList<itemInStore> createItemsInStore(int idofstore) {
        ArrayList<itemInStore> itemsinstores = new ArrayList<>();
        store s = null;
        sell se = null;
        for (int i = 0; i < this.getStores().getStoress().size(); i++) {
            if (idofstore == this.getStores().getStoress().get(i).getId()) {
                s = this.getStores().getStoress().get(i);
                break;
            }


        }
        for (int i = 0; i < s.getPrice().getSells().size(); i++) {
            int id = s.getPrice().getSells().get(i).getId();
            double price = s.getPrice().getSells().get(i).getPrice();
            String name = "";
            String howbuyitem = "";
            for (int k = 0; k < this.getItems().getItems().size(); k++) {
                if (this.getItems().getItems().get(k).getId() == id) {
                    name = this.getItems().getItems().get(k).getName();
                    howbuyitem = this.getItems().getItems().get(k).Purchasecategory;
                    break;
                }
            }
            double solditems = countItemsSoldInStore(idofstore, id);
            itemInStore iteminstore = new itemInStore(id, name, howbuyitem, price, solditems);
            itemsinstores.add(iteminstore);


        }
        return itemsinstores;


    }

    public double countItemsSoldInStore(int idofstore, int idofitems) {
        double count = 0;
        for (Order order : Listorder) {
            if (order.getIdOfStore() == idofstore) {
                for (itemToOrder itemorder : order.getItemtoorder()) {
                    if (idofitems == itemorder.getId()) {
                        count = count + itemorder.getCountItemToOrder();
                        break;
                    }
                }

            }
        }
        for (orderDinamy order : ListDinamyOrder) {
            for (itemToOrderDinamy itemdinamy : order.getItemsdinamy()) {
                if (itemdinamy.getIdOfStoreOfItem() == idofstore) {
                    if (itemdinamy.getId() == idofitems) {
                        count = count + itemdinamy.getCountItemToOrder();
                        break;
                    }
                }
            }
        }
        return count;
    }

    public ArrayList<String> createDiscountsInStore(int id) {
        ArrayList<String> discounts = new ArrayList<>();
        int i;
        int j;
        for (i = 0; i < this.getStores().getStoress().size(); i++) {
            if (this.getStores().getStoress().get(i).getId() == id)
                break;
        }
        if (this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts() != null) {
            for (discount disc : this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts()) {
                String name = disc.getName();
                int iditem = disc.getBuy().getId();
                double quantity = disc.getBuy().getQuantity();
                for (j = 0; j < this.getItems().getItems().size(); j++) {
                    if (iditem == this.getItems().getItems().get(j).id)
                        break;

                }
                String idofitem = String.format("%d", iditem);
                String nameitem = this.getItems().getItems().get(j).name;
                String quantityItem = String.format("%.2f", quantity);
                String operatordisc = disc.getGetoffer().getOperator();
                String Discor = name + "," + idofitem + "," + nameitem + "," + quantityItem + "," + operatordisc;
                discounts.add(Discor);


            }
        }
        return discounts;
    }

    public ArrayList<String> createListOfOffers(String name) {
        ArrayList<String> offersString = new ArrayList<>();
        int i = 0;
        boolean found = false;
        while (!found && i < this.getStores().getStoress().size()) {
            for (discount disc : this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts()) {
                if (disc.getName().equals(name)) {
                    for (offer off : disc.getGetoffer().getSdmoffer()) {
                        String str = "The id of offer is: " + (String.format("%d", off.getId())) + "," + "The quantity of offer is: " + (String.format("%.2f", off.getQuantity())) + "," + "The price unit of offer is: " + (String.format("%.2f", off.getPriceone()));
                        offersString.add(str);
                    }
                    found = true;
                    break;
                }
            }
            if (!found)
                i++;

        }
        return offersString;

    }

    public int Discountthatfound(int idofstore, int idofitem) {
        int indexfound = -1;
        int i = 0;
        int j = 0;
        int k = 0;
        for (i = 0; i < this.getStores().getStoress().size(); i++) {
            if (this.getStores().getStoress().get(i).getId() == idofstore)
                break;
        }
        for (j = 0; j < this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().size(); j++) {
            if (this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getBuy().getId() == idofitem) {
                indexfound = j;
                break;
            } else {
                for (k = 0; k < this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getGetoffer().getSdmoffer().size(); k++) {
                    if (this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getGetoffer().getSdmoffer().get(k).getId() == idofitem) {
                        indexfound = -1;
                        break;
                    }
                }
            }
        }
        return indexfound;
    }

    public ArrayList<String> createItems(int idofStore) {
        int i = 0;
        int j = 0;
        ArrayList<String> itemmim = new ArrayList<>();
        for (i = 0; i < this.getStores().getStoress().size(); i++) {
            if (this.getStores().getStoress().get(i).getId() == idofStore) {
                break;
            }

        }
        for (sell sel : this.getStores().getStoress().get(i).getPrice().getSells()) {
            for (j = 0; j < this.getItems().getItems().size(); j++) {
                if (sel.getId() == this.getItems().getItems().get(j).getId())
                    break;
            }
            String str = sel.getId() + "," + this.getItems().getItems().get(j).getName();
            itemmim.add(str);

        }
        return itemmim;
    }

    public ArrayList<Double> buildDataStore(int idofstore, int idCustomer) {
        ArrayList<Double> data = new ArrayList<>();
        store star = null;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idofstore) {
                star = s;
                break;
            }

        }
        data.add((double) star.getDelivery());
        data.add((double) star.getLocation().getX());
        data.add((double) star.getLocation().getY());
        customer cust = null;
        for (customer c : this.getIcostomers().getSdmcustomers()) {
            if (c.getId() == idCustomer) {
                cust = c;
                break;
            }
        }
        double priceSendX = star.getLocation().x - cust.getLocation().getX();
        double priceSendY = star.getLocation().y - cust.getLocation().getY();
        double PriceSendRibui = Math.pow(priceSendX, 2) + Math.pow(priceSendY, 2);
        double priceSending = (double) (Math.sqrt(PriceSendRibui));
        data.add(priceSending);
        return data;

    }

    public ArrayList<String> createItemNotFoundInStore(int idstore) {
        ArrayList<String> itemnotinstore = new ArrayList<>();
        item it = null;
        store s = null;
        for (store st : this.getStores().getStoress()) {
            if (st.getId() == idstore) {
                s = st;
                break;
            }
        }
        for (item ite : this.getItems().getItems()) {
            boolean found = false;
            int i = 0;
            while (!found && i < s.getPrice().getSells().size()) {
                if (s.getPrice().getSells().get(i).getId() == ite.getId())
                    found = true;
                else
                    i++;
            }
            if (!found) {
                itemnotinstore.add(ite.getId() + "," + ite.getName());
            }
        }
        return itemnotinstore;
    }

    public ArrayList<showItemsToOrder> builditemsContinueOrder(int idOfStore) {
        ArrayList<showItemsToOrder> ItemSowOrder = new ArrayList<>();
        sell t = null;
        store s = null;
        for (store st : this.getStores().getStoress()) {
            if (st.getId() == idOfStore) {
                s = st;
                break;
            }
        }
        for (item iten : this.getItems().getItems()) {
            int i = 0;
            boolean found = false;
            while (!found && i < s.getPrice().getSells().size()) {
                if (iten.getId() == s.getPrice().getSells().get(i).getId()) {
                    t = s.getPrice().getSells().get(i);
                    found = true;
                } else
                    i++;
            }
            if (found) {
                showItemsToOrder iter = new showItemsToOrder();
                iter.setIdofItem(iten.getId());
                iter.setIdofstoreofitem(String.format("%d", idOfStore));
                iter.setNameStoreOfItem(s.getName());
                iter.setNameitem(iten.getName());
                iter.setHowtobuy(iten.getPurchasecategory());
                iter.setPriceUnitItem(String.format("%.2f", t.getPrice()));
                ItemSowOrder.add(iter);
            } else {
                showItemsToOrder iter = new showItemsToOrder();
                iter.setIdofItem(iten.getId());
                iter.setIdofstoreofitem("The item not found in store");
                iter.setNameStoreOfItem("The item not found in store");
                iter.setNameitem(iten.getName());
                iter.setHowtobuy(iten.getPurchasecategory());
                iter.setPriceUnitItem("not sold in store");
                ItemSowOrder.add(iter);
            }
        }
        return ItemSowOrder;
    }

    public ArrayList<showItemsToOrder> buildItemsDinamy() {

        ArrayList<showItemsToOrder> itemsData = new ArrayList<>();
        double price = 0;
        item it = null;
        store s = null;
        for (item iten : this.getItems().getItems()) {
            int idstore = idOfStoreItemMinimumPrice(iten.getId());
            for (store st : this.getStores().getStoress()) {
                if (st.getId() == idstore) {
                    s = st;
                    break;
                }
            }
            showItemsToOrder iter = new showItemsToOrder();
            iter.setIdofItem(iten.getId());
            iter.setNameitem(iten.getName());
            iter.setIdofstoreofitem(String.format("%d", s.getId()));
            iter.setNameStoreOfItem(s.getName());
            iter.setHowtobuy(iten.getPurchasecategory());
            for (sell sel : s.getPrice().getSells()) {
                if (sel.getId() == iten.getId()) {
                    price = sel.getPrice();
                    break;
                }
            }
            iter.setPriceUnitItem(String.format("%.2f", price));
            itemsData.add(iter);

        }
        return itemsData;
    }

    public ArrayList<ShowStoreToOrder> buildListStoresInOrderDinamy(int idCustomer) {
        double price = 0;
        ArrayList<ShowStoreToOrder> CreateShowsOrder = new ArrayList<>();
        item iten = null;
        store st = null;
        boolean found = false;
        int i = 0;
        int x = 0;
        int y = 0;
        for (item it : this.getItems().getItems()) {
            i = 0;
            int idStore = idOfStoreItemMinimumPrice(it.getId());
            while (!found && i < CreateShowsOrder.size()) {
                if (CreateShowsOrder.get(i).getIdOfStore() == idStore)
                    found = true;
                else
                    i++;
            }
            if (!found) {
                price = 0;
                for (store s : this.getStores().getStoress()) {
                    if (s.getId() == idStore) {
                        st = s;
                        break;
                    }
                }
                ShowStoreToOrder Stro = new ShowStoreToOrder();
                Stro.setIdOfStore(st.getId());
                Stro.setNameStore(st.getName());
                Stro.setCordinatax(st.getLocation().x);
                Stro.setCordinatay(st.getLocation().y);
                Stro.setPpk(st.getDelivery());
                for (customer cust : this.getIcostomers().getSdmcustomers()) {
                    if (cust.getId() == idCustomer) {
                        x = cust.getLocation().getX();
                        y = cust.getLocation().getY();
                        break;
                    }
                }
                double HefreshRbuyiX = Math.pow((double) (st.getLocation().x - x), 2);
                double hefreshRibuyiY = Math.pow((double) (st.getLocation().getY() - y), 2);
                Stro.setDitance(Math.sqrt(HefreshRbuyiX + hefreshRibuyiY));
                Stro.setPriceSend((double) (st.getDelivery() * (Math.sqrt(HefreshRbuyiX + hefreshRibuyiY))));
                for (sell sel : st.getPrice().getSells()) {
                    price = price + sel.getPrice();
                }
                Stro.setAmountKindsItems(st.getPrice().getSells().size());
                Stro.setSumPrices(price);
                CreateShowsOrder.add(Stro);
            }

        }
        return CreateShowsOrder;
    }

    public ArrayList<ArrayList<String>> buildindicatediscount(itemToOrder itemorder) {
        ArrayList<ArrayList<String>> discs = new ArrayList<>();
        for (discount diss : itemorder.getDiscs()) {
            ArrayList<String> disc = new ArrayList<>();
            String name = diss.getName();
            String id = String.format("%d", diss.getBuy().getId());
            String Quantity = String.format("%.2f", diss.getBuy().getQuantity());
            String op = diss.getGetoffer().getOperator();
            disc.add(name + ',' + id + ',' + Quantity + ',' + op);
            for (offer off : diss.getGetoffer().getSdmoffer()) {
                String iditem = String.format("%d", off.getId());
                String nameitem = "";
                for (item it : this.getItems().getItems()) {
                    if (off.getId() == it.getId()) {
                        nameitem = it.getName();
                        break;

                    }
                }
                disc.add(iditem + ',' + nameitem);

            }
            discs.add(disc);
        }
        return discs;
    }

    public ArrayList<ArrayList<ArrayList<String>>> CreateDiscountAndOffers(int selected) {
        ArrayList<ArrayList<ArrayList<String>>> Disccs = new ArrayList<>();
        if (selected == 1) {
            for (itemToOrder itemord : itemtoorder) {
                ArrayList<ArrayList<String>> dissc = buildindicatediscount(itemord);
                Disccs.add(dissc);
            }

        } else {
            for (itemToOrderDinamy itemdin : itemsdinamyorder) {
                ArrayList<ArrayList<String>> discsc = buildindicatediscount(itemdin);
                Disccs.add(discsc);
            }
        }
        return Disccs;
    }

    public ArrayList<ShowOffer> createOffers(int idstore, String name) {
        ArrayList<ShowOffer> offs = new ArrayList<>();
        store st = null;
        discount disc = null;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        for (discount d : st.getDiscs().getSdmDiscounts()) {
            if (d.getName().equals(name)) {
                disc = d;
                break;
            }
        }
        for (offer off : disc.getGetoffer().getSdmoffer()) {
            ShowOffer of = new ShowOffer();
            of.setId(off.getId());
            of.setAmount(off.getQuantity());
            of.setPrice(off.getPriceone());
            String nameitem = "";
            for (item it : this.getItems().getItems()) {
                if (it.getId() == off.getId()) {
                    nameitem = it.getName();
                    break;
                }
            }
            of.setName(nameitem);
            offs.add(of);
        }
        return offs;
    }

    public String createopp(String name, int idstore) {
        store st = null;
        discount disc = null;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        for (discount d : st.getDiscs().getSdmDiscounts()) {
            if (d.getName().equals(name)) {
                disc = d;
                break;
            }
        }
        String opp = disc.getGetoffer().getOperator();
        return opp;
    }

    public ArrayList<String> createoffs(String name, int idstore, int selected) {
        ArrayList<String> offs = new ArrayList<>();
        store st = null;
        discount disc = null;
        int i = 0;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        for (discount d : st.getDiscs().getSdmDiscounts()) {
            if (d.getName().equals(name)) {
                disc = d;
                break;
            }
        }
        if (selected == 1) {
            for (i = 0; i < itemtoorder.size(); i++) {
                if (disc.getBuy().getId() == itemtoorder.get(i).getId())
                    break;
            }
        } else {
            for (i = 0; i < itemsdinamyorder.size(); i++) {
                if (disc.getBuy().getId() == itemsdinamyorder.get(i).getId())
                    break;
            }
        }
        if (selected == 1) {
            if (itemtoorder.get(i).getQuantityemaindDisc() >= disc.getBuy().getQuantity()) {
                for (offer off : disc.getGetoffer().getSdmoffer()) {
                    String id = String.format("%d", off.getId());
                    String nameitem = "";
                    for (item it : this.getItems().getItems()) {
                        if (it.getId() == off.getId()) {
                            nameitem = it.getName();
                            break;
                        }
                    }
                    offs.add(id + ',' + nameitem);
                }
            }
        } else {
            if (itemsdinamyorder.get(i).getQuantityemaindDisc() >= disc.getBuy().getQuantity()) {
                for (offer off : disc.getGetoffer().getSdmoffer()) {
                    String id = String.format("%d", off.getId());
                    String nameitem = "";
                    for (item it : this.getItems().getItems()) {
                        if (it.getId() == off.getId()) {
                            nameitem = it.getName();
                            break;
                        }
                    }
                    offs.add(id + ',' + nameitem);
                }
            }
        }
        return offs;


    }

    public void updateDiscount(String name, int idstore, int selected) throws tryAccheiveDiscountThatNoEnough {
        boolean found = false;
        int i = 0;
        store st = null;
        discount disc = null;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        for (discount d : st.getDiscs().getSdmDiscounts()) {
            if (d.getName().equals(name)) {
                disc = d;
                break;
            }
        }
        if (selected == 1) {
            for (i = 0; i < itemtoorder.size(); i++) {
                if (itemtoorder.get(i).getId() == disc.getBuy().getId())
                    break;
            }
            if (itemtoorder.get(i).getQuantityemaindDisc() >= disc.getBuy().getQuantity()) {
                itemtoorder.get(i).setQuantityemaindDisc(itemtoorder.get(i).getQuantityemaindDisc() - disc.getBuy().getQuantity());
                double price = 0;
                for (offer off : disc.getGetoffer().getSdmoffer()) {
                    int j = 0;
                    price = price + off.getQuantity() * off.getPriceone();

                    found = false;
                    while (!found && j < itemtoorder.size()) {
                        if (itemtoorder.get(j).getId() == off.getId())
                            found = true;
                        else
                            j++;
                    }
                    if (found)
                        itemtoorder.get(j).setDogitten(true);
                }

                itemtoorder.get(i).setPricemadeDiscount(itemtoorder.get(i).getPricemadeDiscount() + price);
            } else {
                throw new tryAccheiveDiscountThatNoEnough();
            }
        } else {
            for (i = 0; i < itemsdinamyorder.size(); i++) {
                if (itemsdinamyorder.get(i).getId() == disc.getBuy().getId())
                    break;
            }
            if (itemsdinamyorder.get(i).getQuantityemaindDisc() >= disc.getBuy().getQuantity()) {
                itemsdinamyorder.get(i).setQuantityemaindDisc(itemsdinamyorder.get(i).getQuantityemaindDisc() - disc.getBuy().getQuantity());
                double price = 0;
                for (offer off : disc.getGetoffer().getSdmoffer()) {
                    int j = 0;
                    found = false;
                    price = price + off.getPriceone() * off.getQuantity();
                    while (!found && j < itemsdinamyorder.size()) {
                        if (off.getId() == itemsdinamyorder.get(j).getId())
                            found = true;
                        else
                            j++;
                    }
                    if (found)
                        itemsdinamyorder.get(j).setDogitten(true);
                }
                itemsdinamyorder.get(i).setPricemadeDiscount(itemsdinamyorder.get(i).getPricemadeDiscount() + price);
            } else {
                throw new tryAccheiveDiscountThatNoEnough();
            }
        }

    }

    public void updateAccordingitem(String name, int idstore, int iditem, int selected) throws tryAccheiveDiscountThatNoEnough {
        store st = null;
        discount disc = null;
        boolean found = false;
        int i = 0;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        for (discount d : st.getDiscs().getSdmDiscounts()) {
            if (d.getName().equals(name)) {
                disc = d;
                break;
            }
        }
        if (selected == 1) {
            for (i = 0; i < itemtoorder.size(); i++) {
                if (itemtoorder.get(i).getId() == disc.getBuy().getId())
                    break;
            }
            if (itemtoorder.get(i).getQuantityemaindDisc() >= disc.getBuy().getQuantity()) {
                itemtoorder.get(i).setQuantityemaindDisc(itemtoorder.get(i).getQuantityemaindDisc() - disc.getBuy().getQuantity());
                double price = 0;
                for (offer off : disc.getGetoffer().getSdmoffer()) {
                    if (off.getId() == iditem) {
                        price = off.getPriceone() * off.getQuantity();
                        found = false;
                        int j = 0;
                        while (!found && j < itemtoorder.size()) {
                            if (itemtoorder.get(j).getId() == off.getId())
                                found = true;
                            else
                                j++;
                        }
                        if (found) {
                            itemtoorder.get(j).setDogitten(true);
                        }
                        break;
                    }
                }
                itemtoorder.get(i).setPricemadeDiscount(itemtoorder.get(i).getPricemadeDiscount() + price);
            } else {
                throw new tryAccheiveDiscountThatNoEnough();
            }


        } else {
            for (i = 0; i < itemsdinamyorder.size(); i++) {
                if (itemsdinamyorder.get(i).getId() == disc.getBuy().getId())
                    break;
            }
            if (itemsdinamyorder.get(i).getQuantityemaindDisc() >= disc.getBuy().getQuantity()) {
                itemsdinamyorder.get(i).setQuantityemaindDisc(itemsdinamyorder.get(i).getQuantityemaindDisc() - disc.getBuy().getQuantity());
                double price = 0;
                for (offer off : disc.getGetoffer().getSdmoffer()) {
                    if (off.getId() == iditem) {
                        price = off.getPriceone() * off.getQuantity();
                        found = false;
                        int j = 0;
                        while (!found && j < itemsdinamyorder.size()) {
                            if (itemsdinamyorder.get(j).getId() == iditem)
                                found = true;
                            else
                                j++;
                        }
                        if (found) {
                            itemsdinamyorder.get(j).setDogitten(true);
                            itemsdinamyorder.get(j).setCountItemToOrder(itemsdinamyorder.get(j).getCountItemToOrder() + off.getQuantity());
                        }
                        break;
                    }
                }
                itemsdinamyorder.get(i).setPricemadeDiscount(itemsdinamyorder.get(i).getPricemadeDiscount() + price);
            } else {
                throw new tryAccheiveDiscountThatNoEnough();
            }
        }

    }

    public ArrayList<String> createdataStore(int idstore, int idcustomer) {
        ArrayList<String> dataStore = new ArrayList<>();
        int x = 0;
        int y = 0;
        store st = null;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        dataStore.add("The Id Of Store is: " + String.format("%d", st.getId()));
        dataStore.add("The name of Store is: " + st.getName());
        dataStore.add("The PPK Of Store is: " + String.format("%d", st.getDelivery()));
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getId() == idcustomer) {
                x = cust.getLocation().getX();
                y = cust.getLocation().getY();
                break;
            }
        }
        double hefreshxribui = Math.pow((st.getLocation().getX() - x), 2);
        double hefreshyribui = Math.pow((st.getLocation().getY() - y), 2);
        double distance = (double) Math.sqrt((double) (hefreshxribui + hefreshyribui));
        dataStore.add("The distance From Store to customer is: " + String.format("%.2f", distance));
        dataStore.add("The Cost PriceSending is: " + String.format("%.2f", distance * (double) (st.getDelivery())));
        return dataStore;
    }

    public ArrayList<ShowStorsDinamyOrder> createStoresDinamy(int idcustomer) {
        int x = 0;
        int y = 0;
        ArrayList<ShowStorsDinamyOrder> data = new ArrayList<>();
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getId() == idcustomer) {
                x = cust.getLocation().getX();
                y = cust.getLocation().getY();
                break;
            }
        }
        for (itemToOrderDinamy itemd : itemsdinamyorder) {
            ShowStorsDinamyOrder s = new ShowStorsDinamyOrder();
            s.setId(itemd.getIdOfStoreOfItem());
            s.setNamr(itemd.getNameStoreOfItem());
            s.setPpk(itemd.getPpk());
            double hefreshXribuiyi = (double) Math.pow(itemd.getSpace().getX() - x, 2);
            double hefreshYribuyi = (double) Math.pow(itemd.getSpace().getY() - y, 2);
            double Distance = Math.sqrt(hefreshXribuiyi + hefreshXribuiyi);
            s.setDistance(Distance);
            s.setCostSending((double) (itemd.getPpk()) * Distance);
            data.add(s);
        }
        ArrayList<ShowStorsDinamyOrder> data1 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i).getId() == data.get(j).getId())
                    count++;
            }
            if (count == 0)
                data1.add(data.get(i));
            count = 0;
        }
        data1.add(data.get(data.size() - 1));
        return data1;
    }

    public showItemsConclusionOrder createNode(itemToOrder itemy) {
        showItemsConclusionOrder show = new showItemsConclusionOrder();
        show.setId(itemy.getId());
        show.setName(itemy.getNameItem());
        show.setHowToBuy(itemy.getPurItem());
        show.setStoreThatSold((String.format("%d",itemy.getIdStore()))+","+itemy.getNameStore());
        show.setOount(itemy.getCountItemToOrder());
        show.setPriceunit(itemy.getPriceItem());
        show.setSumPrice(itemy.getPriceItem() * itemy.getCountItemToOrder());
        if (itemy.isDogitten())
            show.setDoItemSoldDiscount("true");
        else
            show.setDoItemSoldDiscount("false");
        return show;
    }

    public ArrayList<showItemsConclusionOrder> creatListNode(int selected) {
        ArrayList<showItemsConclusionOrder> data = new ArrayList<>();
        if (selected == 1) {
            for (itemToOrder it : itemtoorder) {
                showItemsConclusionOrder show = createNode(it);
                data.add(show);
            }
        } else {
            for (itemToOrderDinamy it : itemsdinamyorder) {
                showItemsConclusionOrder show = createNode(it);
                data.add(show);
            }
        }
        return data;
    }

    public double sumCostOrder(int selected) {
        double price = 0;
        if (selected == 1) {
            for (itemToOrder it : itemtoorder) {
                price = price + it.getSumPriceItem();
            }
            for (itemToOrder it : itemtoorder) {
                price = price + it.getPricemadeDiscount();
            }
        } else {
            for (itemToOrderDinamy it : itemsdinamyorder) {
                price = price + it.getSumPriceItem();
            }
            for (itemToOrderDinamy it : itemsdinamyorder) {
                price = price + it.getPricemadeDiscount();
            }
        }
        return price;

    }

    public double SumSending(int idcustomer, int idstore) {
        double send = 0;
        int x = 0;
        int y = 0;
        store s = null;
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getId() == idcustomer) {
                x = cust.getLocation().getX();
                y = cust.getLocation().getY();
                break;
            }
        }
        for (store st : this.getStores().getStoress()) {
            if (st.getId() == idstore) {
                s = st;
                break;
            }
        }
        double hefreshXribuyi = Math.pow((double) (s.getLocation().getX() - x), 2);
        double hefreshYribuyi = Math.pow((double) (s.getLocation().getY() - y), 2);
        double sending = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
        send = sending * (double) (s.getDelivery());
        return send;


    }

    public double SumSendingDinamy(int idcustomer) {
        double send = 0;
        int x = 0;
        int y = 0;
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getId() == idcustomer) {
                x = cust.getLocation().getX();
                y = cust.getLocation().getY();
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < itemsdinamyorder.size() - 1; i++) {
            for (int j = i + 1; j < itemsdinamyorder.size() - 1; j++) {
                if (itemsdinamyorder.get(i).getIdOfStoreOfItem() == itemsdinamyorder.get(j).getIdOfStoreOfItem())
                    count++;
            }
            if (count == 0) {
                double hefreshXribuyi = Math.pow((double) (itemsdinamyorder.get(i).getSpace().getX() - x), 2);
                double hefreshYribuyi = Math.pow((double) (itemsdinamyorder.get(i).getSpace().getY() - y), 2);
                double sending = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
                send = send + (sending) * ((double) (itemsdinamyorder.get(i).getPpk()));
            }
            count = 0;
        }
        double hefreshXribuyi = Math.pow((double) (itemsdinamyorder.get(itemsdinamyorder.size() - 1).getSpace().getY() - x), 2);
        double hefreshYribuyi = Math.pow((double) (itemsdinamyorder.get(itemsdinamyorder.size() - 1).getSpace().getY() - y), 2);
        double sending = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
        send = send + (sending) * ((double) (itemsdinamyorder.get(itemsdinamyorder.size() - 1).getPpk()));
        return send;
    }

    public void updatetoOrder(int idCustomer, int idStore, LocalDate date, int idorder) {
        Order ord = new Order();
        for (itemToOrder it : itemtoorder)
            ord.Add(it);
        ord.setIdcust(idCustomer);
        ord.setIdCountOrder(idorder);
        ord.setDate(date);
        ord.setIdOfStore(idStore);
        Listorder.add(ord);
    }

    public void updateDinamyToOrder(int idcustomer, LocalDate date, int idorder) {
        orderDinamy ord = new orderDinamy();
        for (itemToOrderDinamy it : itemsdinamyorder)
            ord.Add(it);
        ord.setIdCountOrder(idorder);
        ord.setIdCustomer(idcustomer);
        ord.setDate(date);
        ListDinamyOrder.add(ord);
    }

    public ArrayList<orderinStore> Staticcreateordersstore(int idstore) {
        String name_customer="";
        int x = 0;
        int y = 0;
        double countItems = 0;
        double sumPriceItems = 0;
        double sumPriceOffers = 0;
        String date;
        store st = null;
        ArrayList<orderinStore> orders = new ArrayList<>();
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        for (Order ord : Listorder) {
            countItems = 0;
            sumPriceItems = 0;
            if (ord.getIdOfStore() == idstore) {
                date = ord.getDate().toString();
                orderinStore orderS = new orderinStore();
                for (itemToOrder it : ord.getItemtoorder()) {
                    countItems = countItems + it.getCountItemToOrder();
                    sumPriceItems = sumPriceItems + it.getSumPriceItem();
                    sumPriceOffers = sumPriceOffers + it.getPricemadeDiscount();
                }
                orderS.setId(ord.getIdCountOrder());
                orderS.setDate(date);
                orderS.setCountItems(countItems);
                orderS.setSumPriceItems(sumPriceItems + sumPriceOffers);
                for (customer cust : this.getIcostomers().getSdmcustomers()) {
                    if (cust.getId() == ord.getIdcust()) {
                        x = cust.getLocation().getX();
                        y = cust.getLocation().getY();
                        name_customer=cust.getName();
                        break;
                    }
                }
                orderS.setNameCust(name_customer);
                orderS.setCordinataX(x);
                orderS.setCordinataY(y);
                double hefrshXribuyi = Math.pow((double) (st.getLocation().getX() - x), 2);
                double hefreshYribuyi = Math.pow((double) (st.getLocation().getY() - y), 2);
                double send = (double) (Math.sqrt(hefrshXribuyi + hefreshYribuyi)) * (double) st.getDelivery();
                orderS.setPriceSending(send);
                orderS.setCostOrder(sumPriceItems + sumPriceOffers + send);
                orders.add(orderS);

            }
        }
        return orders;


    }

    public ArrayList<orderinStore> createDinamyOrdersStore(int idofstore) {
        String name_cust="";
        int x = 0;
        int y = 0;
        ArrayList<orderinStore> orders = new ArrayList<>();
        boolean found = false;
        orderDinamy order = null;
        store st = null;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idofstore) {
                st = s;
                break;
            }
        }
        for (orderDinamy ord : ListDinamyOrder) {
            found = false;
            int i = 0;
            while (!found && i < ord.getItemsdinamy().size()) {
                if (ord.getItemsdinamy().get(i).getIdOfStoreOfItem() == idofstore) {
                    order = ord;
                    found = true;
                } else
                    i++;
            }
            if (found) {
                orderinStore orderS = new orderinStore();
                orderS.setId(order.getIdCountOrder());
                orderS.setDate(order.getDate().toString());
                double countItems = 0;
                double SumpriceItems = 0;
                double sumPriceOffers = 0;
                for (customer c : this.getIcostomers().getSdmcustomers()) {
                    if (order.getIdCustomer() == c.getId()) {
                        x = c.getLocation().getX();
                        y = c.getLocation().getY();
                        name_cust=c.getName();
                        break;
                    }
                }
                for (itemToOrderDinamy it : order.getItemsdinamy()) {
                    if (it.getIdOfStoreOfItem() == idofstore) {
                        countItems = countItems + it.getCountItemToOrder();
                        SumpriceItems = SumpriceItems + it.getSumPriceItem();
                        sumPriceOffers = sumPriceOffers + it.getPricemadeDiscount();
                    }
                }
                orderS.setNameCust(name_cust);
                orderS.setCordinataX(x);
                orderS.setCordinataY(y);
                double hefreshXribuyi = Math.pow((double) (st.getLocation().getX() - x), 2);
                double hefreshYrinuyi = Math.pow((double) (st.getLocation().getY() - y), 2);
                double send = (double) (Math.sqrt(hefreshXribuyi + hefreshYrinuyi)) * ((double) st.getDelivery());
                orderS.setCountItems(countItems);
                orderS.setSumPriceItems(SumpriceItems + sumPriceOffers);
                orderS.setPriceSending(send);
                orderS.setCostOrder(SumpriceItems + sumPriceOffers + send);
                orders.add(orderS);

            }


        }
        return orders;
    }

    public int maxheightofmap() {
        int max = 0;
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getLocation().getY() >= max)
                max = cust.getLocation().getY();
        }
        for (store st : this.getStores().getStoress()) {
            if (st.getLocation().getY() >= max)
                max = st.getLocation().getY();
        }
        return max;
    }

    public int maxwitdh() {
        int max = 0;
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getLocation().getX() >= max)
                max = cust.getLocation().getX();
        }
        for (store st : this.getStores().getStoress()) {
            if (st.getLocation().getX() >= max)
                max = st.getLocation().getX();
        }
        return max;
    }

    public ArrayList<String> createStringItems() {
        ArrayList<String> ListItems = new ArrayList<>();
        for (item it : this.getItems().getItems()) {
            String iter = String.format("%d", it.getId()) + ',' + it.getName();
            ListItems.add(iter);
        }
        return ListItems;
    }

    public ArrayList<String> createStringStores() {
        ArrayList<String> ListStores = new ArrayList<>();
        for (store s : this.getStores().getStoress()) {
            String str = String.format("%d", s.getId()) + "," + s.getName();
            ListStores.add(str);
        }
        return ListStores;
    }

    public ArrayList<String> CreateItemsSystem() {
        ArrayList<String> ListItems = new ArrayList<>();
        for (item it : this.getItems().getItems()) {
            String itr = it.getId() + "," + it.getName();
            ListItems.add(itr);
        }
        return ListItems;
    }

    public void checkidOfStoreAddFix(int idstore, int X, int Y) throws idsameitemsorstoresexceptions, trytoaddLocationInStorethatfound {
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore)
                throw new idsameitemsorstoresexceptions();
        }
        for (store s : this.getStores().getStoress()) {
            if (s.getLocation().getX() == X && s.getLocation().getY() == Y)
                throw new trytoaddLocationInStorethatfound();
        }
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getLocation().getX() == X && cust.getLocation().getY() == Y)
                throw new trytoaddLocationInStorethatfound();
        }
        if ((X < 1) || (Y > 50))
            throw new trytoaddLocationInStorethatfound();

    }

    public void AddItemsToNewStore(String nameManege,storeToSystem st, int iditrem, double pricer, int count) throws tryadditemthatsoldinstore {
        if (count == 0) {
            store s = new store();
            s.SetId(st.getIdofStore());
            s.SetName(st.getNameOfStore());
            s.Setdeliver(st.getPpkOfStore());
            location l = new location();
            l.setX(st.getCordinataXofStore());
            l.setY(st.getCordinataYofStore());
            s.setLocation(l);
            s.setNameStoreManege(nameManege);
            sell se = new sell();
            se.setId(iditrem);
            se.setPrice(pricer);
            prices pcs = new prices();
            pcs.Addsell(se);
            s.setPrice(pcs);
            this.getStores().getStoress().add(s);
        } else {
            int i = 0;
            int j = 0;
            boolean found = false;
            while (i < this.getStores().getStoress().size()) {
                if (this.getStores().getStoress().get(i).getId() == st.getIdofStore())
                    break;
                else
                    i++;
            }
            while (!found && j < this.getStores().getStoress().get(i).getPrice().getSells().size()) {
                if (this.getStores().getStoress().get(i).getPrice().getSells().get(j).getId() == iditrem)
                    found = true;
                else
                    j++;
            }
            if (found)
                throw new tryadditemthatsoldinstore();
            else {
                sell ser = new sell();
                ser.setId(iditrem);
                ser.setPrice(pricer);
                this.getStores().getStoress().get(i).getPrice().getSells().add(ser);
            }

        }


    }

    public void checkiditemFoundInSystem(int idItem) throws tryAddItemToSysThatFound {
        for (item it : this.getItems().getItems()) {
            if (it.getId() == idItem)
                throw new tryAddItemToSysThatFound();

        }
    }

    public void AddItemToSys(itemToSystem it, int idstore, double amount, int count) throws tryadditemthatsoldinstore {
        boolean found = false;
        int i = 0;
        if (count == 0) {
            while (i < this.getStores().getStoress().size()) {
                if (this.getStores().getStoress().get(i).getId() == idstore)
                    break;
                else
                    i++;
            }
            item iter = new item();
            iter.setId(it.getIditem());
            iter.setName(it.getNameitem());
            iter.setPurchasecategory(it.getHowToBuy());
            this.getItems().getItems().add(iter);
            sell se = new sell();
            se.setId(it.getIditem());
            se.setPrice(amount);
            this.getStores().getStoress().get(i).getPrice().getSells().add(se);
        } else {
            while (i < this.getStores().getStoress().size()) {
                if (this.getStores().getStoress().get(i).getId() == idstore)
                    break;
                else
                    i++;
            }
            int j = 0;
            while (!found && j < this.getStores().getStoress().get(i).getPrice().getSells().size()) {
                if (this.getStores().getStoress().get(i).getPrice().getSells().get(j).getId() == it.getIditem())
                    found = true;
                else
                    j++;
            }
            if (found)
                throw new tryadditemthatsoldinstore();
            else {
                sell se = new sell();
                se.setId(it.getIditem());
                se.setPrice(amount);
                this.getStores().getStoress().get(i).getPrice().getSells().add(se);
            }

        }

    }

    public String howtobuyItem(int iditem) {
        item it = null;
        for (item i : this.getItems().getItems()) {
            if (i.getId() == iditem) {
                it = i;
                break;
            }
        }
        return (it.getPurchasecategory());
    }

    public void checkSameDiscount(String name) throws AddTrySameDiscount {
        int i = 0;
        boolean found = false;
        boolean founddisc = false;
        int j = 0;
        while (!found && i < this.getStores().getStoress().size()) {
            if (this.getStores().getStoress().get(i).getDiscs() != null) {
                founddisc = false;
                j = 0;
                while (!founddisc && j < this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().size()) {
                    if (this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getName().equals(name))
                        founddisc = true;
                    else
                        j++;
                }
                if (founddisc == true)
                    found = true;

            }
            if (!found)
                i++;
        }
        if (found)
            throw new AddTrySameDiscount();

    }

    public void AddOfferToDiscount(AddDiscToSys disca, int idofoffer, double amountofferitem, double priceUnit, int count) throws tryAddOfferThatFoundInDisc {
        int i = 0;
        for (i = 0; i < this.getStores().getStoress().size(); i++) {
            if (this.getStores().getStoress().get(i).getId() == disca.getIdOfStoreOfItem())
                break;
        }
        if (count == 0) {
            discount disc = new discount();
            disc.setName(disca.getNameDisc());
            DoYouBuyOffer doBuy = new DoYouBuyOffer();
            doBuy.setId(disca.getIdItem());
            doBuy.setQuantity(disca.getAmount());
            disc.setBuy(doBuy);
            YouGetOffer getoffer = new YouGetOffer();
            getoffer.setOperator(disca.getOperator());
            offer off = new offer();
            off.setId(idofoffer);
            off.setQuantity(amountofferitem);
            off.setPriceone(priceUnit);
            getoffer.AddOffer(off);
            disc.setGetoffer(getoffer);

            if (this.getStores().getStoress().get(i).getDiscs() == null) {
                discounts discs = new discounts();
                discs.Add(disc);
                this.getStores().getStoress().get(i).setDiscs(discs);
            } else {
                this.getStores().getStoress().get(i).getDiscs().Add(disc);
            }
        } else {
            int j = 0;
            while (j < this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().size()) {
                if (this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getName().equals(disca.getNameDisc()))
                    break;
                else
                    j++;
            }
            int k = 0;
            boolean found = false;
            while (!found && k < this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getGetoffer().getSdmoffer().size()) {
                if (this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getGetoffer().getSdmoffer().get(k).getId() == idofoffer)
                    found = true;
                else
                    k++;
            }
            if (found)
                throw new tryAddOfferThatFoundInDisc();
            else {
                offer off = new offer();
                off.setId(idofoffer);
                off.setPriceone(priceUnit);
                off.setQuantity(amountofferitem);
                this.getStores().getStoress().get(i).getDiscs().getSdmDiscounts().get(j).getGetoffer().getSdmoffer().add(off);
            }
        }
    }

    public boolean cordinatotOfStotre(int x, int y) {
        boolean found = false;
        for (store s : this.getStores().getStoress()) {
            if (s.getLocation().getY() == y && s.getLocation().getX() == x) {
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean cordinatotOfCustomer(int x, int y) {
        boolean found = false;
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getLocation().getX() == x && cust.getLocation().getY() == y) {
                found = true;
                break;
            }
        }
        return found;
    }

    public StoreInMap createStoreMap(int x, int y) {
        store s = null;
        for (store st : this.getStores().getStoress()) {
            if (st.getLocation().getX() == x && st.getLocation().getY() == y) {
                s = st;
                break;
            }
        }
        StoreInMap SMAP = new StoreInMap();
        SMAP.setIdstore(s.getId());
        SMAP.setNamestore(s.getName());
        SMAP.setPpk(s.getDelivery());
        SMAP.setCordinatax(s.getLocation().getX());
        SMAP.setCordinataY(s.getLocation().getY());
        SMAP.setSumOrders(sumOrdersInStore(s.getId()));
        return SMAP;
    }

    public int sumOrdersInStore(int idstore) {
        int count = 0;
        for (Order ord : Listorder) {
            if (ord.getIdOfStore() == idstore)
                count++;
        }
        for (orderDinamy ord : ListDinamyOrder) {
            for (itemToOrderDinamy it : ord.getItemsdinamy()) {
                if (it.getIdOfStoreOfItem() == idstore) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public CustomerofMap createCustInMap(int x, int y) {
        customer c = null;
        for (customer cust : this.getIcostomers().getSdmcustomers()) {
            if (cust.getLocation().getX() == x && cust.getLocation().getY() == y) {
                c = cust;
                break;
            }

        }
        CustomerofMap CSMP = new CustomerofMap();
        CSMP.setIdCustomer(c.getId());
        CSMP.setNameCustomer(c.getName());
        CSMP.setCordinataX(c.getLocation().getX());
        CSMP.setCordinataY(c.getLocation().getY());
        CSMP.setSumOrders(sumOrderdInCustomers(c.getId()));
        return CSMP;
    }

    public int sumSortItems() {
        int count = 0;
        for (item it : this.getItems().getItems())
            count++;
        return count;
    }

    public int SumStores() {
        int count = 0;
        for (store st : this.getStores().getStoress())
            count++;
        return count;
    }

    public int sumOrders() {
        int count = 0;
        for (Order ord : this.Listorder) {
            count++;
        }
        for (orderDinamy ord : this.ListDinamyOrder) {
            count++;
        }
        return count;
    }

    public Double SumPriceOrders() {
        double sum = 0;
        for (Order ord : this.Listorder) {
            for (itemToOrder it : ord.getItemtoorder()) {
                sum = sum + it.getPriceItem() + it.getPricemadeDiscount();

            }

        }
        for (orderDinamy ord : this.ListDinamyOrder) {
            for (itemToOrderDinamy it : ord.getItemsdinamy()) {
                sum = sum + it.getPriceItem() + it.getPricemadeDiscount();
            }
        }
        return sum;
    }

    public DatsInPlace createdataInPlace() {
        DatsInPlace data = new DatsInPlace();
        data.setNameStoreManager(this.nameStoreMan);
        data.setSzone(this.zoni.getNameZone());
        data.setSumSortsItems(sumSortItems());
        data.setSumStores(SumStores());
        data.setSumOrders(sumOrders());
        double avgPrice = 0;
        if(data.getSumOrders()==0) {
           avgPrice=0;
           data.setAvgPriceOrder(avgPrice);
        }
        else {
              avgPrice = (double) SumPriceOrders() / (double) (sumOrders());
            data.setAvgPriceOrder(avgPrice);
        }
        return data;

    }

    public roleAndNaneUser createUser() {
        roleAndNaneUser r = new roleAndNaneUser();
        r.setNamei(this.nameStoreMan);
        r.setRolei(this.roleOfUser);
        return r;
    }

    public IdAndNameStore createStore(int idStore) {
        IdAndNameStore I = new IdAndNameStore();
        I.setIdstore(idStore);
        String name = null;
        for (store s : this.getStores().getStoress()) {
            if (idStore == s.getId()) {
                name = s.getName();
                break;
            }
        }
        I.setNameStore(name);
        return I;
    }

    public storesInSystem createStores(int idstore) {
        ArrayList<itemInStore> list = new ArrayList<>();
        store st = null;
        for (store s : this.getStores().getStoress()) {
            if (s.getId() == idstore) {
                st = s;
                break;
            }
        }
        for (sell it : st.getPrice().getSells()) {
            String nameItem = "";
            String howBuy = "";
            int iditem = it.getId();
            for (item i : this.getItems().getItems()) {
                if (i.getId() == iditem) {
                    nameItem = i.getName();
                    howBuy = i.getPurchasecategory();
                    break;

                }
            }
            double costPriceUnit = it.getPrice();
            double sumitemthatsoldInStore = countItemsSoldInStore(idstore, iditem);
            itemInStore ItemInSt = new itemInStore(iditem, nameItem, howBuy, costPriceUnit, sumitemthatsoldInStore);
            list.add(ItemInSt);

        }
        storesInSystem storeSy = new storesInSystem();
        storeSy.setIdStore(idstore);
        storeSy.setNameSore(st.getName());
        storeSy.setStoreManeger(this.nameStoreMan);
        int corx = st.getLocation().getX();
        int costy = st.getLocation().getY();
        String lx = String.format("%d", corx);
        String ly = String.format("%d", costy);
        storeSy.setLocationOfStore("X" + ":" + lx + "Y" + ":" + ly);
        storeSy.setPpk(st.getDelivery());
        int sumorderstore = sumOrdersInStore(idstore);
        storeSy.setSumordersOfStore(sumorderstore);
        storeSy.setCostOfItemsThatSold(sumCostOrdersInStore(idstore));
        storeSy.setSumCostOfOrdersInStore((sumSendingInStore(idstore)) + sumCostOrdersInStore(idstore));
        storeSy.setList(list);
        return storeSy;

    }

    public double sumCostOrdersInStore(int idstore) {
        double totalPrice = 0;
        for (Order ord : this.Listorder) {
            if (ord.getIdOfStore() == idstore) {
                {
                    for(itemToOrder it:ord.getItemtoorder() )
                    {
                        totalPrice=totalPrice+it.getSumPriceItem()+it.getPricemadeDiscount();
                    }
                }
            }
        }

        for (orderDinamy ord : this.ListDinamyOrder) {
            for (itemToOrderDinamy it : ord.getItemsdinamy()) {
                if (it.getIdOfStoreOfItem() == idstore) {
                    totalPrice = totalPrice + it.getSumPriceItem() + it.getPricemadeDiscount();
                }

            }
        }
        return totalPrice;
    }

    public ArrayList<ShowStoreToOrder> buildListStoresInOrderStatic(int idCustomer) {
        double price = 0;
        ArrayList<ShowStoreToOrder> CreateShowsOrder = new ArrayList<>();
        int i = 0;
        int x = 0;
        int y = 0;
        price = 0;
        for (store st : this.getStores().getStoress()) {
            ShowStoreToOrder Stro = new ShowStoreToOrder();
            Stro.setIdOfStore(st.getId());
            Stro.setNameStore(st.getName());
            Stro.setCordinatax(st.getLocation().x);
            Stro.setCordinatay(st.getLocation().y);
            Stro.setPpk(st.getDelivery());
            for (customer cust : this.getIcostomers().getSdmcustomers()) {
                if (cust.getId() == idCustomer) {
                    x = cust.getLocation().getX();
                    y = cust.getLocation().getY();
                    break;
                }
            }
            double HefreshRbuyiX = Math.pow((double) (st.getLocation().x - x), 2);
            double hefreshRibuyiY = Math.pow((double) (st.getLocation().getY() - y), 2);
            Stro.setDitance(Math.sqrt(HefreshRbuyiX + hefreshRibuyiY));
            Stro.setPriceSend((double) (st.getDelivery() * (Math.sqrt(HefreshRbuyiX + hefreshRibuyiY))));
            for (sell sel : st.getPrice().getSells()) {
                price = price + sel.getPrice();
            }
            Stro.setAmountKindsItems(st.getPrice().getSells().size());
            Stro.setSumPrices(price);
            CreateShowsOrder.add(Stro);
        }
        return CreateShowsOrder;
    }

    public ArrayList<privateDataOrder> CreateListPrivateorder(int idcustomer) {
        ArrayList<privateDataOrder> Listpriveorders = new ArrayList<>();
        for (Order ord : Listorder) {
            int cordinatax = 0;
            int cordinatay = 0;
            int xstore = 0;
            int ystore = 0;
            if (ord.getIdcust() == idcustomer) {
                privateDataOrder porder = new privateDataOrder();
                porder.setIdorder(ord.getIdCountOrder());
                LocalDate date = ord.getDate();
                porder.setDate(date.toString());
                for (customer cust : this.getIcostomers().getSdmcustomers()) {
                    if (cust.getId() == idcustomer) {
                        cordinatax = cust.getLocation().getX();
                        cordinatay = cust.getLocation().getY();
                        break;
                    }
                }
                for (store st : this.getStores().getStoress()) {
                    if (ord.getIdOfStore() == st.getId()) {
                        xstore = st.getLocation().getX();
                        ystore = st.getLocation().getY();
                        break;
                    }
                }
                porder.setCordinataX(cordinatax);
                porder.setCordinataY(cordinatay);
                porder.setSumStores(1);
                porder.setSumCountItems(ord.countItemsinorder());
                porder.setSumPriceItems(ord.PriceSumItems());
                porder.setSumSending(ord.SendingCost(cordinatax, cordinatay, xstore, ystore));
                porder.setCostSumOrder(porder.getSumPriceItems() + porder.getSumSending());
                Listpriveorders.add(porder);

            }
        }
        for (orderDinamy ord : this.getListDinamyOrder()) {
            int cordinatax = 0;
            int cordinatay = 0;
            if (ord.getIdCustomer() == idcustomer) {
                privateDataOrder porder = new privateDataOrder();
                porder.setIdorder(ord.getIdCountOrder());
                LocalDate date = ord.getDate();
                porder.setDate(date.toString());
                for (customer cust : this.getIcostomers().getSdmcustomers()) {
                    if (cust.getId() == idcustomer) {
                        cordinatax = cust.getLocation().getX();
                        cordinatay = cust.getLocation().getY();
                        break;
                    }
                }
                porder.setCordinataX(cordinatax);
                porder.setCordinataY(cordinatay);
                porder.setSumStores(ord.sumStoreaInOrder());
                porder.setSumCountItems(ord.countItemsinorder());
                porder.setSumPriceItems(ord.PriceSumItems());
                porder.setSumSending(ord.sumsending(cordinatax, cordinatay));
                porder.setCostSumOrder(porder.getSumPriceItems() + porder.getSumSending());
                Listpriveorders.add(porder);

            }
        }
        return Listpriveorders;
    }
    public ArrayList<showItemsConclusionOrder>createNodeInStore(int orderid,int idstore)
    {
        ArrayList<showItemsConclusionOrder>listCoclusionItemsInStore=new ArrayList<>();
        Order ord=null;
        orderDinamy ordDinamy=null;
        boolean found=false;
        for(Order order:this.getListorder())
        {
            if(order.getIdCountOrder()==orderid&&order.getIdOfStore()==idstore)
            {
                ord=order;
                found=true;
                break;
            }
        }
        if(found)
        {
            for(itemToOrder it:ord.getItemtoorder())
            {
                showItemsConclusionOrder show=createNode(it);
                listCoclusionItemsInStore.add(show);
            }
        }
        else
        {
            for(orderDinamy order:this.getListDinamyOrder())
            {
                if(order.getIdCountOrder()==orderid)
                {
                    ordDinamy=order;
                    found=true;
                    break;
                }
            }
            for(itemToOrderDinamy it:ordDinamy.getItemsdinamy())
            {
                if(it.getIdOfStoreOfItem()==idstore)
                {
                    showItemsConclusionOrder show=createNode(it);
                    listCoclusionItemsInStore.add(show);
                }
            }
        }

        return listCoclusionItemsInStore;
    }
    public ArrayList<String>createItemsSystem()
    {
        ArrayList<String>list=new ArrayList<>();
        String itemStr="";
        for(item it:this.getItems().getItems())
        {
            itemStr=String.format("%d",it.getId())+","+it.getName();
            list.add(itemStr);
        }
        return  list;
    }
    public int maxidItem()
    {
        int maxi=0;
        for(item it:this.getItems().getItems())
        {
            if(it.getId()>=maxi)
            {
                maxi=it.getId();
            }
        }
        return  maxi;
    }

}






