package AddItemToStorenext;

import clasinEx.classManeger;
import clasinEx.itemToSystem;
import clasinEx.store;
import exceptions.tryadditemthatsoldinstore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class ControllerItemAddStore {

    private Stage primaryStage;
    private classManeger obj;
    private itemToSystem it;
    private int idstore;
    private double amount;
    private int count;
    public ControllerItemAddStore()
    {
        count=0;
    }

    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }
    public void setObj(classManeger value)
    {
        this.obj=value;
    }
    public void setIt(itemToSystem value)
    {
        this.it=value;
    }

    @FXML
    private ComboBox<String> ListStores;

    @FXML
    private TextField TextPrice;

    @FXML
    private Button addItemToStore;

    @FXML
    private TextArea excep;
    @FXML
    private void initialize()
    {
        excep.setText("Exceptions");
    }

    @FXML
    void ClickAddItem(ActionEvent event) {
        excep.setText("");
        try {
            String ster = ListStores.getValue();
            int index = ster.indexOf(",");
            String idStringSt = ster.substring(0, index);
            int idStore = Integer.parseInt(idStringSt);
            this.idstore = idStore;
                String quantity=TextPrice.getText();
                double quan=Double.parseDouble(quantity);
                this.amount=quan;
            obj.AddItemToSys(this.it,this.idstore,this.amount,this.count);
            this.count=this.count+1;


        }
        catch (NumberFormatException e)
        {
            excep.setText("please select number");

        }
        catch (InputMismatchException e)
        {
            excep.setText("please select double number");

        }
        catch (IllegalFormatException e)
        {
            excep.setText("please select number according to instructions");
        }
        catch (tryadditemthatsoldinstore e)
        {
            excep.setText(e.create());
        }
        catch (Exception e)
        {
            excep.setText("please make accordimg to instructions");
        }



    }

    @FXML
    void ClickSelectStore(ActionEvent event) {
            String ster = ListStores.getValue();
            int index = ster.indexOf(",");
            String idStringSt = ster.substring(0, index);
            int idStore = Integer.parseInt(idStringSt);
            this.idstore = idStore;



    }
    public void fillCombobox()
    {
        for(store s:obj.getStores().getStoress()) {
            String str=String.format("%d",s.getId())+","+s.getName();
            ListStores.getItems().add(str);
        }
    }

}
