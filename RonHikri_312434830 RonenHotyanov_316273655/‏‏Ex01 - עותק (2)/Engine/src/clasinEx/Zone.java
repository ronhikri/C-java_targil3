package clasinEx;

import generated.SuperDuperMarketDescriptor;

public class Zone {
    private String nameZone;

    public void create(SuperDuperMarketDescriptor.SDMZone Zoni,Zone z)
    {
        z.setNameZone(Zoni.getName());
    }

    public String getNameZone() {
        return nameZone;
    }

    public void setNameZone(String nameZone) {
        this.nameZone = nameZone;
    }

}
