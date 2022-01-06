import java.util.ArrayList;

public class selectidOfItemThatyouWantToUpdate implements InterfaceshowMr {

    private ArrayList<String>instruction;

    public ArrayList<String>create()
    {
        ArrayList<String>ins=new ArrayList<>();
        ins.add("Tap a if you want to add item in store");
        ins.add("tap b if you want to delete item in store");
        ins.add("tap c if you want to update price item in store");
        return ins;
    }
    public void printMenu()
    {
        instruction=create();
        for(int i=0;i<instruction.size();i++)
            System.out.println(instruction.get(i));
    }
}
