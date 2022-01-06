import java.util.ArrayList;

public class continueItemOrNotdinamy implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        ArrayList<String>ins=new ArrayList<String>();
        ins.add("Tap a if you want to continue select items to dinamy order");
        ins.add("tap q if you want to exit from dinamy order");
        return ins;
    }

    @Override
    public void printMenu() {
        instructions=create();
        for(int i=0;i<instructions.size();i++)
            System.out.println(instructions.get(i));
    }
}
