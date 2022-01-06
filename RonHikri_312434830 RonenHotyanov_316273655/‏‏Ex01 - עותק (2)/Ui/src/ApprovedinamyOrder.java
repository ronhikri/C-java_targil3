import java.util.ArrayList;

public class ApprovedinamyOrder implements InterfaceshowMr {
    private ArrayList<String>instructions;

    public ArrayList<String>create()
    {
        ArrayList<String>ins=new ArrayList<String>();
        ins.add("do you want to approve dinampy order, tap y please");
        ins.add("do you not want to approve dinamy order please tap n");
        return ins;
    }
    public void printMenu()
    {
        instructions=create();
        for(int i=0;i<instructions.size();i++)
            System.out.println(instructions.get(i));
    }
}
