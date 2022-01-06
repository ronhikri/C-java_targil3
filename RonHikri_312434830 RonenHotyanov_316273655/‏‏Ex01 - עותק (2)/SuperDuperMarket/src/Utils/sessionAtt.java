package Utils;

import clasinEx.*;
import exceptions.tryAccheiveDiscountThatNoEnough;

import java.time.LocalDate;
import java.util.ArrayList;

public class sessionAtt {

    private ArrayList<classManeger> objs;
    private int value;
    private int role;
    private String username;
    private LocalDate date;
    private String nameZone;
    private int selectorder;
    private int idstore;
    private ArrayList<itemToOrderDinamy> itemsdinamyorder;
    private ArrayList<itemToOrder> itemtoorder;
    private discount discer;
    private storeToSystem stored;
    private int countitemToNewStore;
    private itemToSystem itemed;
    private int idnewitem;
    private int countStoresToItem;
    private String nanecurrentZoneToAddItem;


    public sessionAtt(int x, String name, int y) {
        value = x;
        objs = new ArrayList<>();
        username = name;
        role = y;
        itemtoorder=new ArrayList<>();
        itemsdinamyorder=new ArrayList<>();

    }

    public ArrayList<classManeger> getObjs() {
        if (objs == null)
            objs = new ArrayList<>();
        return objs;
    }

    public void addobj(classManeger obj) {
        if (objs == null)
            objs = new ArrayList<>();
        objs.add(obj);
    }

    public int getCountitemToNewStore() {
        return countitemToNewStore;
    }

    public void setCountitemToNewStore(int countitemToNewStore) {
        this.countitemToNewStore = countitemToNewStore;
    }

    public storeToSystem getStored() {
        return stored;
    }

    public void setStored(storeToSystem stored) {
        this.stored = stored;
    }

    public discount getDiscer() {
        return discer;
    }

    public void setDiscer(discount discer) {
        this.discer = discer;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int value) {
        this.role = value;
    }


    public void setObjs(ArrayList<classManeger> objs) {
        this.objs = objs;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate datei) {
        this.date = datei;
    }

    public void setNameZone(String name) {
        this.nameZone = name;
    }

    public String getNameZone() {
        return this.nameZone;
    }
    public int getSelectorder()
    {
        return this.selectorder;
    }
    public void setSelectorder(int x)
    {
        this.selectorder=x;
    }

    public int getIdstore() {
        return idstore;
    }

    public void setIdstore(int idstore) {
        this.idstore = idstore;
    }

    public itemToSystem getItemed() {
        return itemed;
    }

    public void setItemed(itemToSystem itemed) {
        this.itemed = itemed;
    }

    public int getIdnewitem() {
        return idnewitem;
    }

    public void setIdnewitem(int idnewitem) {
        this.idnewitem = idnewitem;
    }

    public int getCountStoresToItem() {
        return countStoresToItem;
    }

    public void setCountStoresToItem(int countStoresToItem) {
        this.countStoresToItem = countStoresToItem;
    }

