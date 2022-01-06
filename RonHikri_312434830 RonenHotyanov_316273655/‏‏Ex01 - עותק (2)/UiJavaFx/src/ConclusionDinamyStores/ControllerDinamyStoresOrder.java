package ConclusionDinamyStores;

import EngOfUi.FactoryData;
import ShowItemsOrder.ControllShowItemsOrder;
import clasinEx.ShowStorsDinamyOrder;
import clasinEx.classManeger;
import com.sun.javafx.tk.FileChooserType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerDinamyStoresOrder {
    private classManeger obj;
    private Stage primaryStage;
    private int idcustomer;
    private LocalDate date;
    private FactoryData F;
    public ControllerDinamyStoresOrder()
    {

    }
    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public void setPrimaryStage(Stage primarystage)
    {
        this.primaryStage=primarystage;
    }
    public void setIdcustomer(int value)
    {
        this.idcustomer=value;
    }
    public  void setDate(LocalDate value)
    {
        this.date=value;
    }
    public  void setF(FactoryData value)
    {
        this.F=value;
    }


    @FXML
    private TableView<ShowStorsDinamyOrder> TableStores;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Integer> id;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, String> name;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Integer> ppk;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Double> distance;

    @FXML
    private TableColumn<ShowStorsDinamyOrder, Double> costsend;

    @FXML
    private Button showdata;

    @FXML
    private Button slectContinue;

    @FXML
    void ClickContinue(ActionEvent event) {
        try
        {
            FXMLLoader loader=new FXMLLoader();
            URL conShowItemsOrder=getClass().getResource("/ShowItemsOrder/ShowConclusionItems-fxml.fxml");
            loader.setLocation(conShowItemsOrder);
            AnchorPane root=loader.load();
            ControllShowItemsOrder show=loader.getController();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            show.setPrimaryStage(primaryStage);
            show.setObj(obj);
            show.setIdcustomer(this.idcustomer);
            show.setIdstore(0);
            show.setDate(date);
            show.setSelectOrder(2);
            show.setF(F);
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
        ArrayList<ShowStorsDinamyOrder>list=obj.createStoresDinamy(this.idcustomer);
        ObservableList<ShowStorsDinamyOrder>data= FXCollections.observableArrayList();
        for(ShowStorsDinamyOrder s:list)
        {
            data.add(s);
        }
        id.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,String>("namr"));
        ppk.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Integer>("ppk"));
        distance.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Double>("distance"));
        costsend.setCellValueFactory(new PropertyValueFactory<ShowStorsDinamyOrder,Double>("costSending"));
        TableStores.setItems(data);


    }

}
