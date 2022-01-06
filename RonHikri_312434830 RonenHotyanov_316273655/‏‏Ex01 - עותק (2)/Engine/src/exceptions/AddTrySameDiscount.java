package exceptions;

public class AddTrySameDiscount extends Exception {

    public String  create()
    {
        String str="please select other name to discount, this name found in system";
        return str;
    }
}
