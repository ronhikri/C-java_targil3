package exceptions;

public class offersthatnotFound extends Exception {

    public String create()
    {
        String str="The Offer Not Found In File";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
