package clasinEx.TimeAndDate;

public class TransClock
{
    private int hours;
    private int minutes;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;

    public TransClock (int hours, int minutes)
    {
        this.hours = hours;
        this.minutes = minutes;

    }

    public TransClock(TransClock otherTime)
    {
        this.minutes = otherTime.getMinutes();
        this.hours = otherTime.getHours();
    }

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }


    @Override
    public String toString() {
        if ((hours < 10) && (minutes < 10))
            return "0" + hours + ":0" + minutes;
        else if ((hours >= 10) && (minutes < 10))
            return hours + ":0" + minutes;
        else if ((hours < 10) && (minutes >= 10))
            return "0" + hours + ":" + minutes;
        else
            return hours + ":" + minutes;
    }

    public boolean isAfter(TransClock secondParameterTime)
    {
        if(this.hours > secondParameterTime.hours)
        return true;
        if(this.hours == secondParameterTime.hours)
        {
            if(this.minutes >= secondParameterTime.minutes)
                return true;
        }
        return false;
    }

    public boolean isSameTime(TransClock secondParameterTime)
    {
    if(this.hours == secondParameterTime.getHours() && this.minutes == secondParameterTime.getMinutes())
        return true;
    return false;
    }

    public boolean isEqual(TransClock secondParameterTime)
    {
        if(this.hours == secondParameterTime.hours)
        {
            if(this.minutes == secondParameterTime.minutes)
                return true;
        }
        return false;
    }

    public boolean decreaseTime(int hoursToDecrease,int minutesToDecrease)// the function sub the time that asked and returns true if after the sub is the same day and false if its the day before
    {
        int resHours,resMinutes;

        resMinutes = (this.minutes - minutesToDecrease);
        if(this.minutes - minutesToDecrease < 0)
        {
            resMinutes += MINUTES_IN_HOUR;
            resHours = (this.hours - hoursToDecrease - 1);
            if(resHours < 0)
                resHours += HOURS_IN_DAY;
        }
        else // in case the minutes to sub are not bigger than the current minutes
        {
            resHours = (this.hours - hoursToDecrease);
            if(resHours < 0)
                resHours += HOURS_IN_DAY;
        }

        if((this.hours - hoursToDecrease) < 0 || this.hours - hoursToDecrease == 0 && this.minutes - minutesToDecrease < 0)
        {
            this.hours = resHours;
            this.minutes = resMinutes;
            return false;
        }
        else {
            this.hours = resHours;
            this.minutes = resMinutes;
            return true;
        }
    }

    public boolean increaseTime(int hoursToIncrease,int minutesToIncrease) // the function adds the time that asked and returns true if after the adding is the same day and false if its the day after
    {
        int resHours,resMinutes;

        resMinutes = (this.minutes + minutesToIncrease) % MINUTES_IN_HOUR;
        if(this.minutes + minutesToIncrease >= MINUTES_IN_HOUR)
        {
            resHours = (this.hours + hoursToIncrease +1) % HOURS_IN_DAY;
        }
        else
        {
            resHours = (this.hours + hoursToIncrease) % HOURS_IN_DAY ;
        }


        if((this.hours + hoursToIncrease) >= HOURS_IN_DAY || this.hours+hoursToIncrease == 23 && this.minutes + minutesToIncrease >= MINUTES_IN_HOUR)
        {
            this.hours = resHours;
            this.minutes = resMinutes;
            return false;
        }
        else {
            this.hours = resHours;
            this.minutes = resMinutes;
            return true;
        }
    }
}
