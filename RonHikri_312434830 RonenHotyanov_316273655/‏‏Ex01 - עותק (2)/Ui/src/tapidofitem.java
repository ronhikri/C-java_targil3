import java.util.ArrayList;

public class tapidofitem implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        instructions=new ArrayList<String>();
        instructions.add("please tap id of item to order");
        return instructions;
    }
    public void printMenu()
    {
        instructions=create();
         System.out.println(instructions.get(0));
    }
}
