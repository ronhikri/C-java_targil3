package ShowItemsHistoryOrders;

import clasinEx.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.DoubleBinaryOperator;

public class ControllerDataHisOrd {

    private Stage primaryStage;
    private classManeger obj;
    private Integer selectedOrder;


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
    private ComboBox<String> orders;

    @FXML
    private TextField sumcostordertext;

    @FXML
    private TextField sumsendtext;

    @FXML
    private TextField sumcosttext;

    @FXML
    private TableView<showItemsConclusionOrder> TableItems;

    @FXML
    private TableColumn<showItemsConclusionOrder, Integer> id;

    @FXML
    private TableColumn<showItemsConclusionOrder,String> name;

    @FXML
    private TableColumn<showItemsConclusionOrder, String> howBuy;

    @FXML
    private TableColumn<showItemsConclusionOrder, Double> countitemssoldinorder;

    @FXML
    private TableColumn<showItemsConclusionOrder, Double> priceunit;

    @FXML
    private TableColumn<showItemsConclusionOrder, Double> sumpriceitem;

    @FXML
    private TableColumn<showItemsConclusionOrder, String> itemsoldDiscount;

    @FXML
    void ClickOrders(ActionEvent event) {
        double sumsending=0;
        String str=orders.getValue();
        ArrayList<showItemsConclusionOrder>list=null;
        int idOrder=0;
        if(this.selectedOrder==1)
        {
            obj.initiall();
            Order o=null;
            idOrder=Integer.parseInt(str);
            for(Order ord:obj.getListorder())
            {
                if(ord.getIdCountOrder()==idOrder)
                {
                    o=ord;
                    break;
                }
            }
            for(itemToOrder it:o.getItemtoorder())
            {
                obj.additemorder(it);
            }
            sumsending=obj.SumSending(o.getIdcust(),o.getIdOfStore());
           list=obj.creatListNode(1);



        }
        else
        {
            obj.initiall2();
            orderDinamy ord=null;
            idOrder=Integer.parseInt(str);
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
            sumsending=obj.SumSendingDinamy(ord.getIdCustomer());
            list=obj.creatListNode(2);
        }
        double sumcostOrders=obj.sumCostOrder(this.selectedOrder);
        double sumCost=sumcostOrders+sumsending;
        sumcostordertext.setText(String.format("%.2f",sumcostOrders));
        sumsendtext.setText(String.format("%.2f",sumsending));
        sumcosttext.setText(String.format("%.2f",sumCost));
        ObservableList<showItemsConclusionOrder>data= FXCollections.observableArrayList();
        for(showItemsConclusionOrder show:list)
            data.add(show);
        id.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,String>("name"));
        howBuy.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,String>("howToBuy"));
        countitemssoldinorder.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Double>("oount"));
        priceunit.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Double>("priceunit"));
        sumpriceitem.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Double>("SumPrice"));
        itemsoldDiscount.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,String>("DoItemSoldDiscount"));
        TableItems.setItems(data);


    }
    public void fillcombobox()
    {
        if(selectedOrder==1)
        {
            for(Order ord:obj.getListorder())
            {
                orders.getItems().add(String.format("%d",ord.getIdCountOrder()));
            }
        }
        else
        {
            for(orderDinamy ord:obj.getListDinamyOrder())
            {
                orders.getItems().add(String.format("%d",ord.getIdCountOrder()));
            }
        }

    }

}