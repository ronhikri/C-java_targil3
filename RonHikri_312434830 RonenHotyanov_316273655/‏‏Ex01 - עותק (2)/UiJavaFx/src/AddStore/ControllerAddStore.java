package AddStore;

import AddItemToStore.ControllerAddItemTostotre;
import clasinEx.classManeger;
import clasinEx.storeToSystem;
import exceptions.idsameitemsorstoresexceptions;
import exceptions.trytoaddLocationInStorethatfound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.lang.model.element.AnnotationMirror;
import java.io.IOException;
import java.net.URL;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;

public class ControllerAddStore {

    private Stage primaryStage;
    private classManeger obj;
    private int idofStore;
    private String nameOfStore;
    private int CordinataXofStore;
    private int CordinataYofStore;
    private int PpkOfStore;

    public ControllerAddStore()
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

    @FXML
    private TextField idStore;

    @FXML
    private TextField nameStore;

    @FXML
    private TextField CordimataX;

    @FXML
    private TextField cordinataY;

    @FXML
    private TextField PPKStore;

    @FXML
    private TextArea exception;

    @FXML
    private Button selectContinue;
    @FXML
    private void initialize()
    {
        exception.setText("Exceptions");
    }

    @FXML
    void ClickContinue(ActionEvent event) {
        try
        {
            exception.setText("");
            String idString=idStore.getText();
            int ID=Integer.parseInt(idString);
            this.idofStore=ID;
            String name=nameStore.getText();
            this.nameOfStore=name;
            String corX=CordimataX.getText();
            int corx=Integer.parseInt(corX);
            this.CordinataXofStore=corx;
            String cotY=cordinataY.getText();
            int cory=Integer.parseInt(cotY);
            this.CordinataYofStore=cory;
            String ppka=PPKStore.getText();
            int ppks=Integer.parseInt(ppka);
            this.PpkOfStore=ppks;
            obj.checkidOfStoreAddFix(this.idofStore,corx,cory);
            storeToSystem st=new storeToSystem();
            st.setIdofStore(this.idofStore);
            st.setNameOfStore(this.nameOfStore);
            st.setCordinataXofStore(this.CordinataXofStore);
            st.setCordinataYofStore(this.CordinataYofStore);
            st.setPpkOfStore(this.PpkOfStore);
            FXMLLoader loader=new FXMLLoader();
            URL  itemToStore=getClass().getResource("/AddItemToStore/AddItemsStore-fxml.fxml");
            loader.setLocation(itemToStore);
            AnchorPane root=loader.load();
            ControllerAddItemTostotre con=loader.getController();
            BorderPane board=(BorderPane)primaryStage.getScene().getRoot();
            con.setPrimaryStag(primaryStage);
            con.setObj(obj);
            con.setSt(st);
            con.fillCombobox();
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
        catch (idsameitemsorstoresexceptions e)
        {
            exception.setText(e.create());
        }
        catch (trytoaddLocationInStorethatfound e)
        {
            e.create();
        }
        catch (IllegalFormatException e)
        {
            exception.setText("please select integer or double");
        }
        catch (NumberFormatException e)
        {
            exception.setText("please select integer or double");
        }
        catch (InputMismatchException e)
        {
            exception.setText("please select integer or double");
        }
        catch (Exception e)
        {
            exception.setText("please select integer or double");
        }


    }

}
