package exceptions;

public class itemthatnotsellexception extends Exception {

    public String create()
    {
        String str="The item not sell,please load new file";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }

}
