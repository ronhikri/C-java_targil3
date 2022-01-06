package stageApplication;

import AddDiscountToSystem.ControllerAddDiscount;
import AddItemToSystem.ControllerAddItemTosys;
import AddStore.ControllerAddStore;
import CustomerApplication.CostomerController;
import CustomerOrderApplication.ControllerCustomerOrder;
import EngOfUi.FactoryData;
import MapSystem.ControllerMap;
import ShowStores.ControllerShowStores;
import UpdateItemInStore.ControllerUpdateItem;
import clasinEx.FileXml;
import clasinEx.XmlLoaderTask;
import clasinEx.classManeger;
import com.sun.jndi.toolkit.url.Uri;
import exceptions.*;
import itemsApplication.controllerItemsShow;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import showHistoryStatieDinamyOrder.ControlHistoryStaDin;
import stageApplication.*;

import java.awt.*;
import java.awt.ScrollPane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import stageApplication.MainApplication;

public class StageApp {
    private classManeger obj;
    private Stage primaryStage;
    private SimpleBooleanProperty ismlLoader;
    private FactoryData F;
    public StageApp() {
        obj = null;
        F=new FactoryData();
        ismlLoader=new SimpleBooleanProperty(false);

    }

    public void setPrimaryStage(Stage primarystage) {
        this.primaryStage = primarystage;
    }
    public void SetObj(classManeger obji)
    {
        this.obj=obji;
    }

    @FXML
    private Button ClickLoadFromXmlFile;
    @FXML
    private ProgressBar ProgressBar;


    @FXML
    private TextArea TextExceptions;

    @FXML
    private Button ListOfCostumers;

    @FXML
    private Button ListItems;

    @FXML
    private Button ListStores;

    @FXML
    private Button ClickUpdateItems;

    @FXML
    private Button ClickMakeOrder;

    @FXML
    private Button MapOfSystem;

    @FXML
    private Button Historyorders;
    @FXML
    private Button AddStore;
    @FXML
    private Button addItemToSys;
    @FXML
    private Button selectAddDiscount;
    @FXML
    private ComboBox<String> selectcolorCust;

    @FXML
    private ComboBox<String> SelectColorItems;

    @FXML
    private ComboBox<String> SelectColorStores;

    @FXML
    private ComboBox<String> SelectColorItemsAndStores;

    @FXML
    private ComboBox<String> SelectColorOrder;

    @FXML
    private ComboBox<String> SelectColorMap;

    @FXML
    private ComboBox<String> SelectColorHistorOrder;

    @FXML
    private ComboBox<String> SelectColorAddStore;

    @FXML
    private ComboBox<String> SelectAddItemColor;

    @FXML
    private ComboBox<String> SelectAddDiscountColor;
    @FXML
    private ComboBox<String> selectColorScene;
    @FXML
    private BorderPane SceneApp;


    public void fill()
    {
        ArrayList<String>list=new ArrayList<>();
        list.add("pink");
        list.add("brown");
        list.add("white");
        list.add("purper");
        list.add("orange");
        list.add("yellow");
        list.add("red");
        list.add("blue");
        list.add("grey");
        for(String s:list)
        {
            selectcolorCust.getItems().add(s);
            SelectColorStores.getItems().add(s);
            SelectColorItems.getItems().add(s);
            SelectColorItemsAndStores.getItems().add(s);
            SelectColorOrder.getItems().add(s);
            SelectColorHistorOrder.getItems().add(s);
            SelectColorMap.getItems().add(s);
            SelectAddItemColor.getItems().add(s);
            SelectColorAddStore.getItems().add(s);
            SelectAddDiscountColor.getItems().add(s);
            selectColorScene.getItems().add(s);
        }
    }



