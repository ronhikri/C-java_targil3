package selectStaticOrDinamy;

import EngOfUi.FactoryData;
import ShowItemsAndStoresDinamy.ControllerShowAndStoresDinamy;
import ShowItemsToOrder.ControllerItemsShowToOrder;
import clasinEx.classManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import selectedStoreToOrder.ControllerSelectedStoreToOrder;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class ControllerStatieDinamyOrder {
    private Stage primaryStage;
    private classManeger obj;
    private int idOfCustomer;
    private LocalDate date;
    private FactoryData F;

    public ControllerStatieDinamyOrder()
    {

    }
    public void setPrimaryStage(Stage primarystage)
    {
        this.primaryStage=primarystage;
    }
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public void setIdOfCustomer(int value)
    {
        this.idOfCustomer=value;
    }
    public void setDate(LocalDate datei)
    {
        this.date=datei;
    }
    public void setF(FactoryData value)
    {
        this.F=value;
    }

    @FXML
    private Button selectstaticorder;

    @FXML
    private Button SelectDinamyOrder;

    @FXML
    void ClickSelectDinamyOrder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL Showitemsinorder = getClass().getResource("/ShowItemsAndStoresDinamy/showItemsAndStore-fxml.fxml");
            loader.setLocation(Showitemsinorder);
            AnchorPane root = loader.load();
         ControllerShowAndStoresDinamy itshowOrder = loader.getController();
            BorderPane board = (BorderPane) primaryStage.getScene().getRoot();
            itshowOrder.setObj(obj);
            itshowOrder.setDate(date);
            itshowOrder.setIdCustomer(this.idOfCustomer);
            itshowOrder.setPrimaryStage(primaryStage);
            itshowOrder.setF(F);
            obj.initiall2();
            itshowOrder.fillTableItemsDinamyAndCombobox();
            board.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void ClickSelectStaticOrder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL selectingStore = getClass().getResource("/selectedStoreToOrder/selectStore-fxml.fxml");
            loader.setLocation(selectingStore);
            FlowPane root = loader.load();
            ControllerSelectedStoreToOrder selectStore=loader.getController();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            selectStore.setObj(obj);
            selectStore.setPrimaryStage(primaryStage);
            selectStore.setDate(date);
            selectStore.setIdcustomer(this.idOfCustomer);
            selectStore.setF(F);
            obj.initiall();
            selectStore.Fillstores();
            board.centerProperty().setValue(root);


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
