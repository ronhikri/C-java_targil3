package UpdateItemInStore;

import RemoveItemInStore.controllerRemoveItem;
import UpdateOrAddItem.controllUpdateOrAddItem;
import clasinEx.classManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ControllerUpdateItem {
    private classManeger obj;
    private Stage primaryStage;

    @FXML
    private Button AddItemStore;

    @FXML
    private Button RemoveItemStore;

    @FXML
    private Button updatePriceItemInStore;
    public ControllerUpdateItem()
    {

    }
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public  void setPrimaryStage(Stage primarystage)
    {
        this.primaryStage=primarystage;
    }

    @FXML
    void ClickAddItemToStore(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader();
            URL AddItemInStore=getClass().getResource("/UpdateOrAddItem/AddOrUpdatePriceItem-fxml.fxml");
            loader.setLocation(AddItemInStore);
            BorderPane root=loader.load();
            controllUpdateOrAddItem controladdorupdate=loader.getController();
            controladdorupdate.setObj(obj);
            controladdorupdate.setSelected(1);
            controladdorupdate.fillStores();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            board.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void ClickRemoveItemStore(ActionEvent event) {
        try
        {
            FXMLLoader loader=new FXMLLoader();
            URL Removeitems=getClass().getResource("/RemoveItemInStore/RemoveItem-fxml.fxml");
            loader.setLocation(Removeitems);
            BorderPane root=loader.load();
            controllerRemoveItem controllerupdateremove=loader.getController();
            controllerupdateremove.setObj(obj);
            controllerupdateremove.fillStore();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            board.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void ClickUpdateIteminstore(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader();
            URL     UpdatePriceItemInStore=getClass().getResource("/UpdateOrAddItem/AddOrUpdatePriceItem-fxml.fxml");
            loader.setLocation(UpdatePriceItemInStore);
            BorderPane root=loader.load();
            controllUpdateOrAddItem controladdorupdate=loader.getController();
            controladdorupdate.setObj(obj);
            controladdorupdate.setSelected(2);
            controladdorupdate.fillStores();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            board.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
