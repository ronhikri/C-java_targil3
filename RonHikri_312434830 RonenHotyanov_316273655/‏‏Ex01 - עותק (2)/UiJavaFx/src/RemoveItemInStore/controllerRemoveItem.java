package RemoveItemInStore;

import clasinEx.classManeger;
import clasinEx.store;
import exceptions.IdOfItemNotFound;
import exceptions.IdOfStoreNotFound;
import exceptions.impossiletoremoveitem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class controllerRemoveItem {

    private classManeger obj;

    public controllerRemoveItem()
    {

    }
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }


    @FXML
    private ComboBox<String> Store;

    @FXML
    private ComboBox<String > Item;

    @FXML
    private TextField excep;
    @FXML
    private Button removeItem;

    @FXML
    void ClickRemoveItem(ActionEvent event) {
        excep.setText("");
        String strStore = Store.getValue();
        if (strStore != null&&Item.getValue()!=null) {
            try {

                int idofstore = buildStr(strStore, 0);
                String strItem = Item.getValue();
                int idofitem = buildStr(strItem, 0);
                obj.RemoveItem(idofstore, idofitem);
            } catch (IdOfStoreNotFound e) {
                excep.setText(e.create());
            } catch (IdOfItemNotFound e) {
                excep.setText(e.create());
            } catch (impossiletoremoveitem e) {
                excep.setText(e.create());
            }


        }
        else
        {
            excep.setText("select store and item");
        }

    }

    public void fillStore()
    {
        for(store s:obj.getStores().getStoress())
        {
            String str=s.getId()+","+s.getName();
            Store.getItems().add(str);
        }
    }

    @FXML
    void ClickItem(ActionEvent event) {

    }

    @FXML
    void ClickStore(ActionEvent event) {
        Item.getItems().clear();
        String str=Store.getValue();
        int idofstore=buildStr(str,0);
        ArrayList<String>itemins=obj.createItems(idofstore);
        for(String s:itemins)
            Item.getItems().add(s);



    }
    public int buildStr(String str,int index)
    {
        String idsome="";
        while(str.charAt(index)!=',')
        {
            idsome=idsome+str.charAt(index);
            index++;
        }
        int id=Integer.parseInt(idsome);
        return id;
    }

}