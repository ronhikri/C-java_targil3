import java.util.ArrayList;

public class cordinatosMenu implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public ArrayList<String> create()
    {
     instructions=new ArrayList<String>();
     instructions.add("please tap two numbers that indicate your location");
     return instructions;

    }
    public void printMenu()
    {
        instructions=create();
        System.out.println(instructions.get(0));
    }
}
