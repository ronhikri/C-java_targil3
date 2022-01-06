package exceptions;

public class idsameitemsorstoresexceptions extends Exception {

    public String create()
    {
        String str="Same Id Of Items Or Stores, please load new file";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }

}
