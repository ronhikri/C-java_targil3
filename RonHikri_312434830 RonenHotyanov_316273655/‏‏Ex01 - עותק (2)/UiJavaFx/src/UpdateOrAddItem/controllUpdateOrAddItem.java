package UpdateOrAddItem;

import clasinEx.classManeger;
import clasinEx.store;
import exceptions.IdOfItemNotFound;
import exceptions.IdOfStoreNotFound;
import exceptions.tryadditemthatsoldinstore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class controllUpdateOrAddItem {

    private classManeger obj;
    private int selected;

    @FXML
    private ComboBox<String> selectStore;

    @FXML
    private TextField TextPrice;

    @FXML
    private TextField excep;

    @FXML
    private Label selectedPriceItem;

    @FXML
    private ComboBox<String> SelectItem;

    public controllUpdateOrAddItem()
    {

    }
    public  void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public void setSelected(int value)
    {
        this.selected=value;
    }
    @FXML
    private Button SelectingPriceItem;

    public void fillStores()
    {
        for(store s:obj.getStores().getStoress())
        {
            String str=s.getId()+","+s.getName();
            selectStore.getItems().add(str);
        }
    }


    @FXML
    void ClickItem(ActionEvent event) {


    }

    @FXML
    void ClickStore(ActionEvent event) {
        ArrayList<String> itemins;
        SelectItem.getItems().clear();
        String str=selectStore.getValue();
        int idofstore=buildStr(str,0);
        if(selected==1) {
            itemins = obj.createItemNotFoundInStore(idofstore);
        }
        else
            itemins=obj.createItems(idofstore);
        for(String s:itemins)
            SelectItem.getItems().add(s);




    }
    @FXML
    void ClickSelectfinishPrice(ActionEvent event) {
        excep.setText("");
        if(selectStore.getValue()!=null&&SelectItem.getValue()!=null&&TextPrice.getText()!="")
        {
            if(selected==1) {
            try {
                    double price=0;
                    String strStore = selectStore.getValue();
                    String StrItem = SelectItem.getValue();
                    int idStore = buildStr(strStore, 0);
                    int idofitem = buildStr(StrItem, 0);
                    if(obj.howToBuy(idofitem).equals("Quantity"))
                    {
                        int pricer=Integer.parseInt(TextPrice.getText());
                        price=(double)pricer;
                    }
                    else
                     price = Double.parseDouble(TextPrice.getText());
                    obj.Additemtostore(idStore,idofitem,price);
                }
            catch (tryadditemthatsoldinstore e)
            {
                excep.setText(e.create());
            }
            catch (IdOfStoreNotFound e)
            {
                excep.setText(e.create());
            }
            catch (IdOfItemNotFound e)
            {
                excep.setText(e.create());
            }
            catch (InputMismatchException e)
            {
             excep.setText("please select double");
            }
            catch (IllegalFormatException e)
            {
                excep.setText("please select number");
            }
            catch (NumberFormatException e)
            {
                excep.setText("please select number");
            }

            }
            else
            {
                try {
                    String strStore = selectStore.getValue();
                    String StrItem = SelectItem.getValue();
                    int idStore = buildStr(strStore, 0);
                    int idofitem = buildStr(StrItem, 0);
                    double price=0;
                  price = Double.parseDouble(TextPrice.getText());
                    obj.updateprice(idStore,idofitem,price);
                }
                catch ( IdOfStoreNotFound e)
                {
                    excep.setText(e.create());
                }
                catch ( IdOfItemNotFound e)
                {
                    excep.setText(e.create());
                }
                catch (InputMismatchException e)
                {
                    excep.setText("please select double");
                }
                catch (NumberFormatException e)
                {
                    excep.setText("please select number");
                }
            }
        }

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
