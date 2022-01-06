package ShowItemsToOrder;

import DiscountoffersOrder.ControllerDiscount;
import EngOfUi.FactoryData;
import clasinEx.classManeger;
import clasinEx.showItemsToOrder;
import exceptions.IdOfItemNotFound;
import exceptions.IdOfStoreNotFound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControllerItemsShowToOrder {
    private classManeger obj;
    private Stage primaryStage;
    private int idCustomer;
    private int idOfStore;
    private LocalDate date;
    private boolean selectedItem;
    private int iditem;
    private FactoryData F;


    public ControllerItemsShowToOrder()
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
    public void setIdCustomer(int value)
    {
        this.idCustomer=value;
    }
    public void setIdOfStore(int value)
    {
        this.idOfStore=value;
    }
    public void setDate(LocalDate datey)
    {
        this.date=datey;
    }
    public void setSelectedItem(boolean value)
    {
        this.selectedItem=value;
    }
    public void setIditem(int value)
    {
        this.iditem=value;
    }
    public void setF(FactoryData value)
    {
        this.F=value;
    }



    @FXML
    private ComboBox<String> ListItems;

    @FXML
    private TableView<showItemsToOrder> tableitems;

    @FXML
    private TableColumn<showItemsToOrder, Integer> idOfItem;

    @FXML
    private TableColumn<showItemsToOrder, String> nameOfItem;

    @FXML
    private TableColumn<showItemsToOrder, String> idofstore;

    @FXML
    private TableColumn<showItemsToOrder, String> howToBuyItem;

    @FXML
    private TableColumn<showItemsToOrder, String> priceUnitOfItem;

    @FXML
    private TableColumn<showItemsToOrder, String> nameStore;

    @FXML
    private TextField selectAmountOfItem;

    @FXML
    private TextField exceptions;

    @FXML
    private Button ContinueOrder;

    @FXML
    private Button AddItemToOrdr;
    @FXML
    private void initialize()
    {
        exceptions.setText("Exceptions");
        ContinueOrder.setDisable(true);
    }

    @FXML
    void ClickAddOrder(ActionEvent event) {
        exceptions.setText("");
        String str=selectAmountOfItem.getText();
        if(selectedItem==true)
        {
            try {
                double amount=0;
                if(obj.howToBuy(this.iditem).equals("Quantity"))
                {
                    int ami=Integer.parseInt(str);
                    amount=(double)ami;
                }
                else
                amount = Double.parseDouble(str);
                obj.addToListOrderItem(this.idOfStore,this.iditem,amount);
                ContinueOrder.setDisable(false);

            }
            catch (IdOfItemNotFound e)
            {
                exceptions.setText(e.create());
            }
            catch (IdOfStoreNotFound e)
            {
                exceptions.setText(e.create());
            }
            catch (InputMismatchException e)
            {
                exceptions.setText("please select double number");
            }
            catch (NumberFormatException e)
            {
                exceptions.setText("please select number");
            }

            catch (Exception e)
            {
                exceptions.setText("please select double number");
            }

        }
        else
        {
            exceptions.setText("pleasec select item");
        }

    }
    public void fillsItemsInStores() {
        ArrayList<String> itemss = obj.createItems(idOfStore);
        for (String st : itemss) {
            ListItems.getItems().add(st);
        }
    }
    public void itemsTable()
    {
        ObservableList<showItemsToOrder> data= FXCollections.observableArrayList();
        ArrayList<showItemsToOrder>itemsPrder=null;
        itemsPrder =obj.builditemsContinueOrder(this.idOfStore);
        for(showItemsToOrder it:itemsPrder)
        {
            data.add(it);
        }
        idOfItem.setCellValueFactory(new PropertyValueFactory<showItemsToOrder,Integer>("idofItem"));
        nameOfItem.setCellValueFactory(new PropertyValueFactory<showItemsToOrder,String>("nameitem"));
        idofstore.setCellValueFactory(new PropertyValueFactory<showItemsToOrder,String>("idofstoreofitem"));
        howToBuyItem.setCellValueFactory(new PropertyValueFactory<showItemsToOrder,String>("howtobuy"));
        priceUnitOfItem.setCellValueFactory(new PropertyValueFactory<showItemsToOrder,String >("priceUnitItem"));
        nameStore.setCellValueFactory(new PropertyValueFactory<showItemsToOrder,String>("nameStoreOfItem"));
        tableitems.setItems(data);
    }


    @FXML
    void ClickContinue(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL discountorderFXML = getClass().getResource("/DiscountoffersOrder/DiscountOffers-fxml.fxml");
            loader.setLocation(discountorderFXML);
            AnchorPane root = loader.load();
            BorderPane board = (BorderPane) primaryStage.getScene().getRoot();
            ControllerDiscount controllerdiscount = loader.getController();
            controllerdiscount.setPrimaryStage(primaryStage);
            controllerdiscount.setObj(obj);
            controllerdiscount.setDate(date);
            controllerdiscount.setIdOfStore(idOfStore);
            controllerdiscount.setIdCustomer(this.idCustomer);
            controllerdiscount.setF(F);
            controllerdiscount.setSelectOrder(1);
            controllerdiscount.fillComboxDiscounts();
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
    void ClickSelectItem(ActionEvent event) {
        this.selectedItem=true;
        String str=ListItems.getValue();
        int index=str.indexOf(',');
        String strItem=str.substring(0,index);
        this.iditem=Integer.parseInt(strItem);


    }

}