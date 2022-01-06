import java.util.ArrayList;

public class tappriceupdateItemInStore implements InterfaceshowMr {

    private ArrayList<String>instruction;

    public ArrayList<String>create()
    {
        ArrayList<String>ins=new ArrayList<>();
        ins.add("tap number price to update price item in store");
        return ins;
    }
    public void printMenu()
    {
        instruction=create();
        System.out.println(instruction.get(0));
    }
}
