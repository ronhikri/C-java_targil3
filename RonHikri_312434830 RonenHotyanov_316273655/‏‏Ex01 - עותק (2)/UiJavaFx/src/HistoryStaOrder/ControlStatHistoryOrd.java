package HistoryStaOrder;

import ShowItemsHistoryOrders.ControllerDataHisOrd;
import clasinEx.Order;
import clasinEx.classManeger;
import clasinEx.itemToOrder;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class ControlStatHistoryOrd {
    private classManeger obj;
    private Stage primaryStage;


    @FXML
    private ComboBox<String> StaicOrders;

    @FXML
    private ListView<String> ListDataOrdr;

    @FXML
    private Button continueHistory;
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }


    public ControlStatHistoryOrd()
    {


    }

    @FXML
    private void initialize()
    {
        continueHistory.setDisable(true);
    }


    @FXML
    void ClickContinue(ActionEvent event) {
        try
        {
            FXMLLoader loader=new FXMLLoader();
            URL itemsHistory=getClass().getResource("/ShowItemsHistoryOrders/showDataOrdeHis-fxml.fxml");
            loader.setLocation(itemsHistory);
            AnchorPane root=loader.load();
            ControllerDataHisOrd controlitemshis=loader.getController();
            controlitemshis.setObj(obj);
            controlitemshis.setPrimaryStage(primaryStage);
            controlitemshis.setSelectedOrder(1);
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            controlitemshis.fillcombobox();
            board.centerProperty().setValue(root);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void ClickStaicOrders(ActionEvent event) {
        continueHistory.setDisable(false);
        ListDataOrdr.getItems().clear();
        Order o=null;
        String id=StaicOrders.getValue();
        int idOrder=Integer.parseInt(id);
        obj.initiall();
        for(Order ord: obj.getListorder())
        {
            if(ord.getIdCountOrder()==idOrder) {
                o = ord;
                break;
            }
        }
        for(itemToOrder it:o.getItemtoorder())
        {
            obj.additemorder(it);
        }
        ArrayList<String> data=obj.createdataStore(o.getIdOfStore(),o.getIdcust());
        for(String s:data)
            ListDataOrdr.getItems().add(s);
        obj.initiall();


    }
    public void fillCombobox()
    {
        {
            for(Order ord:obj.getListorder())
            {
                StaicOrders.getItems().add(String.format("%d",ord.getIdCountOrder()));
            }
        }


    }


}