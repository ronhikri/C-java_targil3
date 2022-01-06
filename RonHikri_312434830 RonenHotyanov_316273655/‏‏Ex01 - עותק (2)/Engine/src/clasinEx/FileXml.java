package clasinEx;
import exceptions.*;
import generated.SuperDuperMarketDescriptor;

import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
public class FileXml {
    public String fileName;
    public InputStream file;



    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
    public void setFile(InputStream str)
    {
        this.file=str;
    }

    public classManeger fileToGame(){
        try {
           // File file = new File(fileName);
            SuperDuperMarketDescriptor obj2;
            JAXBContext jaxbContext = JAXBContext.newInstance(SuperDuperMarketDescriptor.class);
            Unmarshaller jaxbUnmarshaller = (jaxbContext).createUnmarshaller();
            obj2= (SuperDuperMarketDescriptor) jaxbUnmarshaller.unmarshal(file);
            classManeger obj=new classManeger();
            obj.create(obj2,obj);
            return obj;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean check(String fileName)
    {
        boolean found=false;
        File file=new File(fileName);
        if(!(file.exists()))
            found=false;
        else
        {
            if(!(fileName.contains("xml")))
                found=false;
            else
                found=true;

        }
        return found;

    }
    public ArrayList<Integer> buildstoresid(classManeger obj)
    {
        int i=0;
        ArrayList<Integer>liststores=new ArrayList<Integer>();
        for (store s:obj.getStores().getStoress())
        {
            liststores.add(s.getId());
        }
        return liststores;

    }
    public ArrayList<Integer>builditemsid(classManeger obj)
    {
        ArrayList<Integer>listitems=new ArrayList<Integer>();
        for(item Item:obj.getItems().getItems())
        {
            listitems.add(Item.getId());
        }
        return listitems;
    }
    public void sameid(ArrayList<Integer>listthings) throws idsameitemsorstoresexceptions
    {
        boolean found=true;
        int i=0;
        int j=0;
        for(i=0;i<listthings.size()-1;i++)
        {
            for(j=i+1;j<listthings.size();j++)
            {
                if(listthings.get(i)==listthings.get(j))
                {
                    found=false;
                    break;
                }

            }
            if(found==false)
                break;;
        }
        if(!(found))
        throw new idsameitemsorstoresexceptions();
    }
    public void checkIdSame(classManeger obj)throws idsameitemsorstoresexceptions
    {
        ArrayList<Integer>liststores=buildstoresid(obj);
        ArrayList<Integer>listitems=builditemsid(obj);
            sameid(liststores);
            sameid(listitems);


    }
    public ArrayList<ArrayList<Integer>> buildListitemstores(classManeger obj)
    {
        int i=0;
        ArrayList<ArrayList<Integer>>lists=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>listitemsstore=null;
        for(store s: obj.getStores().getStoress())
        {
            listitemsstore=new ArrayList<Integer>();
           for(i=0;i<s.getPrice().getSells().size();i++)
           {
               listitemsstore.add(s.getPrice().getSells().get(i).getId());
           }
           lists.add(listitemsstore);
        }
        return lists;
    }
    public void checkiditemnotexist(ArrayList<Integer>itemsinstore,ArrayList<Integer>Items)throws itemnotexitinrefexception
    {
        int i=0;
        int j=0;
        int count=0;
        for(i=0;i<itemsinstore.size();i++)
        {
            for(j=0;j<Items.size();j++)
            {
                if(itemsinstore.get(i)==Items.get(j))
                    count++;
            }
            if(count!=1)
                throw new itemnotexitinrefexception();
            count=0;
        }

    }
    public void checkExistallstores(classManeger obj)throws itemnotexitinrefexception
    {
        ArrayList<ArrayList<Integer>>listitemsallstores=buildListitemstores(obj);
        ArrayList<Integer>items=builditemsid(obj);
        for(ArrayList<Integer> listitems:listitemsallstores)
        {
            checkiditemnotexist(listitems,items);


        }

    }
    public void checkitemnotsell(int id,ArrayList<ArrayList<Integer>>itemsallstores)throws itemthatnotsellexception
    {
        int count=0;
        for(int i=0;i<itemsallstores.size();i++)
        {
            for(int j=0;j<itemsallstores.get(i).size();j++)
            {
                if(itemsallstores.get(i).get(j)==id)
                    count++;
            }
        }
        if(count==0)
            throw new itemthatnotsellexception();
    }
    public void checkitemsallnotsell(classManeger obj)throws itemthatnotsellexception
    {
        ArrayList<ArrayList<Integer>>listitemsaiistores=buildListitemstores(obj);
        ArrayList<Integer>items=builditemsid(obj);
        for(int itemid:items)
        {
            checkitemnotsell(itemid,listitemsaiistores);
        }

    }
    public void checkitemnotsellmoreonetime(int id,ArrayList<Integer>listitemsinstore) throws itemsellmoreoneinstoreexception
    {
        int count=0;
        for(int itemid:listitemsinstore)
        {
            if(id==itemid)
                count++;
        }
        if(count>1)
            throw new itemsellmoreoneinstoreexception();
    }
    public void checkallitemssellmoreonemoretimeinstore(ArrayList<Integer>listiteminstore) throws itemsellmoreoneinstoreexception
    {
        for(int itemid:listiteminstore)
        {
            checkitemnotsellmoreonetime(itemid,listiteminstore);
        }


    }
    public void checkitemsnotsellmoretimeinallstores(classManeger obj)throws itemsellmoreoneinstoreexception
    {
        ArrayList<ArrayList<Integer>>lisitemsallstores=buildListitemstores(obj);
        for(ArrayList<Integer>items:lisitemsallstores)
        {
            checkallitemssellmoreonemoretimeinstore(items);
        }

    }
    public ArrayList<location>buildListLocationstores(classManeger obj)
    {
        ArrayList<location>Listlocationofstores=new ArrayList<location>();
        int i=0;
        for(i=0;i<obj.getStores().getStoress().size();i++)
        {
            Listlocationofstores.add(obj.getStores().getStoress().get(i).getLocation());
        }
        return Listlocationofstores;
    }
    public void checklocationexcept(location space)throws locationofsoreexcept
    {
        if((space.getX()<1)||(space.getX()>50)||(space.getY()<1)|(space.getY()>50))
            throw new locationofsoreexcept();
    }
    public void checkallstoresnotlocation(classManeger obj)throws locationofsoreexcept
    {
        ArrayList<location>listlocationstores=buildListLocationstores(obj);
        for(location space:listlocationstores)
        {
            checklocationexcept(space);
        }
    }
    public void checkSameocationinStores(classManeger obj)throws sameLocationinStores
    {
        ArrayList<location>listLocationStores=buildListLocationstores(obj);
        for(int i=0;i<listLocationStores.size()-1;i++)
        {
            for(int j=i+1;j<listLocationStores.size();j++)
            {
                if((listLocationStores.get(i).getX()==listLocationStores.get(j).getX())&&(listLocationStores.get(i).getY()==listLocationStores.get(j).getY()))
                    throw new sameLocationinStores();
            }
        }
    }
    public void checkIfHasCustomersWithSameId(classManeger obj)throws checksamecustomers
    {
        for(int i=0;i<obj.getIcostomers().getSdmcustomers().size()-1;i++)
        {
            for(int j=i+1;j<obj.getIcostomers().getSdmcustomers().size();j++)
            {
                if(obj.getIcostomers().getSdmcustomers().get(i)==obj.getIcostomers().getSdmcustomers().get(j))
                    throw  new checksamecustomers();
            }
        }

    }
    public void checkIfHaCustomersWithSameLocation(classManeger obj)throws checkCustomersSmeLocation
    {
        for(int i=0;i<obj.getIcostomers().getSdmcustomers().size()-1;i++)
        {
            for(int j=i+1;j<obj.getIcostomers().getSdmcustomers().size();j++)
            {
                if(obj.getIcostomers().getSdmcustomers().get(i).getLocation().getX()==obj.getIcostomers().getSdmcustomers().get(j).getLocation().getX()&&obj.getIcostomers().getSdmcustomers().get(i).getLocation().getY()==obj.getIcostomers().getSdmcustomers().get(j).getLocation().getY())
                    throw  new checkCustomersSmeLocation();
            }
        }
    }
    public ArrayList<Integer>buildOffersInStore(store s)
    {
        ArrayList<Integer>offers=new ArrayList<>();
        for(discount d:s.getDiscs().getSdmDiscounts())
        {
            offers.add(d.getBuy().getId());
            for(offer offery:d.getGetoffer().getSdmoffer())
            {
                offers.add(offery.getId());
            }
        }
        return offers;
    }
    public ArrayList<Integer>buildpricesInStore(store s) {
        ArrayList<Integer> PricesItems = new ArrayList<>();
        for (sell sel : s.getPrice().getSells()) {
            PricesItems.add(sel.getId());
        }
        return PricesItems;
    }
    public void checkoffernotstore(ArrayList<Integer>offers,ArrayList<Integer>pricesitems)throws offerThatNotSoldInStore
    {
        int count=0;
        for(Integer o:offers)
        {
            for(Integer p:pricesitems)
            {
                if(o==p)
                    count++;
            }
            if(count!=1)
                throw  new offerThatNotSoldInStore();
            count=0;
        }
    }
    public void checkOfferThatNotSoldInStore(classManeger obj)throws offerThatNotSoldInStore
    {
        for(store s:obj.getStores().getStoress())
        {
            ArrayList<Integer>offers=buildOffersInStore(s);
            ArrayList<Integer>PricesItems=buildpricesInStore(s);
            checkoffernotstore(offers,PricesItems);

        }
    }
    public void chreckOfferNotFoundInFile(classManeger obj)throws offersthatnotFound
    {
        int count=0;
        ArrayList<Integer>itemsinfile=builditemsid(obj);
        for(store s:obj.getStores().getStoress())
        {
            count=0;
            ArrayList<Integer>offers=buildOffersInStore(s);
            for(Integer o:offers)
            {
                for(Integer i:itemsinfile)
                {
                    if(o==i)
                        count++;
                }
                if(count!=1)
                    throw new offersthatnotFound();
                count=0;
            }
        }
    }









}
