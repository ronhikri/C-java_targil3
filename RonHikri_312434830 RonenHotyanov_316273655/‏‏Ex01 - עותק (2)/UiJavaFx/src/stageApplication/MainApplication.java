package stageApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

import static javafx.application.Application.launch;

public class MainApplication extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }
    public void start(Stage primaryStage)throws Exception
    {
        FXMLLoader loader=new FXMLLoader();
        URL mainFXML=getClass().getResource("Stage-fxml.fxml");
        loader.setLocation(mainFXML);
        BorderPane mena=loader.load();
       StageApp maincontroller=loader.getController();
       maincontroller.setPrimaryStage(primaryStage);
       maincontroller.fill();
       primaryStage.setTitle("Super Duper Market");
        Scene scene=new Scene(mena,900,800);
       primaryStage.setScene(scene);
       primaryStage.show();

    }
}
