package Utils;

import clasinEx.roleAndNaneUser;

import java.util.ArrayList;

public class DataUsers {

   ArrayList<roleAndNaneUser>usrs;

   public DataUsers()
   {
       usrs=new ArrayList<>();
   }
   public ArrayList<roleAndNaneUser>getUsrs()
    {
        if(usrs==null)
            usrs=new ArrayList<>();
        return usrs;
    }
    public void AddUsrs(roleAndNaneUser r)
    {
        if(usrs==null)
            usrs=new ArrayList<>();
        usrs.add(r);
    }

}
