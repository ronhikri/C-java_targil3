
import java.util.ArrayList;

public class idItemToDinamyOrder implements InterfaceshowMr {
    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        ArrayList<String>ins=new ArrayList<String>();
        ins.add("please select id of item for dinamy order");
        return ins;
    }
    public void printMenu()
    {
        instructions=create();
        System.out.println(instructions.get(0));
    }
}
