package exceptions;

public class tryadditemthatsoldinstore extends Exception {
    public String create()
    {
        String st="impossible to add item to store beacause of item exist in store";
        return st;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
