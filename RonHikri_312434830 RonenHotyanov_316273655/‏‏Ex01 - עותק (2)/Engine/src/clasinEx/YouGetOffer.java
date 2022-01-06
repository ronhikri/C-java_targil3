package clasinEx;

import generated.SDMOffer;
import generated.ThenYouGet;

import java.util.ArrayList;

public class YouGetOffer {
    private ArrayList<offer>sdmoffers;

    private String operator;

    public void createYouGetOffer(ThenYouGet sdmoffer, YouGetOffer getoffer)
    {
        sdmoffers=new ArrayList<>();
        for(SDMOffer sdmoff:sdmoffer.getSDMOffer())
        {
            offer off=new offer();
            off.createOffer(sdmoff,off);
            sdmoffers.add(off);
        }
        getoffer.setOperator(sdmoffer.getOperator());
    }

    public ArrayList<offer>getSdmoffer()
    {
        if(sdmoffers==null)
            sdmoffers=new ArrayList<>();
        return sdmoffers;
    }
    public void AddOffer(offer off)
    {
        if(this.sdmoffers==null)
            sdmoffers=new ArrayList<>();
        this.sdmoffers.add(off);
    }
    public String getOperator()
    {
        return this.operator;
    }
    public void setOperator(String value)
    {
        this.operator=value;
    }
}
