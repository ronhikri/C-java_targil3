package ShowItemsInStores;

import clasinEx.PrintCostomerInSystem;
import clasinEx.classManeger;
import clasinEx.itemInStore;
import clasinEx.store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerShowItemsStore {
private classManeger obj;


    public ControllerShowItemsStore()
    {

    }
    public  void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public void fillCombiox()
    {
        for(store s:obj.getStores().getStoress())
        {
            String str=String.format("%d",s.getId())+","+s.getName();
            ListStores.getItems().add(str);
        }
    }


    @FXML
    private ComboBox<String> ListStores;

    @FXML
    private TableView<itemInStore> TableItemsInStore;

    @FXML
    private TableColumn<itemInStore, Integer> iditem;

    @FXML
    private TableColumn<itemInStore, String> NameItem;

    @FXML
    private TableColumn<itemInStore, String> WayBuyItem;

    @FXML
    private TableColumn<itemInStore,Double> PriceUnitItem;

    @FXML
    private TableColumn<itemInStore, Double> SumItemsSold;

    @FXML
    void ClickIStore(ActionEvent event) {
        String s=ListStores.getValue();
        int index=s.indexOf(',');
        String str=s.substring(0,index);
        int id=Integer.parseInt(str);
        ArrayList<itemInStore>itemsStore=obj.createItemsInStore(id);
        ObservableList<itemInStore>data= FXCollections.observableArrayList();
        for(int i=0;i<itemsStore.size();i++)
            data.add(itemsStore.get(i));
        iditem.setCellValueFactory(new PropertyValueFactory<>("idOfItem"));
        NameItem.setCellValueFactory(new PropertyValueFactory<>("nameOfItem"));
        WayBuyItem.setCellValueFactory(new PropertyValueFactory<>("howToBuy"));
        PriceUnitItem.setCellValueFactory(new PropertyValueFactory<>("priceUnitOfItem"));
        SumItemsSold.setCellValueFactory(new PropertyValueFactory<>("SUMitemSold"));
        TableItemsInStore.setItems(data);

    }
}
