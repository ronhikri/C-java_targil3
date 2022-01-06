import java.util.ArrayList;

public class selectpriveaccordingamount implements InterfaceshowMr {

    private ArrayList<String>instruction;

    public ArrayList<String>create()
    {
        instruction=new ArrayList<String>();
        instruction.add("tap positive integer to ask count");
        return instruction;
    }
    public void printMenu()
    {
        instruction=create();
        System.out.println(instruction.get(0));
    }
}
