package clasinEx;

import generated.SDMStore;
import generated.SDMStores;

import java.util.ArrayList;
import java.util.List;


public class stores{
    protected  List<store>sdmStore;

    public  void newinstance(SDMStores S_stores, stores S) {

            sdmStore = new ArrayList<store>();
        for (SDMStore sTORESS : S_stores.getSDMStore()) {
            store s=new store();
            s.createnewInstance(sTORESS,s);
            sdmStore.add(s);
        }

    }



    public List<store> getStoress()
    {
        if(sdmStore==null)
            sdmStore=new ArrayList<store>();
        return sdmStore;
    }
    public void Add(store s)
    {
        sdmStore.add(s);
    }

}