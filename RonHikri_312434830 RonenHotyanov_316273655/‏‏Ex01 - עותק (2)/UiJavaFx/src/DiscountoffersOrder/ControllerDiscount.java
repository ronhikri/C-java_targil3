package DiscountoffersOrder;

import CoclusionOrder.ControllerConOrd;
import ConclusionDinamyStores.ControllerDinamyStoresOrder;
import EngOfUi.FactoryData;
import clasinEx.ShowOffer;
import clasinEx.classManeger;
import exceptions.tryAccheiveDiscountThatNoEnough;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import java.util.concurrent.Callable;

public class ControllerDiscount {
    private classManeger obj;
    private Stage primaryStage;
    private int idCustomer;
    private int idOfStore;
    private LocalDate date;
    private int selectOrder;
    private  int iditemselected;
    private FactoryData F;


    @FXML
    private ComboBox<String> Discounts;

    @FXML
    private ComboBox<String> Offers;

    @FXML
    private ComboBox<String> Opperator;

    @FXML
    private TextField Exceptions;

    @FXML
    private TableView<ShowOffer> TableOffers;

    @FXML
    private TableColumn<ShowOffer, Integer> iditemoffer;

    @FXML
    private TableColumn<ShowOffer, String> nameitemoffer;

    @FXML
    private TableColumn<ShowOffer, Double> quantity;

    @FXML
    private TableColumn<ShowOffer, Double> priceunit;

    @FXML
    private Button Continue;

    @FXML
    private Button MakeDiscount;
    @FXML
    private void initialize()
    {
        Exceptions.setText("Exceptions");
    }

    public ControllerDiscount()
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
    public void setSelectOrder(int value)
    {
        this.selectOrder=value;
    }
    public void setIditemselected(int value){this.iditemselected=value;}
    public void setF(FactoryData value)
    {
        this.F=value;
    }

    @FXML
    void ClickContinue(ActionEvent event) {
        if (selectOrder == 1) {
            try {
                FXMLLoader loader = new FXMLLoader();
                URL order = getClass().getResource("/CoclusionOrder/OrderCoclusion-fxml.fxml");
                loader.setLocation(order);
                AnchorPane root = loader.load();
                ControllerConOrd ConOrd = loader.getController();
                ConOrd.setPrimaryStage(primaryStage);
                ConOrd.setObj(obj);
                ConOrd.setIdCustomer(this.idCustomer);
                ConOrd.setIdStore(this.idOfStore);
                ConOrd.setDate(date);
                ConOrd.setF(F);
                BorderPane board = (BorderPane) primaryStage.getScene().getRoot();
                AnchorPane.setTopAnchor(root, 0.0);
                AnchorPane.setBottomAnchor(root, 0.0);
                AnchorPane.setLeftAnchor(root, 0.0);
                AnchorPane.setRightAnchor(root, 0.0);
             board.centerProperty().setValue(root);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            try
            {
                FXMLLoader loader=new FXMLLoader();
                URL dinamyOrder=getClass().getResource("/ConclusionDinamyStores/dinamystorecon-fxml.fxml");
                loader.setLocation(dinamyOrder);
                AnchorPane root=loader.load();
                ControllerDinamyStoresOrder con=loader.getController();
                con.setPrimaryStage(primaryStage);
                con.setObj(obj);
                con.setDate(date);
                con.setIdcustomer(this.idCustomer);
                con.setF(F);
                BorderPane board = (BorderPane) primaryStage.getScene().getRoot();
                AnchorPane.setTopAnchor(root, 0.0);
                AnchorPane.setBottomAnchor(root, 0.0);
                AnchorPane.setLeftAnchor(root, 0.0);
                AnchorPane.setRightAnchor(root, 0.0);
                board.centerProperty().setValue(root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void ClickMakeDiscount(ActionEvent event) {
        try {
            Exceptions.setText("");
            if (Discounts.getValue() != null && Opperator.getValue() != null) {
                String str = Discounts.getValue();
                int index = str.indexOf(',');
                String name = str.substring(0, index);
                String off = Opperator.getValue();
                if (selectOrder != 1) {
                    int indexa = index + 1;
                    while (str.charAt(indexa) != ',') {
                        indexa++;
                    }
                    String idtr = str.substring(index + 1, indexa);
                    int id = Integer.parseInt(idtr);
                    this.idOfStore = obj.idOfStoreItemMinimumPrice(id);
                }
                if (off.equals("select all")) {
                    obj.updateDiscount(name, this.idOfStore, this.selectOrder);
                } else {

                    if (off.equals("select item")) {
                        if (Offers.getValue() != null) {
                            String str2 = Offers.getValue();
                            int inex = str2.indexOf(',');
                            String idofitem = str2.substring(0, inex);
                            int id = Integer.parseInt(idofitem);
                            obj.updateAccordingitem(name, this.idOfStore, id, this.selectOrder);
                        } else {
                            Exceptions.setText("saelecr offer");
                        }

                    }

                }
            } else {
                Exceptions.setText("please select Discount and opperator");
            }
        }
        catch (tryAccheiveDiscountThatNoEnough e)
        {
            Exceptions.setText(e.create());
        }
    }

    @FXML
    void ClickOffer(ActionEvent event) {
        String str=Offers.getValue();
        int index=str.indexOf(',');
        String id=str.substring(0,index);
        this.iditemselected=Integer.parseInt(id);

    }

    @FXML
    void ClickOpperator(ActionEvent event) {

    }

    @FXML
    void ClickSelectdiscount(ActionEvent event) {
        fillTable();
        String str=Discounts.getValue();
        int index=str.indexOf(',');
        String name=str.substring(0,index);
        String opp=obj.createopp(name,this.idOfStore);
        if(opp.equals("ALL-OR-NOTHING"))
        {
            Opperator.getItems().add("select all");
            Opperator.getItems().add("not select");
        }
        else
        {
            Opperator.getItems().add("select item");
            Opperator.getItems().add("not select");
            ArrayList<String>offs=obj.createoffs(name,this.idOfStore,this.selectOrder);
            for(String off:offs)
                Offers.getItems().add(off);


        }


    }
    public void fillComboxDiscounts()
    {
        ArrayList<ArrayList<ArrayList<String>>>Siss=obj.CreateDiscountAndOffers(this.selectOrder);
        for(ArrayList<ArrayList<String>> sis:Siss)
        {
            for(ArrayList<String>si:sis)
            {
                Discounts.getItems().add(si.get(0));
            }
        }
    }
    public void fillTable()
    {
        String Disca=Discounts.getValue();
        int index=Disca.indexOf(',');
        int indexa;
        String name=Disca.substring(0,index);
        if(selectOrder!=1)
        {
            indexa=index+1;
            while(Disca.charAt(indexa)!=',')
            {
                indexa++;
            }
            String idtr=Disca.substring(index+1,indexa);
            int id=Integer.parseInt(idtr);
            this.idOfStore=obj.idOfStoreItemMinimumPrice(id);
        }
        ArrayList<ShowOffer>offs=obj.createOffers(this.idOfStore,name);
        ObservableList<ShowOffer>data= FXCollections.observableArrayList();
        for(ShowOffer showoff:offs)
        {
            data.add(showoff);
        }
        iditemoffer.setCellValueFactory(new PropertyValueFactory<ShowOffer,Integer>("id"));
        nameitemoffer.setCellValueFactory(new PropertyValueFactory<ShowOffer,String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<ShowOffer,Double>("amount"));
        priceunit.setCellValueFactory(new PropertyValueFactory<ShowOffer,Double>("price"));
        TableOffers.setItems(data);
    }

}
