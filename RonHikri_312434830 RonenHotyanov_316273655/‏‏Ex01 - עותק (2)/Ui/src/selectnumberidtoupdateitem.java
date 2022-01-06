import java.util.ArrayList;

public class selectnumberidtoupdateitem implements InterfaceshowMr {

    private ArrayList<String>instruction;

    public ArrayList<String>create()
    {
        ArrayList<String >ins=new ArrayList<>();
        ins.add("tap number fiz id of item to update item in store");
        return ins;
    }
    public void printMenu()
    {
        instruction=create();
        System.out.println(instruction.get(0));
    }
}
