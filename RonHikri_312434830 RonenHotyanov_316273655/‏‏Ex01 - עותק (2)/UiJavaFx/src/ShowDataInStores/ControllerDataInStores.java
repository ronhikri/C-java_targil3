package ShowDataInStores;

import clasinEx.ShowStores;
import clasinEx.classManeger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerDataInStores {
    private classManeger obj;
    private Stage primaryStage;

    public void setObj(classManeger obji)
    {
        this.obj=obji;
    }
    public  void setPrimaryStage(Stage value)
    {
        this.primaryStage=value;
    }

    public ControllerDataInStores()
    {

    }

    @FXML
    private TableView<ShowStores> TableStores;

    @FXML
    private TableColumn<ShowStores, Integer> id;

    @FXML
    private TableColumn<ShowStores, String> name;

    @FXML
    private TableColumn<ShowStores,Integer> ppk;

    @FXML
    private TableColumn<ShowStores, Double> sumsend;

    public void fillTable()
    {
        ArrayList<ShowStores>list=obj.createShowStores();
        ObservableList<ShowStores>data= FXCollections.observableArrayList();
        for(ShowStores s:list)
            data.add(s);
        id.setCellValueFactory(new PropertyValueFactory<ShowStores,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ShowStores,String>("name"));
        ppk.setCellValueFactory(new PropertyValueFactory<ShowStores,Integer>("ppk"));
        sumsend.setCellValueFactory(new PropertyValueFactory<ShowStores,Double>("sumsend"));
        TableStores.setItems(data);
    }

}
