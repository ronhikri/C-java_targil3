package exceptions;

public class LocationNotFixOfUser extends Exception {

    public String create()
    {
        String str="The locsation that you select not fix, please select a fix location";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
