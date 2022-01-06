package exceptions;

public class checksamecustomers extends Exception {

    public String create()
    {
        String str="In The File' has customers with same id";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
