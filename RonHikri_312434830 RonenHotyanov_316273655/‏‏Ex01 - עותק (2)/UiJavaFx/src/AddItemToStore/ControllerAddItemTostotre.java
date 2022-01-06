package AddItemToStore;

import clasinEx.classManeger;
import clasinEx.storeToSystem;
import exceptions.tryadditemthatsoldinstore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControllerAddItemTostotre {

    private Stage primaryStage;
    private classManeger obj;
    private storeToSystem st;
    private int iditemtostore;
    private double pricetoitem;
    private int count;

    public void setPrimaryStag(Stage value) {
        this.primaryStage = value;
    }

    public void setObj(classManeger value) {
        this.obj = value;
    }

    public void setSt(storeToSystem value) {
        this.st = value;
    }

    @FXML
    private ComboBox<String> Items;

    @FXML
    private TextField PriceToItem;

    @FXML
    private TextArea ecep;
    @FXML
    private Button AddItems;
    @FXML
    private void initialize()
    {
        ecep.setText("Exceptions");
    }

    @FXML
    void ClickAddItems(ActionEvent event) {
        ecep.setText("");
        if (Items.getValue() != null) {
            try {
                String itemstring = Items.getValue();
                int index = itemstring.indexOf(",");
                String idItem = itemstring.substring(0, index);
                int iditem = Integer.parseInt(idItem);
                this.iditemtostore = iditem;
                String priceItem = PriceToItem.getText();
                double price = Double.parseDouble(priceItem);
                this.pricetoitem = price;
                String mama="jjjj";
                obj.AddItemsToNewStore(mama,this.st, this.iditemtostore, this.pricetoitem, count);
                this.count = count + 1;

            } catch (tryadditemthatsoldinstore e) {
                ecep.setText(e.create());
            } catch (NumberFormatException e) {
                ecep.setText("please select number");
            } catch (InputMismatchException e) {
                ecep.setText("pleass double number");
            }


        } else {
            ecep.setText("you must select item");
        }
    }


    @FXML
    void ClickSelectItem(ActionEvent event) {

    }
    public void fillCombobox()
    {
        this.count=0;
        ArrayList<String>list=obj.createStringItems();
        for(String s:list)
        {
            Items.getItems().add(s);
        }

    }

}
