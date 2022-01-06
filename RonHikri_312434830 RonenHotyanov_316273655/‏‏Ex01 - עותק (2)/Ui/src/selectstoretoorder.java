import java.util.ArrayList;

public class selectstoretoorder implements InterfaceshowMr {
    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        instructions=new ArrayList<String>();
        instructions.add("Tap please id of store that you select to order");
        return instructions;
    }
    public void printMenu()
    {
        instructions=create();
        System.out.println(instructions.get(0));
    }
}
