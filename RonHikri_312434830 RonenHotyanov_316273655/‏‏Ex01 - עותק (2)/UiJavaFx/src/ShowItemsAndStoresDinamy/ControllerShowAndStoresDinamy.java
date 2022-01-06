package ShowItemsAndStoresDinamy;

import DiscountoffersOrder.ControllerDiscount;
import EngOfUi.FactoryData;
import clasinEx.ShowStoreToOrder;
import clasinEx.classManeger;
import clasinEx.item;
import com.sun.javafx.tk.FileChooserType;
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

public class ControllerShowAndStoresDinamy {
    private classManeger obj;
    private Stage primaryStage;
    private int idCustomer;
    private LocalDate date;
    private boolean selectedItem;
    private int iditem;
    private FactoryData F;

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
    public void setDate(LocalDate value)
    {
        this.date=value;
    }
    public void setF(FactoryData value)
    {
        this.F=value;
    }

    @FXML
    private ComboBox<String> SelectItem;
    @FXML
    private TableView<ShowStoreToOrder> TableStores;

    @FXML
    private TableColumn<ShowStoreToOrder,Integer> IdOfStore;

    @FXML
    private TableColumn<ShowStoreToOrder, String> NameOfStore;

    @FXML
    private TableColumn<ShowStoreToOrder, Integer> cordinatax;

    @FXML
    private TableColumn<ShowStoreToOrder, Integer> cordinatay;

    @FXML
    private TableColumn<ShowStoreToOrder, Double> distance;

    @FXML
    private TableColumn<ShowStoreToOrder, Integer> PPK;

    @FXML
    private TableColumn<ShowStoreToOrder, Double> costsending;

    @FXML
    private TableColumn<ShowStoreToOrder, Integer> sumkindsitems;

    @FXML
    private TableColumn<ShowStoreToOrder, Double> sumprices;

    @FXML
    private Button SelectContinue;
    @FXML
    private TextField selectprice;
    @FXML
    private TextField TheStore;



    @FXML
    private Button Addtoorder;
    @FXML
    private TextField Exceptions;
    @FXML
    private void initialize()
    {
        SelectContinue.setDisable(true);
        Exceptions.setText("Exceptions");
    }

    @FXML
    void ClickAddToOrder(ActionEvent event) {
        Exceptions.setText("");
        String price=selectprice.getText();
        if(selectedItem==true)
        try
        {
            double prices=0;
            if(obj.howToBuy(this.iditem).equals("Quantity"))
            {
                int pricer=Integer.parseInt(price);
                prices=(double)pricer;
            }
            else
            prices=Double.parseDouble(price);
            int idstore=obj.idOfStoreItemMinimumPrice(this.iditem);
            obj.AddListItemdinamyOrder(this.iditem,idstore,prices);
            SelectContinue.setDisable(false);
        }
        catch (IdOfItemNotFound e)
        {
            Exceptions.setText(e.create());
        }
        catch (IdOfStoreNotFound e)
        {
            Exceptions.setText(e.create());
        }
        catch (InputMismatchException e)
        {
            Exceptions.setText("please select double number");
        }
        catch (NumberFormatException e)
        {
            Exceptions.setText("Select number");
        }
        catch (Exception e)
        {
            Exceptions.setText("please select double number");
        }


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
            controllerdiscount.setIdOfStore(0);
            controllerdiscount.setIdCustomer(idCustomer);
            controllerdiscount.setSelectOrder(2);
            controllerdiscount.setF(F);
            controllerdiscount.fillComboxDiscounts();
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
        String str=SelectItem.getValue();
        int index=str.indexOf(',');
        String strItem=str.substring(0,index);
        this.iditem=Integer.parseInt(strItem);
        TheStore.setText(String.format("%d",obj.idOfStoreItemMinimumPrice(this.iditem)));

    }
    public void fillTableItemsDinamyAndCombobox()
    {
        for(item it:obj.getItems().getItems())
        {
            SelectItem.getItems().add(String.format("%d",it.getId())+","+it.getName());
        }
        ObservableList<ShowStoreToOrder>data= FXCollections.observableArrayList();
        ArrayList<ShowStoreToOrder>showStores=obj.buildListStoresInOrderDinamy(this.idCustomer);
        for(int i=0;i<showStores.size();i++)
        {
            data.add(showStores.get(i));
        }
        IdOfStore.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Integer>("idOfStore"));
        NameOfStore.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,String>("nameStore"));
        cordinatax.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Integer>("Cordinatax"));
        cordinatay.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Integer>("Cordinatay"));
        distance.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Double>("Ditance"));
        PPK.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Integer>("ppk"));
        costsending.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Double>("priceSend"));
        sumkindsitems.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Integer>("amountKindsItems"));
        sumprices.setCellValueFactory(new PropertyValueFactory<ShowStoreToOrder,Double>("sumPrices"));
        TableStores.setItems(data);

    }

}
