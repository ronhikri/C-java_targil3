package ShowItemsOrder;

import EngOfUi.FactoryData;
import approveOrder.ControlApprove;
import clasinEx.classManeger;
import clasinEx.showItemsConclusionOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllShowItemsOrder {
    private classManeger obj;
    private Stage primaryStage;
    private int idcustomer;
    private LocalDate date;
    private int selectOrder;
    private int idstore;
    private FactoryData F;

    public ControllShowItemsOrder()
    {

    }
    public void setObj(classManeger value)
    {
        this.obj=value;
    }
    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }
    public void setIdcustomer(int value)
    {
        this.idcustomer=value;
    }
    public  void setDate(LocalDate value)
    {
        this.date=value;
    }
    public void setSelectOrder(int value)
    {
        this.selectOrder=value;
    }
    public void setIdstore(int value)
    {
        this.idstore=value;
    }
    public void setF(FactoryData value)
    {
        this.F=value;
    }



    @FXML
    private TableView<showItemsConclusionOrder> TableItemsOrder;

    @FXML
    private TableColumn<showItemsConclusionOrder,Integer> id;

    @FXML
    private TableColumn<showItemsConclusionOrder, String> name;

    @FXML
    private TableColumn<showItemsConclusionOrder, String> howToBuy;

    @FXML
    private TableColumn<showItemsConclusionOrder, Double> countItems;

    @FXML
    private TableColumn<showItemsConclusionOrder, Double> priceunit;

    @FXML
    private TableColumn<showItemsConclusionOrder, Double> SumPrice;

    @FXML
    private TableColumn<showItemsConclusionOrder,String> itemsolddiscount;

    @FXML
    private Button showdata;

    @FXML
    private Button Next;
    @FXML
    private TextField sumcostorder;

    @FXML
    private TextField sumsending;

    @FXML
    private TextField sumcost;


    @FXML
    void ClickContinue(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL approve = getClass().getResource("/approveOrder/aproveOrNotOrder-fxml.fxml");
            loader.setLocation(approve);
            AnchorPane root = loader.load();
            ControlApprove conApprove=loader.getController();
            conApprove.setDate(date);
            conApprove.setF(F);
            conApprove.setIdcustomer(this.idcustomer);
            if(this.selectOrder==1)
            conApprove.setIdstore(this.idstore);
            else
                conApprove.setIdstore(0);
            conApprove.setObj(obj);
            conApprove.setPrimaryStage(primaryStage);
            conApprove.setSelectOrder(this.selectOrder);
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
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

    @FXML
    void ClickShowData(ActionEvent event) {
        ObservableList<showItemsConclusionOrder>data= FXCollections.observableArrayList();
        ArrayList<showItemsConclusionOrder>list=obj.creatListNode(this.selectOrder);
        for(showItemsConclusionOrder show:list)
            data.add(show);
        id.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,String>("name"));
        howToBuy.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,String>("howToBuy"));
        countItems.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Double>("oount"));
        priceunit.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Double>("priceunit"));
        SumPrice.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,Double>("SumPrice"));
        itemsolddiscount.setCellValueFactory(new PropertyValueFactory<showItemsConclusionOrder,String>("DoItemSoldDiscount"));
        TableItemsOrder.setItems(data);
        double SumPriceItems=obj.sumCostOrder(this.selectOrder);
        double send=0;
        if(this.selectOrder==1)
        {
           send=obj.SumSending(this.idcustomer,this.idstore);
        }
        else
        {
            send=obj.SumSendingDinamy(this.idcustomer);
        }
        sumcostorder.setText(String.format("%.2f",SumPriceItems));
        sumsending.setText(String.format("%.2f",send));
        sumcost.setText(String.format("%.2f",SumPriceItems+send));


    }

}
