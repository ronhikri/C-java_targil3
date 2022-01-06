package dataStoreMap;

import clasinEx.StoreInMap;
import clasinEx.classManeger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ControllerMapStore {

    private classManeger obj;
    private Stage primaryStage;
    private int CorinataX;
    private int CordinataY;

    public ControllerMapStore()
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
    public void setCorinataX(int value)
    {
        this.CorinataX=value;
    }
    public void setCordinataY(int value)
    {
        this.CordinataY=value;
    }




    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField ppk;

    @FXML
    private TextField sumOrders;

    @FXML
    private TextField TheCordinatot;

    public void filldata()
    {
        StoreInMap SMP=obj.createStoreMap(this.CorinataX,this.CordinataY);
        id.setText(String.format("%d",SMP.getIdstore()));
        name.setText(SMP.getNamestore());
        ppk.setText(String.format("%d",SMP.getPpk()));
        sumOrders.setText(String.format("%d",SMP.getSumOrders()));
        String cords="X : "+String.format("%d",SMP.getCordinatax())+","+"Y : "+String.format("%d", SMP.getCordinataY());
        TheCordinatot.setText(cords);

    }

}
