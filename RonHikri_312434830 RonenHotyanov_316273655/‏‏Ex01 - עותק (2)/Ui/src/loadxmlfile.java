import java.util.ArrayList;

public class loadxmlfile implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        instructions=new ArrayList<String>();
        instructions.add("please give path to xml file");
        return instructions;
    }
    public void printMenu()
    {
        instructions=create();
        System.out.println(instructions.get(0));
    }
}
