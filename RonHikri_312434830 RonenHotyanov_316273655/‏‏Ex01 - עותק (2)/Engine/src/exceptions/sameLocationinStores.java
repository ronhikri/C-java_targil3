package exceptions;

public class sameLocationinStores extends Exception {

    public String create()
    {
        String str="In The File, have Stores has same location";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
