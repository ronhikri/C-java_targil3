import java.util.ArrayList;

public class ApprovalOrderForSending implements InterfaceshowMr {

    private ArrayList<String>instructions;

    public  ArrayList<String>create()
    {
        instructions=new ArrayList<String>();
        String atr="Do Yo sure to send the order tap y yes or n not";
        instructions.add(atr);
        return instructions;
    }
    public void printMenu()
    {
        instructions=create();
        System.out.println(instructions.get(0));
    }
}
