package clasinEx;


import generated.SDMPrices;
import generated.SDMSell;

import java.util.ArrayList;
import java.util.List;


public class prices {
    protected  List<sell> sdmSell;

    public void newInstance(SDMPrices pricess, prices p)
    {
        sdmSell=new ArrayList<sell>();
        for(SDMSell sel:pricess.getSDMSell())
        {
            sell selling=new sell();
            selling.creaeInstance(sel,selling);
            sdmSell.add(selling);
        }

    }


    public List<sell> getSells() {
        if(sdmSell==null)
            sdmSell=new ArrayList<sell>();
        return this.sdmSell;
    }
    public void Addsell(sell s)
    {
        if(sdmSell==null)
            sdmSell=new ArrayList<sell>();
        sdmSell.add(s);
    }
}
