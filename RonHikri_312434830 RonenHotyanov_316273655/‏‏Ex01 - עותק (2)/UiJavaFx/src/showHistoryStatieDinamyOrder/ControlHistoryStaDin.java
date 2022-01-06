package showHistoryStatieDinamyOrder;


import DataStoreHistoryOrder.controllershowStoresHistoryDinamy;
import HistoryStaOrder.ControlStatHistoryOrd;
import clasinEx.classManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.acl.AclNotFoundException;

public class ControlHistoryStaDin {
    private Stage primaryStage;
    private classManeger obj;

    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }
   public  void setObj(classManeger obji)
    {
        this.obj=obji;
    }


    @FXML
    private Button staticorderlist;

    @FXML
    private Button DinamyOrders;

    public ControlHistoryStaDin()
    {

    }


   @FXML
   void clickDinamyOrders(ActionEvent event) {
        try
        {
            FXMLLoader loader=new FXMLLoader();
            URL DataHistoryDin=getClass().getResource("/DataStoreHistoryOrder/DinamyStoreHistory-fxml.fxml");
            loader.setLocation(DataHistoryDin);
            AnchorPane root=loader.load();
            controllershowStoresHistoryDinamy condin=loader.getController();
            BorderPane baord=(BorderPane)primaryStage.getScene().getRoot();
            condin.setObj(obj);
            condin.setPrimaryStage(primaryStage);
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            condin.fillcombobox();
            baord.centerProperty().setValue(root);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }


    @FXML
    void clickStaticOrders(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL DataHistorySta = getClass().getResource("/HistoryStaOrder/HistoryStaticListOrdr-fxml.fxml");
            loader.setLocation(DataHistorySta);
            AnchorPane root = loader.load();
            ControlStatHistoryOrd staticord=loader.getController();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            staticord.setObj(obj);
            staticord.setPrimaryStage(primaryStage);
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            staticord.fillCombobox();
            board.centerProperty().setValue(root);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
