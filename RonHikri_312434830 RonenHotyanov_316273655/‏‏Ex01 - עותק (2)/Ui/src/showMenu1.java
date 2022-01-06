import java.util.ArrayList;

public class showMenu1 implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
instructions=new ArrayList<String>();
instructions.add(" tap 1 To load xml file");
instructions.add(" tap 2 Show stores in system");
instructions.add("tap 3 Show items in system");
instructions.add("tap 4 Execution order in system and buy in system");
instructions.add("tap 5 Execution dinamy order in system");
        instructions.add("tap 6 show all orders in system");
        instructions.add("tap 7 if you want to update item in store");
        instructions.add("tap 8 if you want to load orders to file");
        instructions.add("tap 9 if you want to load orders from file that you give");
        instructions.add("tap q to exit from system");
        return instructions;
    }
    public void printMenu()
    {
        instructions=create();
        for(int i=0;i<instructions.size();i++)
        {
            System.out.println(instructions.get(i));
        }

    }

}
