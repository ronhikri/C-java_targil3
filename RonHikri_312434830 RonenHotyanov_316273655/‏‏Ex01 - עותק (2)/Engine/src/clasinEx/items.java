package clasinEx;

import generated.SDMItem;
import generated.SDMItems;

import java.util.ArrayList;
import java.util.List;


public class items {

    protected  List<item> sdmItem;

    public  void newInstance(SDMItems SDitems, items is)
    {
        sdmItem=new ArrayList<item>();
        for(SDMItem Item:SDitems.getSDMItem())
        {
            item iten=new item();
           iten.createInstanceBySDM(Item,iten);
           sdmItem.add(iten);
        }

    }

    public List<item> getItems() {
        if(sdmItem==null)
            sdmItem=new ArrayList<item>();
        return sdmItem;
    }


}
