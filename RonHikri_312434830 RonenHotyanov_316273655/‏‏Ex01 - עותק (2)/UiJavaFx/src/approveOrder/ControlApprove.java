package approveOrder;

import EngOfUi.FactoryData;
import clasinEx.classManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ControlApprove {

    private classManeger obj;
    private Stage primaryStage;
    private int idcustomer;
    private LocalDate date;
    private int selectOrder;
    private int idstore;
    private FactoryData F;



    @FXML
    private Button approve;

    @FXML
    private Button notApprove;

    public ControlApprove()
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
    public void setIdcustomer(int value)
    {
        this.idcustomer=value;
    }
    public void setDate(LocalDate value)
    {
        this.date=value;
    }
    public void setSelectOrder(int value)
    {
        this.selectOrder=value;
    }
    public void setIdstore(int value)
    {
        this.idstore=value;
    }
    public void setF(FactoryData value)
    {
        this.F=value;
    }

    @FXML
    void ClickApprove(ActionEvent event) {
        int idorder=F.getIdOfOrder();
        idorder=idorder+1;
        F.setIdOfOrder(idorder);
        if(this.selectOrder==1) {
            obj.updatetoOrder(this.idcustomer, this.idstore, this.date, idorder);
            obj.initiall();
        }
        else {
            obj.updateDinamyToOrder(this.idcustomer, this.date, idorder);
            obj.initiall2();
        }
        approve.setDisable(true);
        notApprove.setDisable(true);


    }

    @FXML
    void clicknotApprove(ActionEvent event) {
        approve.setDisable(true);
        notApprove.setDisable(true);

    }

}

