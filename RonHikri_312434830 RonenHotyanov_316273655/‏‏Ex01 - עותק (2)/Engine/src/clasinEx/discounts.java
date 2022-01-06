package clasinEx;

import generated.SDMDiscount;
import generated.SDMDiscounts;

import java.util.ArrayList;

public class discounts {

    private ArrayList<discount>sdmDiscounts;

    public void createDiscounts(SDMDiscounts sdmdiscounts, discounts discs) {
        sdmDiscounts = new ArrayList<>();
        if (sdmdiscounts != null) {
            for (SDMDiscount sdmdisc : sdmdiscounts.getSDMDiscount()) {
                discount disc = new discount();
                disc.createDiscount(sdmdisc, disc);
                sdmDiscounts.add(disc);
            }
        }
    }

    public ArrayList<discount>getSdmDiscounts()
    {
        if(sdmDiscounts==null)
            sdmDiscounts=new ArrayList<>();
        return sdmDiscounts;
    }
    public void Add(discount disc)
    {
        if(sdmDiscounts==null)
            sdmDiscounts=new ArrayList<>();
        sdmDiscounts.add(disc);
    }
}
