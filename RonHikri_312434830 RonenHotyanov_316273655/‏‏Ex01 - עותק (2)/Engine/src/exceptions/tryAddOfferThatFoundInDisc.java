package exceptions;

public class tryAddOfferThatFoundInDisc extends Exception  {

    public String create()
    {
        String str="The Offer found in Discount, impossible to add";
        return str;
    }
}
