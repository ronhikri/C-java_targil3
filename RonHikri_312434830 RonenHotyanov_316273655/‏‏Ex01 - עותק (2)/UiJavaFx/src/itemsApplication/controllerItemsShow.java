package itemsApplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.DoubleBinaryOperator;

import clasinEx.classManeger;
import clasinEx.printItemsInSystem;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.naming.ldap.PagedResultsControl;

public class controllerItemsShow {
    public controllerItemsShow()
    {

    }
    public void voidFillTable(classManeger obj)
    {
        ObservableList<printItemsInSystem>data= FXCollections.observableArrayList();
        ArrayList<printItemsInSystem>itemsInSystem=obj.CreateItemsInSystem();
        for(int i=0;i<itemsInSystem.size();i++)
        {
            data.add(itemsInSystem.get(i));
        }
        id.setCellValueFactory(new PropertyValueFactory<printItemsInSystem,Integer>("idofItem"));
        name.setCellValueFactory(new PropertyValueFactory<printItemsInSystem,String>("nameitem"));
        wayToBuyItem.setCellValueFactory(new PropertyValueFactory<printItemsInSystem,String>("buyitem"));
        numberstoresthatsolditem.setCellValueFactory(new PropertyValueFactory<printItemsInSystem,Integer>("countitemsStores"));
        PriceItemAvg.setCellValueFactory(new PropertyValueFactory<printItemsInSystem,Double>("avgpriceofitem"));
        CountSoldInSystem.setCellValueFactory(new PropertyValueFactory<printItemsInSystem,Double>("countItemsInOrders"));
        TableItems.setItems(data);
    }



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<printItemsInSystem> TableItems;

    @FXML
    private TableColumn<printItemsInSystem, Integer> id;

    @FXML
    private TableColumn<printItemsInSystem, String> name;

    @FXML
    private TableColumn<printItemsInSystem, String> wayToBuyItem;

    @FXML
    private TableColumn<printItemsInSystem, Integer> numberstoresthatsolditem;

    @FXML
    private TableColumn<printItemsInSystem, Double> PriceItemAvg;

    @FXML
    private TableColumn<printItemsInSystem, Double> CountSoldInSystem;


}
