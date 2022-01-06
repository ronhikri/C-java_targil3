package exceptions;

public class trytoaddLocationInStorethatfound extends Exception{
    public String create()
    {
        String str="no impossible To add store beacause location";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
