package DateInOrder;

import EngOfUi.FactoryData;
import clasinEx.classManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import selectStaticOrDinamy.ControllerStatieDinamyOrder;

import javax.swing.event.AncestorEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

public class ControllDateOrder {
    private classManeger obj;
    private Stage primaryStage;
    private int idCustomer;
    private LocalDate date;
    private FactoryData F;


    @FXML
    private DatePicker OrderDate;

    @FXML
    private Button OrderContinue;
    public ControllDateOrder()
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
    public  void setIdCustomer(int value)
    {
        this.idCustomer=value;
    }
    public void setF(FactoryData value)
    {
        this.F=value;
    }

    @FXML
    void ClickSelectOrder(ActionEvent event) {
        LocalDate datei=OrderDate.getValue();
        this.date=datei;

    }

    @FXML
    void selectContinueOrder(ActionEvent event) {
        if(this.date!=null)
        {
            try
            {
                FXMLLoader loader=new FXMLLoader();
                URL staticordinamyorder=getClass().getResource("/selectStaticOrDinamy/selectStatieDinamyOrder-fxml.fxml");
                loader.setLocation(staticordinamyorder);
                AnchorPane anchorPane= loader.load();
                ControllerStatieDinamyOrder statiedinamyordr=loader.getController();
                BorderPane boarderpane=(BorderPane)primaryStage.getScene().getRoot();
                statiedinamyordr.setPrimaryStage(primaryStage);
                statiedinamyordr.setObj(obj);
                statiedinamyordr.setDate(this.date);
                statiedinamyordr.setIdOfCustomer(this.idCustomer);
                statiedinamyordr.setF(F);
                boarderpane.centerProperty().setValue(anchorPane);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }

}
