package CustomerOfMap;

import clasinEx.CustomerofMap;
import clasinEx.classManeger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerMapCust {
    private classManeger obj;
    private Stage primaryStage;
    private int CordinataX;
    private int CordinataY;


    public ControllerMapCust()
    {

    }


    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField Space;

    @FXML
    private TextField sumorders;

    public void setObj(classManeger value)
    {
        this.obj=value;
    }
    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }
    public void setCordinataX(int value)
    {
        this.CordinataX=value;
    }
    public void setCordinataY(int value)
    {
        this.CordinataY=value;
    }
    public void filldata()
    {
        CustomerofMap cmp=obj.createCustInMap(this.CordinataX,this.CordinataY);
        id.setText(String.format("%d",cmp.getIdCustomer()));
        name.setText(cmp.getNameCustomer());
        String L="X : "+String.format("%d",cmp.getCordinataX())+","+"Y : "+String.format("%d",this.CordinataY);
        Space.setText(L);
        sumorders.setText(String.format("%d",cmp.getSumOrders()));
    }

}
