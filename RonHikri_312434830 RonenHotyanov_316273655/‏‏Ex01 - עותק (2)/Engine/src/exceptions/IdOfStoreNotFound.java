package exceptions;

public class IdOfStoreNotFound extends Exception{

    public String create()
    {
        String str="The Id That you give not found in file";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
