package AddItemToSystem;

import AddItemToStorenext.ControllerItemAddStore;
import clasinEx.classManeger;
import clasinEx.itemToSystem;
import exceptions.tryAddItemToSysThatFound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.IllegalFormatException;

public class ControllerAddItemTosys {
    private classManeger obj;
    private Stage primaryStage;
    private int iditem;
    private String nameItem;
    private String howBuy;

    public ControllerAddItemTosys()
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

    @FXML
    private TextField selectidItem;

    @FXML
    private TextField selectname;

    @FXML
    private Button SelectContinue;

    @FXML
    private ComboBox<String> wayToBuy;
    @FXML
    private TextArea excep;
    @FXML
    private void initialize()
    {
        excep.setText("Exceptions");
    }

    @FXML
    void ClickContiue(ActionEvent event) {
        if (wayToBuy.getValue() != null) {
            try {
                String idOfItem = selectidItem.getText();
                int idofitem = Integer.parseInt(idOfItem);
                this.iditem = idofitem;
                String nameOfItem = selectname.getText();
                this.nameItem = nameOfItem;
                String howbuy = wayToBuy.getValue();
                this.howBuy = howbuy;
                obj.checkiditemFoundInSystem(this.iditem);
                itemToSystem it = new itemToSystem();
                it.setIditem(this.iditem);
                it.setNameitem(this.nameItem);
                it.setHowToBuy(this.howBuy);
                FXMLLoader loader = new FXMLLoader();
                URL ADitemToS = getClass().getResource("/AddItemToStorenext/AddItemToStotrenet-fxml.fxml");
                loader.setLocation(ADitemToS);
                AnchorPane root = loader.load();
                ControllerItemAddStore conAddI = loader.getController();
                BorderPane boared = (BorderPane) primaryStage.getScene().getRoot();
                conAddI.setPrimaryStage(primaryStage);
                conAddI.setObj(obj);
                conAddI.setIt(it);
                conAddI.fillCombobox();
                AnchorPane.setTopAnchor(root, 0.0);
                AnchorPane.setBottomAnchor(root, 0.0);
                AnchorPane.setRightAnchor(root, 0.0);
                AnchorPane.setLeftAnchor(root, 0.0);
                boared.centerProperty().setValue(root);


            } catch (NumberFormatException e) {
                excep.setText("please select Number");
            } catch (IllegalFormatException e) {
                excep.setText("please select Number");
            } catch (tryAddItemToSysThatFound e) {
                excep.setText(e.create());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                excep.setText("please make accordimg to instructions");
            }

        } else {
            excep.setText("You Must select howbuyItem");

        }
    }

    @FXML
    void ClickWayToBuy(ActionEvent event) {
        this.howBuy=wayToBuy.getValue();

    }
    public void fillCombobox()
    {
        wayToBuy.getItems().add("Quantity");
        wayToBuy.getItems().add("Weight");
    }

}