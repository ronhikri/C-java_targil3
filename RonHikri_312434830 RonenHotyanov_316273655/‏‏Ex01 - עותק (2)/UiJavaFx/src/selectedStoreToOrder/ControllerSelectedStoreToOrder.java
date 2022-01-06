package selectedStoreToOrder;
import EngOfUi.FactoryData;
import ShowItemsToOrder.ControllerItemsShowToOrder;
import clasinEx.classManeger;
import clasinEx.store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerSelectedStoreToOrder {
    private classManeger obj;
    private Stage primaryStage;
    private int idcustomer;
    private LocalDate date;
    private int idOfStore;
    private FactoryData F;

    public ControllerSelectedStoreToOrder() {

    }


    public void setObj(classManeger obji) {
        this.obj = obji;
    }

    public void setPrimaryStage(Stage primarystage) {
        this.primaryStage = primarystage;
    }

    public void setIdcustomer(int idOfCustomer) {
        this.idcustomer = idOfCustomer;
    }

    public void setDate(LocalDate value) {
        this.date = value;
    }

    public void setIdOfStore(int value) {
        this.idOfStore = value;
    }

    public void setF(FactoryData value) {
        this.F = value;
    }

    @FXML
    private ComboBox<String> StoreSelected;

    @FXML
    private TextField locationOfStore;

    @FXML
    private TextField ppkOfStore;

    @FXML
    private TextField priceSending;

    @FXML
    private Button continueOrder;

    public void Fillstores() {
        for (store s : obj.getStores().getStoress()) {
            StoreSelected.getItems().add(s.getId() + "," + s.getName());
        }
    }

    @FXML
    private void initialize()
    {
        continueOrder.setDisable(true);
    }

    @FXML
    void ClickselectedStore(ActionEvent event) {
        String str=StoreSelected.getValue();
        int index=str.indexOf(',');
        String idStore=str.substring(0,index);
        int idstore=Integer.parseInt(idStore);
        this.idOfStore=idstore;
        ArrayList<Double>data=obj.buildDataStore(idOfStore,this.idcustomer);
        ppkOfStore.setText(String.format("%.2f",data.get(0)));
        locationOfStore.setText("X:"+String.format("%.2f",data.get(1))+","+"Y:"+String.format("%.2f",data.get(2)));
        priceSending.setText(String.format("%.2f",data.get(3)));
        continueOrder.setDisable(false);


    }

    @FXML
    void clickContinue(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL Showitemsinorder = getClass().getResource("/ShowItemsToOrder/itemstoorder-fxml.fxml");
            loader.setLocation(Showitemsinorder);
            AnchorPane root=loader.load();
            ControllerItemsShowToOrder itshowOrder=loader.getController();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            obj.initiall();
            itshowOrder.setObj(obj);
            itshowOrder.setDate(date);
            itshowOrder.setIdCustomer(this.idcustomer);
            itshowOrder.setIdOfStore(idOfStore);
            itshowOrder.setPrimaryStage(primaryStage);
            itshowOrder.setF(F);
            itshowOrder.fillsItemsInStores();
            itshowOrder.itemsTable();
            board.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}