package CustomerApplication;
import clasinEx.PrintCostomerInSystem;
import clasinEx.classManeger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class CostomerController {

    public CostomerController()
    {

    }
    public void fillTableCustomer(classManeger obj )
    {
        ObservableList<PrintCostomerInSystem>data= FXCollections.observableArrayList();
        ArrayList<PrintCostomerInSystem>customersinsystem=obj.CreateCustomersInSystem();
        for(int i=0;i<customersinsystem.size();i++)
        {
            data.add(customersinsystem.get(i));
        }
        IdCostomer.setCellValueFactory(new PropertyValueFactory<PrintCostomerInSystem,Integer>("idOfCostomer"));
        nameCostomer.setCellValueFactory(new PropertyValueFactory<PrintCostomerInSystem,String>("NameCostomer"));
        CordinataXCostomer.setCellValueFactory(new PropertyValueFactory<PrintCostomerInSystem,Integer>("CordnataX"));
        CordinataYCostomer.setCellValueFactory(new PropertyValueFactory<PrintCostomerInSystem,Integer>("CordinataY"));
        SumOrdersCostomer.setCellValueFactory(new PropertyValueFactory<PrintCostomerInSystem,Integer>("SumOrders"));
        avgPriceOrderCostomer.setCellValueFactory(new PropertyValueFactory<PrintCostomerInSystem,Double>("avgPriceOrders"));
        avgPrceSendngCostomer.setCellValueFactory(new PropertyValueFactory<PrintCostomerInSystem,Double>("avgSendingOrders"));
        TableCustomers.setItems(data);
    }
    @FXML
    private TableView<PrintCostomerInSystem> TableCustomers;
    @FXML
    private TableColumn<PrintCostomerInSystem, Integer> IdCostomer;

    @FXML
    private TableColumn<PrintCostomerInSystem, String> nameCostomer;

    @FXML
    private TableColumn<PrintCostomerInSystem, Integer> CordinataXCostomer;

    @FXML
    private TableColumn<PrintCostomerInSystem, Integer> CordinataYCostomer;

    @FXML
    private TableColumn<PrintCostomerInSystem, Integer> SumOrdersCostomer;

    @FXML
    private TableColumn<PrintCostomerInSystem, Double> avgPriceOrderCostomer;

    @FXML
    private TableColumn<PrintCostomerInSystem, Double> avgPrceSendngCostomer;

}


