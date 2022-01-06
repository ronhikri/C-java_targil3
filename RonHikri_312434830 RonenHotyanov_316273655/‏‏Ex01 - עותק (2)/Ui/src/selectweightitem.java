import java.util.ArrayList;

public class selectweightitem  implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        instructions=new ArrayList<String>();
        instructions.add("Tap a number for a weight amount of item to order");
        return instructions;
    }
    public void printMenu()
    {
        instructions=create();
        System.out.println(instructions.get(0));
    }
}
