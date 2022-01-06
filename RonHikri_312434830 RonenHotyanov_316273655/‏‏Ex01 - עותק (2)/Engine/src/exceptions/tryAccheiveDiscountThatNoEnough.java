package exceptions;

public class tryAccheiveDiscountThatNoEnough extends Exception {

    public String create()
    {
        String str="Cant receive The Discount because no enough Quantity";
        return str;
    }
}
