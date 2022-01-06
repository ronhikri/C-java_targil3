package CoclusionOrder;

import EngOfUi.FactoryData;
import ShowItemsOrder.ControllShowItemsOrder;
import clasinEx.classManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerConOrd {
    private classManeger obj;
    private Stage primaryStage;
    private int idCustomer;
    private int idStore;
    private LocalDate date;
    private FactoryData F;

    public ControllerConOrd()
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
    public void setIdCustomer(int value)
    {
        this.idCustomer=value;
    }
    public void setIdStore(int value)
    {
        this.idStore=value;
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
    private ListView<String> ListData;

    @FXML
    private Button Selectcontinue;

    @FXML
    private Button showdata;

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
            show.setIdcustomer(this.idCustomer);
            show.setIdstore(this.idStore);
            show.setDate(date);
            show.setF(F);
            show.setSelectOrder(1);
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
        ArrayList<String>list=obj.createdataStore(this.idStore,this.idCustomer);
        ListData.getItems().clear();
        for(String str:list)
        {
            ListData.getItems().add(str);
        }


    }

}
