package clasinEx;

import generated.SDMCustomer;
import generated.SDMCustomers;

import java.util.ArrayList;

public class customers {
    private ArrayList<customer>sdmcustomers;

    public void createCuatomers(SDMCustomers sdmcusts,customers custs)
    {
        sdmcustomers=new ArrayList<customer>();
        if(sdmcusts!=null) {
            for (SDMCustomer cust : sdmcusts.getSDMCustomer()) {
                customer custi = new customer();
                custi.createCustomer(cust, custi);
                sdmcustomers.add(custi);
            }
        }

    }
    public customers()
    {
        sdmcustomers=new ArrayList<>();
    }

    public ArrayList<customer>getSdmcustomers()
    {
        if(sdmcustomers==null)
            sdmcustomers=new ArrayList<>();
        return sdmcustomers;
    }
public void Addd(customer c)
{
    if(sdmcustomers==null)
        sdmcustomers=new ArrayList<>();
        sdmcustomers.add(c);
}

}

