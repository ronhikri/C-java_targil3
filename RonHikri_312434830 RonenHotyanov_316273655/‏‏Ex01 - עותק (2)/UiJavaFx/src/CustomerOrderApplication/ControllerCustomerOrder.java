package CustomerOrderApplication;

import DateInOrder.ControllDateOrder;
import EngOfUi.FactoryData;
import clasinEx.classManeger;
import clasinEx.customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;

public class ControllerCustomerOrder {
    private classManeger obj;
    private Stage primaryStage;
    private int idofCustomer;
    private FactoryData F;

    public ControllerCustomerOrder()
    {

    }

    public void setObj(classManeger obji) {
        this.obj = obji;
    }

    public void setPrimaryStage(Stage primarystage) {
        this.primaryStage = primarystage;
    }
    public void setF(FactoryData value)
    {
        this.F=value;
    }

    @FXML
    private ComboBox<String> Customers;

    @FXML
    void ClickSelectCustomers(ActionEvent event) {
        String str = Customers.getValue();
        int index = str.indexOf(',');
        String strsub = str.substring(0, index);
        int idCustomer = Integer.parseInt(strsub);
        this.idofCustomer=idCustomer;

    }

    public void fillCustomerOrder() {
        for (customer cust : obj.getIcostomers().getSdmcustomers()) {
            Customers.getItems().add(cust.getId() + "," + cust.getName());
        }
    }

    @FXML
    private Button ContimueOrder;

    @FXML
    void ClickContinueOrder(ActionEvent event) {
        if (this.idofCustomer!=0) {
            try {
                FXMLLoader loader = new FXMLLoader();
                URL DateOrderFxml = getClass().getResource("/DateInOrder/MakeDateOrder-fxml.fxml");
                loader.setLocation(DateOrderFxml);
                BorderPane root = loader.load();
                ControllDateOrder dateorder=loader.getController();
                BorderPane borderPane=(BorderPane)primaryStage.getScene().getRoot();
                dateorder.setObj(obj);
                dateorder.setPrimaryStage(primaryStage);
                dateorder.setIdCustomer(this.idofCustomer);
                dateorder.setF(F);
                borderPane.centerProperty().setValue(root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }


    }

}
