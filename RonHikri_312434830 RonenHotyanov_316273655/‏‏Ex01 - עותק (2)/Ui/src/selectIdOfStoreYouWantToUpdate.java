import java.util.ArrayList;

public class selectIdOfStoreYouWantToUpdate implements InterfaceshowMr {
    private ArrayList<String>instruction;

    public ArrayList<String>create()
    {
        ArrayList<String>ins=new ArrayList<>();
        ins.add("Tap fix id of store that you want to update");
        return ins;
    }
    public void printMenu()
    {
        instruction=create();
        System.out.println(instruction.get(0));
    }
}
