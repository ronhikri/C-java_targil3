package AddDiscountToSystem;

import AddItemsToOffer.ControllerAddOffer;
import clasinEx.AddDiscToSys;
import clasinEx.classManeger;
import exceptions.AddTrySameDiscount;
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
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class ControllerAddDiscount {
    private classManeger obj;
    private Stage primaryStage;
    private String nameDiscount;
    private int idStore;
    private int idItem;
    private Double amount;
    private String operation;




    @FXML
    private ComboBox<String> Stores;

    @FXML
    private TextField SelectName;

    @FXML
    private ComboBox<String> selectItem;

    @FXML
    private TextField selectQuantity;

    @FXML
    private ComboBox<String> Op;

    @FXML
    private TextArea ecep;

    @FXML
    private Button selectContinue;
    @FXML
    private void initialize()
    {
        ecep.setText("Exceptions");
    }

    public ControllerAddDiscount()
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
    void CickSelectStore(ActionEvent event) {
        selectItem.getItems().clear();
        String str = Stores.getValue();
        int index = str.indexOf(",");
        String idStore = str.substring(0, index);
        int idofstore = Integer.parseInt(idStore);
        this.idStore = idofstore;
        ArrayList<String> listItems = obj.createItems(this.idStore);
        for (String it : listItems)
            selectItem.getItems().add(it);

    }
    @FXML
    void ClickContinue(ActionEvent event) {
        if (Op.getValue() != null) {
            ecep.setText("");
            try {
                String iter = selectItem.getValue();
                int index = iter.indexOf(",");
                String idofitem = iter.substring(0, index);
                int iditem = Integer.parseInt(idofitem);
                this.idItem = iditem;
                String name = SelectName.getText();
                obj.checkSameDiscount(name);
                this.nameDiscount = name;
                String quantity = selectQuantity.getText();
                String howbuy = obj.howToBuy(this.idItem);
                if (howbuy.equals("Weight")) {
                    double quan = Double.parseDouble(quantity);
                    this.amount = quan;


                } else {
                    int quan = Integer.parseInt(quantity);
                    this.amount = (double) (quan);
                }
                String op = Op.getValue();
                this.operation = op;
                AddDiscToSys Disca = new AddDiscToSys();
                Disca.setNameDisc(this.nameDiscount);
                Disca.setIdOfStoreOfItem(this.idStore);
                Disca.setIdItem(this.idItem);
                Disca.setAmount(this.amount);
                Disca.setOperator(this.operation);
                FXMLLoader loader = new FXMLLoader();
                URL AdItOffer = getClass().getResource("/AddItemsToOffer/AddItemsOffer-fxml.fxml");
                loader.setLocation(AdItOffer);
                AnchorPane root = loader.load();
                ControllerAddOffer AdOfer = loader.getController();
                AdOfer.setPrimaryStage(primaryStage);
                AdOfer.setObj(obj);
                AdOfer.setDisc(Disca);
                AdOfer.fillcombobox();
                BorderPane board = (BorderPane) primaryStage.getScene().getRoot();
                AnchorPane.setTopAnchor(root, 0.0);
                AnchorPane.setBottomAnchor(root, 0.0);
                AnchorPane.setRightAnchor(root, 0.0);
                AnchorPane.setLeftAnchor(root, 0.0);
                board.centerProperty().setValue(root);


            } catch (AddTrySameDiscount e) {
                ecep.setText(e.create());
            } catch (NumberFormatException e) {
                ecep.setText("please select number");

            } catch (InputMismatchException e) {
                ecep.setText("please select double number");

            } catch (IllegalFormatException e) {
                ecep.setText("please select number according to instructions");
            } catch (Exception e) {
                ecep.setText("please make accordimg to instructions");
            }


        } else {
            ecep.setText("please make accordimg to instructions");

        }
    }

    @FXML
    void ClickSelectItem(ActionEvent event) {

    }

    @FXML
    void ClickSelectOperator(ActionEvent event) {

    }
    public void FillSystem()
    {
        ArrayList<String>ListStores=obj.createStringStores();
       for(String st:ListStores)
           Stores.getItems().add(st);
       Op.getItems().add("ONE-OF");
       Op.getItems().add("ALL-OR-NOTHING");
    }

}
