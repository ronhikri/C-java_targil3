package exceptions;

public class locationofsoreexcept extends Exception {
    public String create()
    {
        String str="In File has store that excepts from location,please load new file";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
