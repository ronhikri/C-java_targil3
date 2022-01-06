package exceptions;

public class itemnotexitinrefexception extends Exception {

    public String create()
    {
        String str="In The File, in the store has item is not excist in file";
                return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }

}
