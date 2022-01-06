import java.util.ArrayList;

public class selectIdofItemToOrder implements InterfaceshowMr {
    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        instructions=new ArrayList<String>();
        instructions.add("tap a to enter id of item");
        instructions.add("tap q to exit from order");
        return instructions;
    }
    public void printMenu()
    {
        instructions=create();
        for(int i=0;i<instructions.size();i++)
        System.out.println(instructions.get(i));
    }
}
