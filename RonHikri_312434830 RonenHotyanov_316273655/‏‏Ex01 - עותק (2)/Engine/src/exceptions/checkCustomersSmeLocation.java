package exceptions;

public class checkCustomersSmeLocation extends Exception {

    public String create()
    {
        String str="In The File, has Customers have with location";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
