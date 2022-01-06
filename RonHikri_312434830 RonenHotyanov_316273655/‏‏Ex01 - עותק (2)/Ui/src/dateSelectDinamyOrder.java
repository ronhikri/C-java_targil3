import java.util.ArrayList;

public class dateSelectDinamyOrder implements InterfaceshowMr
{
    private ArrayList<String> instructions;
public ArrayList<String>create()
{
    ArrayList<String>ins=new ArrayList<String>();
    ins.add("please tap fix date to order a dinamy order");
    return ins;
}
public void printMenu()
{
    instructions=create();
    System.out.println(instructions.get(0));
}
}
