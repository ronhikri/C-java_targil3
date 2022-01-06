package exceptions;

public class offerThatNotSoldInStore extends Exception {

    public String create()
    {
        String str="In The File, Has offers that not sold in store";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
