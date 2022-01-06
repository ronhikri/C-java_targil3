import java.util.ArrayList;

public class selectitemorexitfromorder implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
            ArrayList<String>ins=new ArrayList<String>();
            ins.add("tap a if you want to add item to dinamy order");
            ins.add("tap q if you want to eit from a dinamy order and to add dinamy order");
            return ins;
    }
    public void printMenu()
    {
        instructions=create();
        for(int i=0;i<instructions.size();i++)
            System.out.println(instructions.get(i));
    }
}
