package exceptions;

public class itemsellmoreoneinstoreexception extends Exception {

    public String create()
    {
        String str="In store has item thate definrd one more time in file, please load new file";
        return str;
    }
    public void print()
    {
        String str=create();
        System.out.println(str);
    }
}
