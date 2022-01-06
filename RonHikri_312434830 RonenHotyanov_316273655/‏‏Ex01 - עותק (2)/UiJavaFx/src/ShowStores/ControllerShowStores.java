package ShowStores;
import ListDiscountInShows.ControllerShowDiscountStore;
import ListOrdersStores.ControllerOrdersStores;
import ShowDataInStores.ControllerDataInStores;
import ShowItemsInStores.ControllerShowItemsStore;
import clasinEx.classManeger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import ShowStores.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ControllerShowStores {
    private classManeger obj;
    private Stage primarystage;

    public ControllerShowStores()
    {

    }
    public  ControllerShowStores(classManeger obji)
    {
        this.obj=obji;

    }
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public void setPrimarystage(Stage value)
    {
        this.primarystage=value;
    }

    @FXML
    private Button itesmsStore;

    @FXML
    private Button DiscountsStore;

    @FXML
    private Button StaticOrdersInStore;

    @FXML
    private Button DinamyOrdersInStore;
    @FXML
    private Button showData;

    @FXML
    void ClickDinamyOrdersInStore(ActionEvent event) {
        try
        {
            FXMLLoader loader=new FXMLLoader();
            URL orderaInStores=getClass().getResource("/ListOrdersStores/ordersInStores-fxml.fxml");
            loader.setLocation(orderaInStores);
            AnchorPane root=loader.load();
            ControllerOrdersStores ordersinstores=loader.getController();
            ordersinstores.setObj(obj);
            ordersinstores.setPrimaryStage(primarystage);
            ordersinstores.setSelectedOrder(2);
            ordersinstores.fillcombobox();
            BorderPane boared=(BorderPane)primarystage.getScene().getRoot();
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            boared.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void ClickDiscountsInStore(ActionEvent event) {
        try
        {
            FXMLLoader loader=new FXMLLoader();
            URL DiscountsStore=getClass().getResource("/ListDiscountInShows/DiscountsInStores-fxml.fxml");
            loader.setLocation(DiscountsStore);
            BorderPane boardpane=loader.load();
            ControllerShowDiscountStore controolerDiscounts=loader.getController();
            controolerDiscounts.setObj(obj);
            controolerDiscounts.fillComboxStore();
            BorderPane borderPane=(BorderPane)primarystage.getScene().getRoot();
            borderPane.centerProperty().setValue(boardpane);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void ClickItemsStore(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL itemsStore = getClass().getResource("/ShowItemsInStores/ShowItemsS-fxml.fxml");
            loader.setLocation(itemsStore);
            BorderPane board=loader.load();
            ControllerShowItemsStore controllitemsStore=loader.getController();
            controllitemsStore.setObj(obj);
            controllitemsStore.fillCombiox();
            BorderPane border=(BorderPane)primarystage.getScene().getRoot();
            border.centerProperty().setValue(board);


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void ClickStaticOrdersInStore(ActionEvent event) {
        try
        {
            FXMLLoader loader=new FXMLLoader();
            URL orderaInStores=getClass().getResource("/ListOrdersStores/ordersInStores-fxml.fxml");
            loader.setLocation(orderaInStores);
            AnchorPane root=loader.load();
            ControllerOrdersStores ordersinstores=loader.getController();
            ordersinstores.setObj(obj);
            ordersinstores.setPrimaryStage(primarystage);
            ordersinstores.setSelectedOrder(1);
            ordersinstores.fillcombobox();
            BorderPane boared=(BorderPane)primarystage.getScene().getRoot();
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            boared.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void clickDataStores(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL showdatainstores = getClass().getResource("/ShowDataInStores/showDataStores-fxml.fxml");
            loader.setLocation(showdatainstores);
            AnchorPane root=loader.load();
            ControllerDataInStores collectstores=loader.getController();
            collectstores.setObj(obj);
            collectstores.setPrimaryStage(primarystage);
            collectstores.fillTable();
            BorderPane board=(BorderPane)primarystage.getScene().getRoot();
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            board.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
