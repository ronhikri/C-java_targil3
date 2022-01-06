package ListDiscountInShows;

import clasinEx.classManeger;
import clasinEx.store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class ControllerShowDiscountStore {
    private classManeger obj;

    public ControllerShowDiscountStore()
    {

    }
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    @FXML
    private ComboBox<String > ListStores;

    @FXML
    private ListView<String> ListOffers;

    @FXML
    private ComboBox<String > WhatShouldBuyDiscount;

    public void fillComboxStore()
    {
        for(store s:obj.getStores().getStoress())
        {
            String str=String.format("%d",s.getId())+","+s.getName();
            ListStores.getItems().add(str);
        }
    }

    @FXML
    void ClickSelectStore(ActionEvent event) {
        WhatShouldBuyDiscount.getItems().clear();
        String s=ListStores.getValue();
        int id=s.charAt(0)-48;
        ArrayList<String>discounts=obj.createDiscountsInStore(id);
        for(String str:discounts)
        {
            WhatShouldBuyDiscount.getItems().add(str);
        }



    }

    @FXML
    void ClickShouldBuyDiscount(ActionEvent event) {
        ListOffers.getItems().clear();
        int i=0;
        String str=WhatShouldBuyDiscount.getValue();
        if(str!=null)
        {
            int index=str.indexOf(',');
            String name=create(str,0);
            String data=create(str,index+1);
            int id=createdata(data);
            ArrayList<String>offers=obj.createListOfOffers(name);
            for(String off:offers)
            {
                ListOffers.getItems().add(off);
            }
        }

    }
    public String create(String str,int index)
    {
        String cre="";
        while(str.charAt(index)!=',')
        {
            cre=cre+str.charAt(index);
            index++;
        }
        return cre;
    }
    public int createdata(String str)
    {
        int data=Integer.parseInt(str);
        return data;
    }

}
