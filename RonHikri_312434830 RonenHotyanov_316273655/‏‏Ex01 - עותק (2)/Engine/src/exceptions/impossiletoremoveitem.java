package exceptions;

public class impossiletoremoveitem extends Exception {

    public String create()
    {
        String st="impossible to remove item beacause only one store sold this item or one item in store";
        return st;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