    @FXML
    void ClickAddItemToSys(ActionEvent event) {
        if(this.obj==null)
        {
            TextExceptions.setText("The obj Super Duper Market nill and so impossible to look data,please load xml");
        }
        else {
            try {
                FXMLLoader loader = new FXMLLoader();
                URL adItem=getClass().getResource("/AddItemToSystem/AddItemToSys-fxml.fxml");
                loader.setLocation(adItem);
                AnchorPane root=loader.load();
                ControllerAddItemTosys addItemToSys=loader.getController();
                BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
                addItemToSys.setObj(obj);
                addItemToSys.setPrimaryStage(primaryStage);
                addItemToSys.fillCombobox();
                AnchorPane.setTopAnchor(root,0.0);
                AnchorPane.setBottomAnchor(root,0.0);
                AnchorPane.setRightAnchor(root,0.0);
                AnchorPane.setLeftAnchor(root,0.0);
                board.centerProperty().setValue(root);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void ClickAddStore(ActionEvent event) {
        if(this.obj==null)
        {
            TextExceptions.setText("The obj Super Duper Market nill and so impossible to look data,please load xml");
        }
        else
        {
            try {
                FXMLLoader loader=new FXMLLoader();
                URL adStore=getClass().getResource("/AddStore/Addstore-fxml.fxml");
                loader.setLocation(adStore);
                AnchorPane root=loader.load();
                ControllerAddStore AddSsystem=loader.getController();
                BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
                AddSsystem.setPrimaryStage(primaryStage);
                AddSsystem.setObj(obj);
                AnchorPane.setTopAnchor(root,0.0);
                AnchorPane.setBottomAnchor(root,0.0);
                AnchorPane.setRightAnchor(root,0.0);
                AnchorPane.setLeftAnchor(root,0.0);
                board.centerProperty().setValue(root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


    }

    @FXML
    private void initialize()
    {
        ListOfCostumers.disableProperty().bind(ismlLoader.not());
        ListItems.disableProperty().bind(ismlLoader.not());
        ListStores.disableProperty().bind(ismlLoader.not());
        ClickUpdateItems.disableProperty().bind(ismlLoader.not());
        ClickUpdateItems.disableProperty().bind(ismlLoader.not());
        ClickMakeOrder.disableProperty().bind(ismlLoader.not());
        MapOfSystem.disableProperty().bind(ismlLoader.not());
        Historyorders.disableProperty().bind(ismlLoader.not());
        AddStore.disableProperty().bind(ismlLoader.not());
        addItemToSys.disableProperty().bind(ismlLoader.not());
        selectAddDiscount.disableProperty().bind(ismlLoader.not());

    }
    public void bindUIToTask(Task<Boolean> task) {
        TextExceptions.textProperty().bindBidirectional((Property<String>) task.messageProperty());
        ProgressBar.progressProperty().bind(task.progressProperty());
    }

    @FXML
    void ClickLoadXmlFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        String absolutePath;
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("xml files", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile == null)
            return;
        else {
             absolutePath = selectedFile.getAbsolutePath();

            };

        Consumer<classManeger> superMarketConsumer2 = obji -> {this.obj=obji;};
        Consumer<SimpleBooleanProperty>isloadered=isloader->{this.ismlLoader.setValue(isloader.getValue());};
            XmlLoaderTask task = new XmlLoaderTask(absolutePath, superMarketConsumer2,isloadered);
            bindUIToTask(task);
            new Thread(task).start();




            /*
            FileXml file = new FileXml();
            file.setFileName(absolutePath);
            classManeger obji = file.fileToGame();
            try {
                file.checkIdSame(obji);
                file.checkExistallstores(obji);
                file.checkitemsallnotsell(obji);
                file.checkitemsnotsellmoretimeinallstores(obji);
                file.checkallstoresnotlocation(obji);
                file.checkSameocationinStores(obji);
                file.checkIfHasCustomersWithSameId(obji);
                file.checkIfHaCustomersWithSameLocation(obji);
                file.checkOfferThatNotSoldInStore(obji);
                file.chreckOfferNotFoundInFile(obji);
                this.obj = obji;
            } catch (idsameitemsorstoresexceptions e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (itemnotexitinrefexception e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (itemthatnotsellexception e) {
                TextExceptions.setText(e.create());
                this.obj = null;

            } catch (itemsellmoreoneinstoreexception e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (locationofsoreexcept e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (sameLocationinStores e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (checksamecustomers e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (checkCustomersSmeLocation e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (offerThatNotSoldInStore e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            } catch (offersthatnotFound e) {
                TextExceptions.setText(e.create());
                this.obj = null;
            }

        }*/

        }


    @FXML
    void ClickMakeOrders(ActionEvent event) {
        if (this.obj == null) {
            TextExceptions.setText("The obj Super Duper Market nill and so impossible to look data,please load xml");
        } else {
            try {

                FXMLLoader loader = new FXMLLoader();
                URL customerinOrderfxml = getClass().getResource("/CustomerOrderApplication/CustomersInOrder-fxml.fxml");
                loader.setLocation(customerinOrderfxml);
                BorderPane root = loader.load();
                ControllerCustomerOrder controllerordercustomer = loader.getController();
                BorderPane boarderpane = (BorderPane) primaryStage.getScene().getRoot();
                controllerordercustomer.setObj(obj);
                controllerordercustomer.setPrimaryStage(primaryStage);
                controllerordercustomer.setF(F);
                controllerordercustomer.fillCustomerOrder();
                boarderpane.centerProperty().setValue(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @FXML
    void ClickMapSystemSuperMarket(ActionEvent event) {
        ControllerMap mapi=new ControllerMap();
        mapi.setPrimaryStage(primaryStage);
        mapi.setObj(obj);
        mapi.fillMap();

    }

    @FXML
    void ClickShowCustomers(ActionEvent event) {
        if (this.obj == null) {
            TextExceptions.setText("The obj Super Duper Market nill and so impossible to look data,please load xml");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader();
                URL cosutomersFXML = getClass().getResource("/CustomerApplication/CustomersShow-fxml.fxml");
                loader.setLocation(cosutomersFXML);
                BorderPane root = loader.load();
                CostomerController controllerCustomers=loader.getController();
                BorderPane borderPane=(BorderPane) primaryStage.getScene().getRoot();
                controllerCustomers.fillTableCustomer(obj);
                borderPane.centerProperty().setValue(root);



            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void ClickShowItems(ActionEvent event) {
        if (this.obj == null) {
            TextExceptions.setText("The obj Super Duper Market nill and so impossible to look data,please load xml");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader();
                URL itemsFXML = getClass().getResource("/itemsApplication/itemsShow-fxml.fxml");
                loader.setLocation(itemsFXML);
                BorderPane root = loader.load();
                controllerItemsShow controlleritems = loader.getController();
                BorderPane borderPane=(BorderPane)primaryStage.getScene().getRoot();
               controlleritems.voidFillTable(obj);
                borderPane.centerProperty().setValue(root);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void ClickShowStores(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL storesinsystem = getClass().getResource("/ShowStores/ShowStores-fxml.fxml");
            loader.setLocation(storesinsystem);
            VBox root=loader.load();
            ControllerShowStores controllerstores=loader.getController();
            controllerstores.setPrimarystage(primaryStage);
            BorderPane boarder=(BorderPane)primaryStage.getScene().getRoot();
            controllerstores.setObj(obj);
            boarder.centerProperty().setValue(root);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void ClickUpdateItemsAndStores(ActionEvent event) {
        try {
                FXMLLoader loader=new FXMLLoader();
                URL updateItemsInSTore=getClass().getResource("/UpdateItemInStore/UpdateItem-fxml.fxml");
                loader.setLocation(updateItemsInSTore);
                VBox root=loader.load();
            ControllerUpdateItem controllerupdateitem=loader.getController();
            controllerupdateitem.setPrimaryStage(primaryStage);
            BorderPane boarder=(BorderPane)primaryStage.getScene().getRoot();
            controllerupdateitem.setObj(obj);
            boarder.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void showHistoryOrders(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL history = getClass().getResource("/showHistoryStatieDinamyOrder/HistoryStatieDinamy-fxml.fxml");
            loader.setLocation(history);
            AnchorPane root=loader.load();
            ControlHistoryStaDin ControlHistory=loader.getController();
            ControlHistory.setPrimaryStage(primaryStage);
            ControlHistory.setObj(obj);
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            AnchorPane.setTopAnchor(root,0.0);
            AnchorPane.setBottomAnchor(root,0.0);
            AnchorPane.setRightAnchor(root,0.0);
            AnchorPane.setLeftAnchor(root,0.0);
            board.centerProperty().setValue(root);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            TextExceptions.setText("please load xml file");
        }


    }
    @FXML
    void ClickSelectAddDiscount(ActionEvent event) {
        if (this.obj == null) {
            TextExceptions.setText("The obj Super Duper Market nill and so impossible to look data,please load xml");
        }
            else
            {
                try {
                    FXMLLoader loader=new FXMLLoader();
                    URL AdDisc=getClass().getResource("/AddDiscountToSystem/AddDiscount-fxml.fxml");
                    loader.setLocation(AdDisc);
                    AnchorPane root=loader.load();
                    ControllerAddDiscount AddDisc=loader.getController();
                    AddDisc.setPrimaryStage(primaryStage);
                    AddDisc.setObj(obj);
                    AddDisc.FillSystem();
                    BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
                    AnchorPane.setTopAnchor(root,0.0);
                    AnchorPane.setBottomAnchor(root,0.0);
                    AnchorPane.setRightAnchor(root,0.0);
                    AnchorPane.setLeftAnchor(root,0.0);
                    board.centerProperty().setValue(root);


                }
                catch (IOException e) {
                    e.printStackTrace();

                }
        }

    }
    @FXML
    void ClickSelectAddItemColor(ActionEvent event) {
        String s= SelectAddItemColor.getValue();
        switch (s)
        {
            case "pink":
            {
                addItemToSys.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                addItemToSys.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                addItemToSys.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                addItemToSys.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                addItemToSys.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                addItemToSys.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                addItemToSys.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                addItemToSys.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                addItemToSys.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectColorAddStore(ActionEvent event) {
        String s=SelectColorAddStore.getValue();
        switch (s)
        {
            case "pink":
            {
                AddStore.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                AddStore.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                AddStore.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                AddStore.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                AddStore.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                AddStore.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                AddStore.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                AddStore.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                AddStore.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectColorHistoryOrd(ActionEvent event) {
        String s=SelectColorHistorOrder.getValue();
        switch (s)
        {
            case "pink":
            {
                Historyorders.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                Historyorders.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                Historyorders.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                Historyorders.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                Historyorders.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                Historyorders.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                Historyorders.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                Historyorders.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                Historyorders.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectColorItem(ActionEvent event) {
        String s=SelectColorItems.getValue();
        switch (s)
        {
            case "pink":
            {
                ListItems.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                ListItems.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                ListItems.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                ListItems.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                ListItems.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                ListItems.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                ListItems.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                ListItems.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                ListItems.setStyle("-fx-background-color: gray");
                break;
            }
        }


    }

    @FXML
    void ClickSelectColorMap(ActionEvent event) {
        String s=SelectColorMap.getValue();
        switch (s)
        {
            case "pink":
            {
                MapOfSystem.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                MapOfSystem.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                MapOfSystem.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                MapOfSystem.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                MapOfSystem.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                MapOfSystem.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                MapOfSystem.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                MapOfSystem.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                MapOfSystem.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectColorOrder(ActionEvent event) {
        String s=SelectColorOrder.getValue();
        switch (s)
        {
            case "pink":
            {
                ClickMakeOrder.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                ClickMakeOrder.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                ClickMakeOrder.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                ClickMakeOrder.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                ClickMakeOrder.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                ClickMakeOrder.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                ClickMakeOrder.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                ClickMakeOrder.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                ClickMakeOrder.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectColorStores(ActionEvent event) {
        String s=SelectColorStores.getValue();
        switch (s)
        {
            case "pink":
            {
                ListStores.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                ListStores.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                ListStores.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                ListStores.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                ListStores.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                ListStores.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                ListStores.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                ListStores.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                ListStores.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectCustColor(ActionEvent event) {
        String s=selectcolorCust.getValue();
        switch (s)
        {
            case "pink":
            {
                ListOfCostumers.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                ListOfCostumers.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                ListOfCostumers.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                ListOfCostumers.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                ListOfCostumers.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                ListOfCostumers.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                ListOfCostumers.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                ListOfCostumers.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                ListOfCostumers.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectDiscColor(ActionEvent event) {
        String s=SelectAddDiscountColor.getValue();
        switch (s)
        {
            case "pink":
            {
                selectAddDiscount.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                selectAddDiscount.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                selectAddDiscount.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                selectAddDiscount.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                selectAddDiscount.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                selectAddDiscount.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                selectAddDiscount.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                selectAddDiscount.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                selectAddDiscount.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }
    @FXML
    void ClickSElectItAndStoresColor(ActionEvent event) {
        String s=SelectColorItemsAndStores.getValue();
        switch (s)
        {
            case "pink":
            {
                ClickUpdateItems.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                ClickUpdateItems.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                ClickUpdateItems.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                ClickUpdateItems.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                ClickUpdateItems.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                ClickUpdateItems.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                ClickUpdateItems.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                ClickUpdateItems.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                ClickUpdateItems.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }

    @FXML
    void ClickSelectColorScene(ActionEvent event) {
        String s=selectColorScene.getValue();
        switch (s)
        {
            case "pink":
            {
                SceneApp.setStyle("-fx-background-color: pink");
                break;

            }
            case "brown":
            {
                SceneApp.setStyle("-fx-background-color: brown");
                break;
            }
            case "white":
            {
                SceneApp.setStyle("-fx-background-color: white");
                break;
            }
            case "purper":
            {
                SceneApp.setStyle("-fx-background-color: PURPLE");
                break;
            }
            case "orange":
            {
                SceneApp.setStyle("-fx-background-color: ORANGE");
                break;
            }
            case "yellow":
            {
                SceneApp.setStyle("-fx-background-color: yellow");
                break;
            }
            case "red":
            {
                SceneApp.setStyle("-fx-background-color: red");
                break;
            }
            case "blue":
            {
                SceneApp.setStyle("-fx-background-color: blue");
                break;
            }
            case "grey":
            {
                SceneApp.setStyle("-fx-background-color: gray");
                break;
            }
        }

    }



    }

