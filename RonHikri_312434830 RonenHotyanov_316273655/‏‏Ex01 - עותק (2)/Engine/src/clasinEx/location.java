package clasinEx;

import generated.Location;

public class location {

    protected int x;
  protected  int y;

    public  void newInstance(Location location2, location l) {
l.setX(location2.getX());
l.setY(location2.getY());
    }
    public location()
    {

    }



    public int getX()
    {
        return this.x;
    }
    public void setX(int value)
    {
        this.x=value;
    }
    public int getY()
    {
        return this.y;
    }
    public void setY(int value)
    {
        this.y=value;
    }

}