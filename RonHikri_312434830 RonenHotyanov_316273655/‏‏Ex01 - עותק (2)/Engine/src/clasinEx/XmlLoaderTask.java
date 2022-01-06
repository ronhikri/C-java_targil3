package clasinEx;

import clasinEx.FileXml;
import exceptions.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import clasinEx.classManeger;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

public class XmlLoaderTask  extends Task<Boolean> {
    private final String path;
    private Consumer<classManeger> obj;
    private Consumer<SimpleBooleanProperty> isxmlLoaded;
    private SimpleBooleanProperty loadedy;

    public XmlLoaderTask(String path, Consumer<classManeger> obj,Consumer<SimpleBooleanProperty> isxmlloader)   {
        this.path = path;
        this.obj = obj;
        this.isxmlLoaded=isxmlloader;
        loadedy=new SimpleBooleanProperty(true);

    }
    public void setIsxmlLoaded()
    {

    }

    @Override
    protected Boolean call() throws Exception {
        updateProgress(0, 1);

        updateMessage("Starts to load xml");
        FileXml file = new FileXml();
        file.setFileName(path);
        classManeger obji = file.fileToGame();
        try {
            file.checkIdSame(obji);
            Thread.sleep(150);
            updateProgress(0.1, 1);
            file.checkExistallstores(obji);
            Thread.sleep(150);
            updateProgress(0.2, 1);
            file.checkitemsallnotsell(obji);
            Thread.sleep(150);
            updateProgress(0.3, 1);
            file.checkitemsnotsellmoretimeinallstores(obji);
            Thread.sleep(150);
            updateProgress(0.4, 1);
            file.checkallstoresnotlocation(obji);
            Thread.sleep(150);
            updateProgress(0.5, 1);
            file.checkSameocationinStores(obji);
            Thread.sleep(150);
            updateProgress(0.6, 1);
            file.checkIfHasCustomersWithSameId(obji);
            Thread.sleep(150);
            updateProgress(0.7, 1);
            file.checkIfHaCustomersWithSameLocation(obji);
            Thread.sleep(150);
            updateProgress(0.8, 1);
            file.checkOfferThatNotSoldInStore(obji);
            Thread.sleep(150);
            updateProgress(0.9, 1);
            file.chreckOfferNotFoundInFile(obji);
            Thread.sleep(150);
            updateProgress(1, 1);
            // this.obj = obji;
            obj.accept(obji);
            isxmlLoaded.accept(loadedy);

        } catch (idsameitemsorstoresexceptions e) {
            updateMessage(e.create());
            obj.accept(null);

        } catch (itemnotexitinrefexception e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        } catch (itemthatnotsellexception e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;

        } catch (itemsellmoreoneinstoreexception e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        } catch (locationofsoreexcept e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        } catch (sameLocationinStores e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        } catch (checksamecustomers e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        } catch (checkCustomersSmeLocation e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        } catch (offerThatNotSoldInStore e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        } catch (offersthatnotFound e) {
            updateMessage(e.create());
            obj.accept(null);
            obji=null;
        }


        Thread.sleep(150);
        updateProgress(1, 1);
        updateMessage("The load xml is successed");
        return false;
    }

}