    public void addToListorder(classManeger obj, int idstore, int iditem, double countItems)
    {
        store storeorder=null;
        String namemaneger=null;
        for(store st:obj.getStores().getStoress())
        {
            if(st.getId()==idstore)
            {
            storeorder=st;
            namemaneger=st.getNameStoreManege();
            break;

            }
        }
        int k=0;
        boolean found=false;
        double prices=0;
        String name_item=null;
        String howbuy=null;
        while (!found&&k<itemtoorder.size())
        {
            if(itemtoorder.get(k).getId()==iditem)
                found=true;
            else
                k++;
        }
        if(found)
        {
            itemtoorder.get(k).setCountItemToOrder(itemtoorder.get(k).getCountItemToOrder() + countItems);
            itemtoorder.get(k).setSumPriceItem((itemtoorder.get(k).getCountItemToOrder()) * (itemtoorder.get(k).getCountItemToOrder()));
            itemtoorder.get(k).setQuantityemaindDisc(itemtoorder.get(k).getCountItemToOrder());
        }
        else
        {
            for(sell sel:storeorder.getPrice().getSells())
            {
                if(sel.getId()==iditem)
                {
                    prices=sel.getPrice();
                    break;
                }
            }
            ArrayList<discount>discs=obj.creatediscounts(idstore,iditem);
            itemToOrder itemorder = new itemToOrder(discs);
            for(item it:obj.getItems().getItems())
            {
                if(it.getId()==iditem) {

                    name_item = it.getName();
                    howbuy = it.getPurchasecategory();
                    break;
                }
            }
            itemorder.setNameStoreManegerOfItem(namemaneger);
            itemorder.setId(iditem);
            itemorder.setDogitten(false);
            itemorder.setNameItem(name_item);
            itemorder.setIdStore(this.getIdstore());
            itemorder.setNameStore(storeorder.getName());
            itemorder.setPurIt(howbuy);
            itemorder.setPriceItem(prices);
            itemorder.setCountItemToOrder(countItems);
            itemorder.setSumPriceItem(prices * countItems);
            itemorder.setQuantityemaindDisc(itemorder.getCountItemToOrder());
            itemorder.setPricemadeDiscount(0);
            itemtoorder.add(itemorder);



        }
    }
    public void AddListItemdinamyOrder(classManeger obj,int idofitem, int idofstore, double countofitems) {

        store storeorder = null;
        String nameManeger=null;
        for (store st : obj.getStores().getStoress()) {
            if (st.getId() == idofstore) {
                storeorder = st;
                nameManeger=st.getNameStoreManege();
                break;

            }
        }
        int k = 0;
        boolean found = false;
        double prices = 0;
        String name_item = null;
        String howbuy = null;
        while (!found && k < itemsdinamyorder.size()) {
            if (itemsdinamyorder.get(k).getId() == idofitem)
                found = true;
            else
                k++;
        }
        if (found) {
            itemsdinamyorder.get(k).setCountItemToOrder(itemsdinamyorder.get(k).getCountItemToOrder() + countofitems);
            itemsdinamyorder.get(k).setSumPriceItem((itemsdinamyorder.get(k).getCountItemToOrder()) * (itemsdinamyorder.get(k).getCountItemToOrder()));
            itemsdinamyorder.get(k).setQuantityemaindDisc(itemsdinamyorder.get(k).getCountItemToOrder());
        } else {
            for (sell sel : storeorder.getPrice().getSells()) {
                if (sel.getId() == idofitem) {
                    prices = sel.getPrice();
                    break;
                }
            }
            ArrayList<discount> discs = obj.creatediscounts(idofstore, idofitem);
            itemToOrder itemorder = new itemToOrder(discs);
            for (item it : obj.getItems().getItems()) {
                if (it.getId() == idofitem) {
                    name_item = it.getName();
                    howbuy = it.getPurchasecategory();
                    break;
                }
            }
            itemToOrderDinamy itemdinamyorder = new itemToOrderDinamy(discs);
            itemdinamyorder.setId(idofitem);
            itemdinamyorder.setNameItem(name_item);
            itemdinamyorder.setNameStoreManegerOfItem(nameManeger);
            itemdinamyorder.setPurIt(howbuy);
            itemdinamyorder.setPriceItem(prices);
            itemdinamyorder.setCountItemToOrder(countofitems);
            itemdinamyorder.setIdOfStoreOfItem(idofstore);
            itemdinamyorder.setNameStoreOfItem(storeorder.getName());
            itemdinamyorder.setIdStore(idofstore);
            itemdinamyorder.setNameStore(storeorder.getName());
            itemdinamyorder.setPpk(storeorder.getDelivery());
            itemdinamyorder.setSpace(storeorder.getLocation());
            itemdinamyorder.setSumPriceItem(prices * countofitems);
            itemdinamyorder.setQuantityemaindDisc(itemdinamyorder.getCountItemToOrder());
            itemdinamyorder.setDogitten(false);
            itemdinamyorder.setPricemadeDiscount(0);
            itemsdinamyorder.add(itemdinamyorder);

        }
    }
    public void intiaill()
    {
        itemtoorder=new ArrayList<>();
    }
    public void intiall2()
    {
        itemsdinamyorder=new ArrayList<>();
    }
    public ArrayList<itemToOrder>getItemtoorder()
    {
        if(itemtoorder==null)
            itemtoorder=new ArrayList<>();
        return itemtoorder;
    }
    public ArrayList<itemToOrderDinamy>getItemsdinamyorder()
    {
        if(itemsdinamyorder==null)
            itemsdinamyorder=new ArrayList<>();
        return itemsdinamyorder;
    }
    public ArrayList<DiscountToOrder>createDiscToOrd(classManeger obj)
    {
        ArrayList<DiscountToOrder>dics=new ArrayList<>();
       if(this.getSelectorder()==1)
       {
           for(itemToOrder it:this.getItemtoorder())
           {
               ArrayList<DiscountToOrder>discPrivateItem=buildsDiscs(obj,it);
               for(DiscountToOrder dic:discPrivateItem)
               {
                   dics.add(dic);
               }
           }
       }
       if(this.getSelectorder()==2)
       {
           for(itemToOrderDinamy it:this.getItemsdinamyorder())
           {
               ArrayList<DiscountToOrder>discPrivateItem=buildsDiscs(obj,it);
               for(DiscountToOrder dic:discPrivateItem)
               {
                   dics.add(dic);
               }
           }
       }
       return dics;
    }
    public ArrayList<DiscountToOrder>buildsDiscs(classManeger obj,itemToOrder it)
    {
        ArrayList<DiscountToOrder>discs=new ArrayList<>();
        for(discount dis:it.getDiscs())
        {
            if(it.getQuantityemaindDisc()>=dis.getBuy().getQuantity()) {
                DiscountToOrder D = new DiscountToOrder();
                D.setNameofDiscount(dis.getName());
                D.setIdOfDisc(dis.getBuy().getId());
                String nameItem = "";
                for (item iter : obj.getItems().getItems()) {
                    if (iter.getId() == it.getId()) {
                        nameItem = iter.getName();
                        break;
                    }
                }
                D.setNameItemDiscount(nameItem);
                D.setQuantityitemDisc(dis.getBuy().getQuantity());
                D.setOperationDiscount(dis.getGetoffer().getOperator());
                discs.add(D);
            }
        }
        return discs;

    }
    public void UpdateDiscounnts(classManeger obj,discount d, int selected)throws tryAccheiveDiscountThatNoEnough
    {
        boolean found = false;
        int i=0;
        if(this.getSelectorder()==1)
        {
            for(i=0;i<itemtoorder.size();i++)
            {
                if(itemtoorder.get(i).getId()==d.getBuy().getId())
                    break;
            }
            if (itemtoorder.get(i).getQuantityemaindDisc() >= d.getBuy().getQuantity()) {
                itemtoorder.get(i).setQuantityemaindDisc(itemtoorder.get(i).getQuantityemaindDisc() - d.getBuy().getQuantity());
                double price = 0;
                for (offer off : d.getGetoffer().getSdmoffer()) {
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
                if (itemsdinamyorder.get(i).getId() == d.getBuy().getId())
                    break;
            }
            if (itemsdinamyorder.get(i).getQuantityemaindDisc() >= d.getBuy().getQuantity()) {
                itemsdinamyorder.get(i).setQuantityemaindDisc(itemsdinamyorder.get(i).getQuantityemaindDisc() - d.getBuy().getQuantity());
                double price = 0;
                for (offer off : d.getGetoffer().getSdmoffer()) {
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
    public void updateAccordingitem(classManeger obj,discount d,  int iditem, int selected) throws tryAccheiveDiscountThatNoEnough {
        boolean found = false;
        int i=0;
        if (selected == 1) {
            for (i = 0; i < itemtoorder.size(); i++) {
                if (itemtoorder.get(i).getId() == d.getBuy().getId())
                    break;
            }
            if (itemtoorder.get(i).getQuantityemaindDisc() >= d.getBuy().getQuantity()) {
                itemtoorder.get(i).setQuantityemaindDisc(itemtoorder.get(i).getQuantityemaindDisc() - d.getBuy().getQuantity());
                double price = 0;
                for (offer off : d.getGetoffer().getSdmoffer()) {
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
                if (itemsdinamyorder.get(i).getId() == d.getBuy().getId())
                    break;
            }
            if (itemsdinamyorder.get(i).getQuantityemaindDisc() >= d.getBuy().getQuantity()) {
                itemsdinamyorder.get(i).setQuantityemaindDisc(itemsdinamyorder.get(i).getQuantityemaindDisc() - d.getBuy().getQuantity());
                double price = 0;
                for (offer off : d.getGetoffer().getSdmoffer()) {
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
    public discount retDisc(String name)
    {
        discount d=null;
        boolean found1=false;
        boolean found2=false;
        boolean found=false;
        for(itemToOrder it:this.getItemtoorder())
        {
            for(discount disera:it.getDiscs())
            {
                if(disera.getName().equals(name))
                {
                    found1=true;
                    d=disera;
                    break;
                }
            }
            if(found1)
            {
                found=true;
                break;
            }

        }
        if(!found)
        {
            for(itemToOrderDinamy it:this.getItemsdinamyorder())
            {
                for(discount disera:it.getDiscs())
                {
                    if(disera.getName().equals(name))
                    {
                        found2=true;
                        d=disera;
                        break;
                    }
                }
                if(found2)
                {
                    found=true;
                    break;
                }
            }
        }
        return d;

    }

    public String getNanecurrentZoneToAddItem() {
        return nanecurrentZoneToAddItem;
    }

    public void setNanecurrentZoneToAddItem(String nanecurrentZoneToAddItem) {
        this.nanecurrentZoneToAddItem = nanecurrentZoneToAddItem;
    }
    public int KindItems(ArrayList<itemToOrder>itemss)
    {
        return (itemss.size());
    }
    public double CostStatieItems(ArrayList<itemToOrder>itemmms)
    {
        double pricer=0;
        for(itemToOrder it:itemmms)
        {
            pricer=pricer+it.getSumPriceItem()+it.getPricemadeDiscount();
        }
        return pricer;
    }
    public double dinamyCostItems(ArrayList<itemToOrderDinamy>itemmms)
    {
        double pricer=0;
        for(itemToOrderDinamy it:itemmms)
        {
            pricer=pricer+it.getSumPriceItem()+it.getPricemadeDiscount();
        }
        return pricer;
    }
    public double sendCostDinamy(classManeger obj,ArrayList<itemToOrderDinamy>itemmmms)
    {
        store st=null;
        double send = 0;
        int x = 0;
        int y = 0;
        for (customer cust : obj.getIcostomers().getSdmcustomers()) {
            if (cust.getId() == this.getValue()) {
                x = cust.getLocation().getX();
                y = cust.getLocation().getY();
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < itemmmms.size() - 1; i++) {
            for (int j = i + 1; j < itemmmms.size() - 1; j++) {
                if (itemmmms.get(i).getIdStore() == itemmmms.get(j).getIdStore())
                    count++;
            }
            if (count == 0) {
                for(store s:obj.getStores().getStoress())
                {
                    if(s.getId()==itemmmms.get(i).getIdStore())
                    {
                        st=s;
                        break;
                    }
                }
                double hefreshXribuyi = Math.pow((double) (st.getLocation().getX() - x), 2);
                double hefreshYribuyi = Math.pow((double) (st.getLocation().getY() - y), 2);
                double sending = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
                send = send + (sending) * ((double) (st.getDelivery()));
            }
            count = 0;
        }
        for(store s:obj.getStores().getStoress())
        {
            if(s.getId()==itemmmms.get(itemmmms.size()-1).getIdStore())
            {
                st=s;
                break;
            }
        }
        double hefreshXribuyi = Math.pow((double) (st.getLocation().getX() - x), 2);
        double hefreshYribuyi = Math.pow((double) (st.getLocation().getY()-y), 2);
        double sending = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
        send = send + (sending) * ((double) (st.getDelivery()));
        return send;
    }
    public double sumCostStatie(classManeger obj,ArrayList<itemToOrder>itemms)
    {
        int x=0;
        int y=0;
        for(customer cust:obj.getIcostomers().getSdmcustomers())
        {
            if(cust.getId()==this.getValue())
            {
                x=cust.getLocation().getX();
                y=cust.getLocation().getY();
                break;
            }
        }
        double send=0;
        store st=null;
        for(store s:obj.getStores().getStoress())
        {
            if(s.getId()==this.getIdstore())
            {
                st=s;
                break;
            }
        }
        double hefreshXribuyi = Math.pow((double) (st.getLocation().getX() - x), 2);
        double hefreshYribuyi = Math.pow((double) (st.getLocation().getY()-y), 2);
        double sending = Math.sqrt(hefreshXribuyi + hefreshYribuyi);
        send = send + (sending) * ((double) (st.getDelivery()));
        return send;

    }
}

