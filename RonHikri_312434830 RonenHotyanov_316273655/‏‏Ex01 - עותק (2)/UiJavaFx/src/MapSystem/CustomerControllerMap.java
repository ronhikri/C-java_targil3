package MapSystem;

import clasinEx.CustomerofMap;
import clasinEx.classManeger;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class CustomerControllerMap {

    private classManeger obj;
    private Stage primaryStage;
    private int x;
    private int y;

    public CustomerControllerMap()
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
    public void setX(int value)
    {
        this.x=value;
    }
    public void setY(int value)
    {
        this.y=value;
    }
    public void filldata()
    {
        AnchorPane anchorPane=new AnchorPane();
        anchorPane.setPrefHeight(564);
        anchorPane.setPrefWidth(778);
        VBox vBox=new VBox();
        vBox.setPrefHeight(502);
        vBox.setPrefWidth(295);
        vBox.setSpacing(90);
        vBox.setLayoutX(252);
        vBox.setLayoutY(30);
        Label label=new Label();
        label.setLayoutX(89);
        label.setLayoutY(30);
        label.setPrefHeight(17);
        label.setPrefWidth(185);
        label.setText("The id Of Customer");
        Label label2=new Label();
        label2.setLayoutX(80);
        label2.setLayoutY(147);
        label2.setPrefHeight(17);
        label2.setPrefWidth(160);
        label2.setText("The Name Of Customer");
        Label label3=new Label();
        label3.setLayoutX(73);
        label3.setLayoutY(265);
        label3.setPrefHeight(17);
        label3.setPrefWidth(153);
        label3.setText("The Location Of Customer");
        Label label4=new Label();
        label4.setLayoutX(51);
        label4.setLayoutY(379);
        label4.setPrefHeight(17);
        label4.setPrefWidth(160);
        label4.setText("The Sum Orders Of Customer");
        CustomerofMap cmp=obj.createCustInMap(this.x,this.y);
        TextField textField1=new TextField();
        textField1.setText(String.format("%d",cmp.getIdCustomer()));
        TextField textField2=new TextField();
        textField2.setText(cmp.getNameCustomer());
        String L="X : "+String.format("%d",cmp.getCordinataX())+","+"Y : "+String.format("%d",cmp.getCordinataY());
        TextField textField3=new TextField();
        textField3.setText(L);
        TextField textField4=new TextField();
        textField4.setText(String.format("%d",cmp.getSumOrders()));
        vBox.getChildren().add(textField1);
        vBox.getChildren().add(textField2);
        vBox.getChildren().add(textField3);
        vBox.getChildren().add(textField4);
        anchorPane.getChildren().add(vBox);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        AnchorPane.setTopAnchor(anchorPane,0.0);
        AnchorPane.setBottomAnchor(anchorPane,0.0);
        AnchorPane.setRightAnchor(anchorPane,0.0);
        AnchorPane.setLeftAnchor(anchorPane,0.0);
        BorderPane boared=(BorderPane)primaryStage.getScene().getRoot();
        boared.centerProperty().setValue(anchorPane);
    }

}
