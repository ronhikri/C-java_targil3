package exceptions;

public class IdOfItemNotFound extends  Exception {

    public String create()
    {
        String str="The Id Of item you give not found";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
