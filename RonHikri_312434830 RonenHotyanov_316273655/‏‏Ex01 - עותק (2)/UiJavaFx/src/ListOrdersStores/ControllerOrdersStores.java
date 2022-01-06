package ListOrdersStores;

import clasinEx.classManeger;
import clasinEx.orderinStore;
import clasinEx.store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerOrdersStores {

    private Stage primaryStage;
    private classManeger obj;
    private int selectedOrder;

    public  ControllerOrdersStores()
    {

    }
    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }
    public void setObj(classManeger value)
    {
        this.obj=value;
    }
    public void setSelectedOrder(int value)
    {
        this.selectedOrder=value;
    }

    @FXML
    private ComboBox<String> storss;

    @FXML
    private TableView<orderinStore> ListOrders;

    @FXML
    private TableColumn<orderinStore, Integer> id;

    @FXML
    private TableColumn<orderinStore, String> date;

    @FXML
    private TableColumn<orderinStore, Double> countitems;

    @FXML
    private TableColumn<orderinStore, Double> sumprice;

    @FXML
    private TableColumn<orderinStore, Double> costSend;

    @FXML
    private TableColumn<orderinStore, Double> costorder;

    @FXML
    void ClickSelectStore(ActionEvent event) {
        String s=storss.getValue();
        int index=s.indexOf(',');
        String idstore=s.substring(0,index);
        int ids=Integer.parseInt(idstore);
        ArrayList<orderinStore>list=null;
        if(selectedOrder==1)
        {
            list=obj.Staticcreateordersstore(ids);
        }
        else
            list=obj.createDinamyOrdersStore(ids);
        ObservableList<orderinStore>data= FXCollections.observableArrayList();
        for(orderinStore os:list)
            data.add(os);
       id.setCellValueFactory(new PropertyValueFactory<orderinStore,Integer>("id"));
       date.setCellValueFactory(new PropertyValueFactory<orderinStore,String>("date"));
       countitems.setCellValueFactory(new PropertyValueFactory<orderinStore,Double>("countItems"));
       sumprice.setCellValueFactory(new PropertyValueFactory<orderinStore,Double>("SumPriceItems"));
       costSend.setCellValueFactory(new PropertyValueFactory<orderinStore,Double>("priceSending"));
       costorder.setCellValueFactory(new PropertyValueFactory<orderinStore,Double>("costOrder"));
       ListOrders.setItems(data);

    }
    public void fillcombobox()
    {
        for(store st:obj.getStores().getStoress())
        {
            String s=(String.format("%d",st.getId()))+","+st.getName();
            storss.getItems().add(s);
        }
    }

}

