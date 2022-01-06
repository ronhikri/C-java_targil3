package Utils;

import clasinEx.UsersWeb.UserWeb;
import clasinEx.classManeger;
import clasinEx.roleAndNaneUser;

import java.util.ArrayList;

public class userManegerToServet {
    private int currentId;
    private ArrayList<classManeger> objs;
    private ArrayList<roleAndNaneUser> names;
    private classManeger currentobj;
    private int idOrder;
    private ArrayList<UserWeb>usses;

    public void AddUser(UserWeb use)
    {
        if(usses==null)
            usses=new ArrayList<>();
        usses.add(use);
    }
    public UserWeb searchUser(String name) {
        UserWeb us=null;
        for(UserWeb use:usses)
        {
            if(use.getUserName().equals(name))
            {
                us=use;
                break;
            }
        }
        return us;
    }
    public ArrayList<UserWeb> getUses()
    {
        if(usses==null)
            usses=new ArrayList<>();
        return usses;
    }

    public userManegerToServet() {
        currentId = 0;
        this.objs = new ArrayList<>();
        this.names = new ArrayList<>();
        idOrder=0;
    }

    public synchronized ArrayList<classManeger> getObjs() {
        if (objs == null)
            objs = new ArrayList<>();
        return objs;
    }

    public synchronized int getCurrentId() {
        return this.currentId;
    }

    public synchronized void setCurrentId(int value) {
        this.currentId = value;
    }

    public synchronized void AddObj(classManeger obj) {
        if (objs == null)
            objs = new ArrayList<>();
        objs.add(obj);
    }

    public synchronized void AddName(roleAndNaneUser name) {
        if (names == null)
            names = new ArrayList<>();
        names.add(name);
    }

    public synchronized ArrayList<roleAndNaneUser> getNames() {
        if (names == null)
            names = new ArrayList<>();
        return names;
    }

    public synchronized classManeger getCurrentobj() {
        return this.currentobj;
    }

    public synchronized void setCurrentobj(classManeger value) {
        this.currentobj = value;
    }

    public synchronized boolean checkeistinsystem(String user) {
        boolean found=false;
        for (roleAndNaneUser u : this.getNames()) {
            if (u.getNamei().equals(user))
                found=true;
            else
                found= false;
        }
        return found;

    }
    public classManeger searchList(String name)
    {
        classManeger retobj=null;
        for(classManeger obj:this.getObjs())
        {
            if(obj.getZoni().getNameZone().equals(name))
            {
                retobj=obj;
                break;
            }
        }
        return retobj;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public synchronized void Removi(String name)
    {
        classManeger temp=null;
        for(classManeger obj:this.getObjs())
        {

            if(obj.getZoni().getNameZone().equals(name))
            {
                temp=obj;
                break;
            }
        }
        objs.remove(temp);

    }
    public synchronized void removeUser(String name)
    {
        UserWeb temp=null;
        for(UserWeb use:usses)
        {
            if(use.getUserName().equals(name))
            {
                temp=use;
                break;
            }
        }
        usses.remove(temp);
    }
}

