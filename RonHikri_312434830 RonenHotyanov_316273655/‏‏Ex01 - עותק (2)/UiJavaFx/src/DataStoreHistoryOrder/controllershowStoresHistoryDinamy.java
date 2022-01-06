package DataStoreHistoryOrder;

import ShowItemsHistoryOrders.ControllerDataHisOrd;
import clasinEx.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class controllershowStoresHistoryDinamy {
    private classManeger obj;
    private Stage primaryStage;

public  controllershowStoresHistoryDinamy()
{

}
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }

    @FXML
    private void initialize()
    {
        selectContinue.setDisable(true);

    }

    @FXML
    private ComboBox<String> DinamyOrders;

    @FXML
    private TableView<ShowStorsDinamyOrder> TableDataStore;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Integer> Id;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, String> name;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Integer> PPK;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Double> Distance;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Double> costSending;

    @FXML
    private Button selectContinue;

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
            controlitemshis.setSelectedOrder(2);
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
    void clickDinamyOrders(ActionEvent event) {
        selectContinue.setDisable(false);
        String s=DinamyOrders.getValue();
        int idOrder=Integer.parseInt(s);
        obj.initiall2();
        orderDinamy ord=null;
        for(orderDinamy o:obj.getListDinamyOrder())
        {
            if(o.getIdCountOrder()==idOrder)
            {
                ord=o;
                break;
            }
        }
        for(itemToOrderDinamy it:ord.getItemsdinamy())
        {
            obj.additemdinamyorder(it);
        }
        ArrayList<ShowStorsDinamyOrder>list=obj.createStoresDinamy(ord.getIdCustomer());
        ObservableList<ShowStorsDinamyOrder>data= FXCollections.observableArrayList();
        for(ShowStorsDinamyOrder show:list)
            data.add(show);
        Id.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,String>("namr"));
        PPK.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Integer>("ppk"));
        Distance.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Double>("distance"));
        costSending.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Double>("costSending"));
        TableDataStore.setItems(data);


    }
    public void fillcombobox()
    {
        for(orderDinamy ord:obj.getListDinamyOrder())
        {
            DinamyOrders.getItems().add(String.format("%d",ord.getIdCountOrder()));
        }
    }

}
