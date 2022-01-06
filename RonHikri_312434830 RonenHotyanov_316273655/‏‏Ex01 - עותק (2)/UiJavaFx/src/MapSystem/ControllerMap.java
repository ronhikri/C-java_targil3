package MapSystem;

import CustomerOfMap.ControllerMapCust;
import clasinEx.classManeger;
import dataStoreMap.ControllerMapStore;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ControllerMap {
    private Stage primaryStage;
    private classManeger obj;
    public  ControllerMap()
    {

    }
    public void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }
    public void setObj(classManeger value)
    {
        this.obj=value;
    }
    public void fillMap()
    {
        Scene scene=primaryStage.getScene();
        GridPane root=new GridPane();
        root.prefHeight(400);
        root.prefWidth(400);
        RowConstraints rowConstraint=null;
        ColumnConstraints columnConstraints=null;
        for(int i=1;i<=obj.maxheightofmap();i++) {
            rowConstraint = new RowConstraints();
            rowConstraint.setMinHeight(10);
            rowConstraint.setPrefHeight(10);
            rowConstraint.setVgrow(Priority.SOMETIMES);
            root.getRowConstraints().add(rowConstraint);
        }
            for (int j = 1; j <= obj.maxwitdh(); j++) {
                columnConstraints = new ColumnConstraints();
                columnConstraints.setMinWidth(10);
                columnConstraints.setPrefWidth(10);
                columnConstraints.setHgrow(Priority.SOMETIMES);
                root.getColumnConstraints().add(columnConstraints);
            }

            for(int i=1;i<=obj.maxwitdh();i++)
            {
                for(int j=1;j<=obj.maxheightofmap();j++)
                {
                Button bth = new Button();
               boolean founds=obj.cordinatotOfStotre(i,j);
               if(founds==true)
                   bth.setText("s");
               else
               {
                    boolean foundC=obj.cordinatotOfCustomer(i,j);
                    if(foundC==true)
                        bth.setText("c");
               }
                bth.prefHeight(400/obj.maxheightofmap());
                bth.prefWidth(400/obj.maxwitdh());
                bth.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        int column=GridPane.getColumnIndex((Node)event.getSource());
                        int row=GridPane.getRowIndex((Node)event.getSource());
                        boolean foundS=obj.cordinatotOfStotre(column,row);
                        if(foundS)
                        {
                            CreateDataStores(column,row);
                        }
                        else
                        {
                            boolean foundC=obj.cordinatotOfCustomer(column,row);
                            if(foundC)
                            {
                                createDataCustomers(column,row);
                            }

                        }
                    }
                });
                root.add(bth,i,j);
            }
        }
        BorderPane boared=(BorderPane)primaryStage.getScene().getRoot();
        boared.centerProperty().setValue(root);
    }
    public void CreateDataStores(int column,int row) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL storeMap = getClass().getResource("/dataStoreMap/storeMap-fxml.fxml");
            loader.setLocation(storeMap);
            Pane root = loader.load();
            ControllerMapStore conmap = loader.getController();
            BorderPane board = (BorderPane) primaryStage.getScene().getRoot();
            conmap.setPrimaryStage(this.primaryStage);
            conmap.setObj(obj);
            conmap.setCorinataX(column);
            conmap.setCordinataY(row);
            conmap.filldata();
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            board.centerProperty().setValue(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void createDataCustomers(int column,int row)
    {
        try {
            FXMLLoader loader = new FXMLLoader();
           // URL CustomMap = getClass().getResource("../CustomerOfMap/test.fxml");
            //C:\Users\רון הכרי\IdeaProjects\Ex01\UiJavaFx\src\CustomerOfMap\CustomerMapi-fxml.fxml
            //URL CustomMap = getClass().getResource("/CustomerOfMap/CustomerMapi-fxml.fxml");
            loader.setLocation( getClass().getResource("/CustomerOfMap/CustomerMapi-fxml.fxml"));//CustomMap);
            Pane root = loader.load();
            ControllerMapCust CMAP=loader.getController();
            BorderPane boared=(BorderPane)primaryStage.getScene().getRoot();
            CMAP.setPrimaryStage(primaryStage);
            CMAP.setObj(obj);
            CMAP.setCordinataX(column);
            CMAP.setCordinataY(row);
            CMAP.filldata();
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            boared.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void createdataCustomers(int column,int row)
    {
        CustomerControllerMap custMap=new CustomerControllerMap();
        custMap.setObj(obj);
        custMap.setPrimaryStage(primaryStage);
        custMap.setX(column);
        custMap.setY(row);
        custMap.filldata();
    }

}
