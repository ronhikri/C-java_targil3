package clasinEx.UsersWeb;

import clasinEx.TimeAndDate.TransClock;

public class FinancialAction
{
    private String dateFormat;
    private double amountBefore;
    private double amountAfter;
    private double amountAction;
    private String actionName;

    public FinancialAction(String date, double amountAction, double amountBefore, double amountAfter, String actionName)
    {
        this.dateFormat = date;
        this.amountBefore = amountBefore;
        this.amountAfter = amountAfter;
        this.actionName = actionName;
        this.amountAction = amountAction;
    }

}
