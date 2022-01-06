package AddItemsToOffer;

import clasinEx.AddDiscToSys;
import clasinEx.classManeger;
import exceptions.tryAddOfferThatFoundInDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class ControllerAddOffer {
    private classManeger obj;
    private Stage primaryStage;
    private AddDiscToSys disc;
    private int iditemoffer;
    private double priceUnit;
    private double amountItemOffer;
    private int count;

    @FXML
    private void initialize()
    {
        excep.setText("Exceptions");
    }

    public  ControllerAddOffer()
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
    public void setDisc(AddDiscToSys value)
    {
        this.disc=value;
    }


    @FXML
    private ComboBox<String> selectItems;

    @FXML
    private TextField AmountToOffer;

    @FXML
    private TextField PriceItemToOffer;

    @FXML
    private TextArea excep;

    @FXML
    private Button addItemToOffer;

    @FXML
    void AclickPriceItemToOffer(ActionEvent event) {

    }

    @FXML
    void ClickAddItemToOffer(ActionEvent event) {
        try
        {
            excep.setText("");
            String iter=selectItems.getValue();
            int index=iter.indexOf(",");
            String iditem=iter.substring(0,index);
            int idofitem=Integer.parseInt(iditem);
            this.iditemoffer=idofitem;
            String amount=AmountToOffer.getText();
            String howbuy=obj.howToBuy(this.iditemoffer);
            if(howbuy.equals("Weight"))
            {
                double Amount=Double.parseDouble(amount);
                this.amountItemOffer=Amount;
            }
            else
            {
                int Amount=Integer.parseInt(amount);
                this.amountItemOffer=(double)(Amount);
            }
            String Price=PriceItemToOffer.getText();
            double pricer=Double.parseDouble(Price);
          this.priceUnit=pricer;
          obj.AddOfferToDiscount(this.disc,this.iditemoffer,this.amountItemOffer,this.priceUnit,this.count);
          this.count=this.count+1;
        }
        catch (tryAddOfferThatFoundInDisc e)
        {
            excep.setText(e.create());
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
        catch (Exception e)
        {
            excep.setText("please make accordimg to instructions");
        }


    }

    @FXML
    void ClickAmountItemToOffer(ActionEvent event) {

    }

    @FXML
    void ClickSelectOffers(ActionEvent event) {

    }
    public void fillcombobox()
    {
        ArrayList<String>ListItems=obj.createItems(this.disc.getIdOfStoreOfItem());
        for(String st:ListItems)
            selectItems.getItems().add(st);
        this.count=0;
    }

}
