import clasinEx.*;
import exceptions.*;
import exceptions.tryadditemthatsoldinstore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UiManage {
    static classManeger obj = null;
    static boolean exitFromApplication = false;
    static int countOrder = 0;
    boolean staticOrder;
    Scanner scanner = new Scanner(System.in);

    public void showMenu(classManeger obj) {
        while (exitFromApplication == false) {
            shoeReflactionMenu(1);
            String st = scanner.nextLine();
            st.toLowerCase();
            char c = st.charAt(0);
            try {

                switch (c) {
                    case '1': {
                        loadFromXml(obj);
                        break;
                    }
                    case '2': {
                        printStores(obj);
                        break;
                    }
                    case '3': {
                      ///  printItems(obj);
                        break;
                    }
                    case '4': {
                        MakeIDofStoreorder(obj);
                        break;
                    }
                    case '5': {
                        MakedateforDinamyOrder(obj);
                    }
                    case '6': {
                        printListOrders(obj);
                        break;
                    }
                    case '7': {
                        Updateitem(obj);
                        break;
                    }
                    case '8': {
                        loadDatatoFile(obj);
                        break;
                    }
                    case '9': {
                        loadDataFrmFile(obj);
                        break;
                    }
                    case 'q': {
                        exitFromApplication = true;
                        break;
                    }
                    case 'Q': {
                        exitFromApplication = true;
                        break;
                    }
                    default: {
                        System.out.println("please select a character according to instructions ");
                    }
                }
            } catch (IllegalFormatException e) {
                System.out.println("tap legal character please according to instructions");


            }

        }
    }

    public void shoeReflactionMenu(int x) {
        factoryMenu factory = new factoryMenu();
        InterfaceshowMr menu = factory.create(x);
        menu.printMenu();

    }

    public void loadFromXml(classManeger obj) {
        obj = null;
        countOrder = 0;
        shoeReflactionMenu(2);
        try {
            String path = scanner.nextLine();
            path.toLowerCase();
            FileXml file = new FileXml();
            file.setFileName(path);
            if (!(file.check(path))) {
                System.out.println("The file not exist or not xml format");
                showMenu(obj);
            } else {
                obj = file.fileToGame();
                try {
                    file.checkIdSame(obj);
                    file.checkExistallstores(obj);
                    file.checkitemsallnotsell(obj);
                    file.checkitemsnotsellmoretimeinallstores(obj);
                    file.checkallstoresnotlocation(obj);
                    file.checkSameocationinStores(obj);
                    showMenu(obj);


                } catch (idsameitemsorstoresexceptions e) {
                    e.print();
                    obj = null;
                    showMenu(obj);
                } catch (itemnotexitinrefexception e) {
                    e.print();
                    obj = null;
                    showMenu(obj);
                } catch (itemthatnotsellexception e) {
                    e.print();
                    obj = null;
                    showMenu(obj);
                } catch (itemsellmoreoneinstoreexception e) {
                    e.print();
                    obj = null;
                    showMenu(obj);
                } catch (locationofsoreexcept e) {
                    e.print();
                    obj = null;
                    showMenu(obj);
                } catch (sameLocationinStores e) {
                    e.print();
                    obj = null;
                    showMenu(obj);
                }
            }

        } catch (IllegalFormatException e) {
            System.out.println("please select string that indicate the path of xml file");
            obj = null;
            showMenu(obj);
        }
    }

    public void printStores(classManeger obj) {
        try {
            obj.printStores();
            showMenu(obj);
        } catch (NullPointerException e) {
            System.out.println("please lload rom file");
            showMenu(obj);
        }

    }

  /*/  public void printItems(classManeger obj) {
        try {
            obj.printItems();
            showMenu(obj);
        } catch (NullPointerException e) {
            System.out.println("please first loaf xml file");
            showMenu(obj);
        }
    }/*/

    public void MakeIDofStoreorder(classManeger obj) {
        if (obj == null) {
            System.out.println("First load data from xml file");
            showMenu(obj);
        }
        obj.printStoreBeforeOrder();
        boolean fixidofstore = false;
        while (fixidofstore == false) {
            shoeReflactionMenu(3);
            try {
                String st = scanner.nextLine();
                int id = Integer.parseInt(st);
                fixidofstore = obj.Storeretbool(id);
                if (fixidofstore)
                    MakeDateOrder(obj, id);


            } catch (IdOfStoreNotFound e) {
                e.print();
                fixidofstore = false;
            } catch (NumberFormatException e) {
                System.out.println("please tap fix id of store");
                fixidofstore = false;

            } catch (NullPointerException e) {
                System.out.println("please load xml file");
                showMenu(obj);
            }

        }

    }

    public void MakeDateOrder(classManeger obj, int idofstore) {
        boolean fixdate = false;
        while (fixdate == false) {
            shoeReflactionMenu(4);
            String date1 = scanner.nextLine();
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
                fixdate = true;
                MakeLOcation(obj, idofstore, date);

            } catch (ParseException e) {
                System.out.println("The date that selected not fix, please select fix date");
                fixdate = false;
            }

        }
    }

    public void MakeLOcation(classManeger obj, int idofstore, Date date) {
        boolean fixlocation = false;
        while (fixlocation == false) {
            shoeReflactionMenu(5);
            try {
                String st1 = scanner.nextLine();
                int x = Integer.parseInt(st1);
                String st2 = scanner.nextLine();
                int y = Integer.parseInt(st2);
                obj.checkLOcationNotExceed(x, y);
                obj.checkLocationFix(x, y);
                obj.initiall();
                int countitems = 0;
                obj.printItemsBeforeOrder(idofstore);
                MakeItemsToOrder(obj, idofstore, date, x, y, countitems);
            } catch (LocationNotFixOfUser e) {
                e.print();
                fixlocation = false;
            } catch (IllegalFormatException e) {
                System.out.println("tap two postive numbers please");
                fixlocation = false;
            }
        }
    }

    public void MakeItemsToOrder(classManeger obj, int idofstore, Date date, int x, int y, int countitems) {
        boolean fixtavforidOfItem = false;
        while (fixtavforidOfItem == false) {
            shoeReflactionMenu(6);
            String st = scanner.nextLine();


            try {
                char c = st.charAt(0);
                Character.toLowerCase(c);
                switch (c) {
                    case 'a': {
                        fixtavforidOfItem = true;
                        MakeItenOrder(obj, idofstore, date, x, y, countitems);
                        break;
                    }
                    case 'A': {
                        fixtavforidOfItem = true;
                        MakeItenOrder(obj, idofstore, date, x, y, countitems);
                        break;
                    }
                    case 'q': {
                        fixtavforidOfItem = true;
                        MakeApproveOrder(obj, date, idofstore, x, y, countitems);
                        break;


                    }
                    case 'Q': {
                        fixtavforidOfItem = true;
                        MakeApproveOrder(obj, date, idofstore, x, y, countitems);
                        break;

                    }
                    default: {
                        System.out.println("please select tav from in instructions");
                        fixtavforidOfItem = false;
                        break;
                    }

                }


            } catch (IllegalFormatException e) {
                System.out.println("The tav not fix");
                fixtavforidOfItem = false;
            }
        }

    }

    public void MakeItenOrder(classManeger obj, int idofstore, Date date, int x, int y, int countitems) {
        staticOrder = true;
        boolean fixIdOfItem = false;
        while (fixIdOfItem == false) {
            shoeReflactionMenu(7);
            try {
                String st = scanner.nextLine();
                int idOItem = Integer.parseInt(st);
                obj.searchitem(idOItem);
                obj.idofitemfoundinstore(idofstore, idOItem);
                fixIdOfItem = true;
                MakeCountOfItem(obj, idofstore, idOItem, date, x, y, countitems, staticOrder);

            } catch (IdOfStoreNotFound e) {
                e.print();
                fixIdOfItem = true;
            } catch (IdOfItemNotFound e) {
                e.print();
                fixIdOfItem = false;
            } catch (NumberFormatException e) {
                System.out.println();
                fixIdOfItem = false;
            }
        }


    }

    public void MakeCountOfItem(classManeger obj, int idofstore, int idofitem, Date date, int x, int y, int countitems, boolean s_order) {
        boolean fixCoiuntItem = false;
        String str = obj.howToBuy(idofitem);
        while (fixCoiuntItem == false) {
            try {
                if (str.charAt(0) == 'Q') {
                    shoeReflactionMenu(8);
                    String input = scanner.nextLine();
                    int countItem = Integer.parseInt(input);
                    fixCoiuntItem = true;
                    if (s_order == true)
                        obj.addToListOrderItem(idofstore, idofitem, (double) countItem);
                    else
                        obj.AddListItemdinamyOrder(idofitem, idofstore, countItem);
                    countitems++;
                    if (s_order)
                        MakeItemsToOrder(obj, idofstore, date, x, y, countitems);
                    else
                        MakeItemsToOrderdinamy(obj, date, x, y, countitems);
                }
                if (str.charAt(0) == 'W') {
                    shoeReflactionMenu(9);
                    String inputstring = scanner.nextLine();
                    double counItem = Double.parseDouble(inputstring);
                    fixCoiuntItem = true;
                    if (s_order == true)
                        obj.addToListOrderItem(idofstore, idofitem, counItem);
                    else
                        obj.AddListItemdinamyOrder(idofitem, idofstore, counItem);
                    countitems++;
                    if (s_order)
                        MakeItemsToOrder(obj, idofstore, date, x, y, countitems);
                    else
                        MakeItemsToOrderdinamy(obj, date, x, y, countitems);
                }
            } catch (IdOfStoreNotFound e) {
                e.print();
                fixCoiuntItem = false;
            } catch (IdOfItemNotFound e) {
                e.print();
                fixCoiuntItem = false;
            } catch (IllegalFormatException e) {
                System.out.println("please select number");
                fixCoiuntItem = false;
            } catch (InputMismatchException e) {
                System.out.println("please select number");
                fixCoiuntItem = false;
            }
        }
    }


    public void MakeApproveOrder(classManeger obj, Date date, int idOfStore, int x, int y, int countofitems) {
        boolean ApproveOrNot = false;
        while (ApproveOrNot == false) {
            shoeReflactionMenu(10);
            String st = scanner.nextLine();
            char c = st.charAt(0);
            Character.toLowerCase(c);
            try {
                switch (c) {
                    case 'y': {
                        ApproveOrNot = true;
                        MakeOrder(obj, date, idOfStore, x, y, countofitems);
                        break;


                    }
                    case 'Y': {
                        ApproveOrNot = true;
                        MakeOrder(obj, date, idOfStore, x, y, countofitems);
                        break;
                    }
                    case 'n': {
                        ApproveOrNot = true;
                        showMenu(obj);
                        break;
                    }
                    case 'N': {
                        ApproveOrNot = true;
                        showMenu(obj);
                        break;
                    }
                    default: {
                        System.out.println("select y or n");
                        ApproveOrNot = false;
                        break;
                    }
                }
            } catch (IllegalFormatException e) {
                System.out.println("Select y or n");
                ApproveOrNot = false;
            }

        }
    }

    public void MakeOrder(classManeger obj, Date date, int idofstore, int x, int y, int countofitems) {
        if (countofitems == 0) {
            System.out.println("impossible to send order because you didnt select items");
            MakeItemsToOrder(obj, idofstore, date, x, y, countofitems);
        }/* else {
            try {
                countOrder++;
                obj.updateOrder(date, x, y, idofstore, countOrder);
                showMenu(obj);
            } catch (IdOfStoreNotFound e) {
                e.print();
                showMenu(obj);
            } catch (LocationNotFixOfUser e) {
                e.print();
                showMenu(obj);
            }
        }*/
    }

    public void printListOrders(classManeger obj) {
        try {
            obj.PrintOrders();
            showMenu(obj);
        } catch (NullPointerException e) {
            System.out.println("pleae load xml file");
            showMenu(obj);
        }
    }

    public void MakedateforDinamyOrder(classManeger obj) {
        boolean fixdate = false;
        while (fixdate == false) {
            shoeReflactionMenu(11);
            String date1 = scanner.nextLine();
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
                fixdate = true;
                MakeLOcationDinamyOrder(obj, date);

            } catch (ParseException e) {
                System.out.println("The date that selected not fix, please select fix date");
                fixdate = false;
            } catch (NullPointerException e) {
                System.out.println("please load xml file");
                showMenu(obj);
            }

        }
    }

    public void MakeLOcationDinamyOrder(classManeger obj, Date date) {
        boolean fixlocation = false;
        while (fixlocation == false) {
            shoeReflactionMenu(12);
            try {
                String st1 = scanner.nextLine();
                int x = Integer.parseInt(st1);
                String st2 = scanner.nextLine();
                int y = Integer.parseInt(st2);
                obj.checkLOcationNotExceed(x, y);
                obj.checkLocationFix(x, y);
                obj.initiall2();
                int countitems = 0;

                MakeItemsToOrderdinamy(obj, date, x, y, countitems);
            } catch (LocationNotFixOfUser e) {
                e.print();
                fixlocation = false;
            } catch (IllegalFormatException e) {
                System.out.println("tap two postive numbers please");
                fixlocation = false;
            }
        }
    }

    public void MakeItemsToOrderdinamy(classManeger obj, Date date, int x, int y, int countitems) {
        boolean fixtavforidOfItem = false;
        while (fixtavforidOfItem == false) {
            shoeReflactionMenu(13);
            String st = scanner.nextLine();


            try {
                st.toLowerCase();
                switch (st) {
                    case "a": {
                        fixtavforidOfItem = true;
                        MakeItenOrderdinamy(obj, date, x, y, countitems);
                        break;
                    }
                    case "A": {
                        fixtavforidOfItem = true;
                        MakeItenOrderdinamy(obj, date, x, y, countitems);
                        break;
                    }
                    case "q": {
                        fixtavforidOfItem = true;
                        MakeApproveOrderDinamy(obj, date, x, y, countitems);
                        break;


                    }
                    case "Q": {
                        fixtavforidOfItem = true;
                        MakeApproveOrderDinamy(obj, date, x, y, countitems);
                        break;
                    }
                    default: {
                        System.out.println("please select tav from in instructions");
                        fixtavforidOfItem = false;
                        break;
                    }

                }

            } catch (IllegalFormatException e) {
                System.out.println("The tav not fix");
                fixtavforidOfItem = false;
            }
        }
    }

    public void MakeItenOrderdinamy(classManeger obj, Date date, int x, int y, int countitems) {
        staticOrder = false;
        boolean fixIdOfItem = false;
        while (fixIdOfItem == false) {
            shoeReflactionMenu(14);
            try {
                String st = scanner.nextLine();
                int idOItem = Integer.parseInt(st);
                obj.searchitem(idOItem);
                int idofstore = obj.idOfStoreItemMinimumPrice(idOItem);
                fixIdOfItem = true;
                MakeCountOfItem(obj, idofstore, idOItem, date, x, y, countitems, staticOrder);

            } catch (IdOfItemNotFound e) {
                e.print();
                fixIdOfItem = false;
            } catch (NumberFormatException e) {
                System.out.println();
                fixIdOfItem = false;
            }
        }

    }

    public void MakeApproveOrderDinamy(classManeger obj, Date date, int x, int y, int countitems) {
        boolean ApproveOrNot = false;
        while (ApproveOrNot == false) {
            shoeReflactionMenu(15);
            String st = scanner.nextLine();
            char c = st.charAt(0);
            Character.toLowerCase(c);
            try {
                switch (c) {
                    case 'y': {
                        ApproveOrNot = true;
                        MakeOrderDinamy(obj, date, x, y, countitems);
                        break;


                    }
                    case 'Y': {
                        ApproveOrNot = true;
                        MakeOrderDinamy(obj, date, x, y, countitems);
                        break;
                    }
                    case 'n': {
                        ApproveOrNot = true;
                        showMenu(obj);
                        break;
                    }
                    case 'N': {
                        ApproveOrNot = true;
                        showMenu(obj);
                        break;
                    }
                    default: {
                        System.out.println("select y or n");
                        ApproveOrNot = false;
                        break;
                    }
                }
            } catch (IllegalFormatException e) {
                System.out.println("Select y or n");
                ApproveOrNot = false;
            }

        }
    }

    public void MakeOrderDinamy(classManeger obj, Date date, int x, int y, int countitems) {
        if (countitems == 0) {
            System.out.println("impossible to send order because you didnt select items");
            MakeItemsToOrderdinamy(obj, date, x, y, countitems);
        } /*else {
            try {
                countOrder++;
            //    obj.UpdateDinamyOrfder(date, x, y, countOrder);
                showMenu(obj);

            } catch (LocationNotFixOfUser e) {
                e.print();
                showMenu(obj);
            }
        }*/
    }

    public void Updateitem(classManeger obj) {
        boolean foundfixstore = false;
        while (!foundfixstore) {
            try {
                shoeReflactionMenu(16);
                String st = scanner.nextLine();
                int id = Integer.parseInt(st);
                obj.Storeret(id);
                foundfixstore = true;
                UpdateTapItem(obj, id);
            } catch (NullPointerException e) {
                System.out.println("first to load xml file");
                showMenu(obj);
            } catch (IllegalFormatException e) {
                System.out.println("tap please fix id of store");
                foundfixstore = false;
            } catch (IdOfStoreNotFound e) {
                e.print();
                foundfixstore = false;
            }

        }

    }

    public void UpdateTapItem(classManeger obj, int idStore) {
        boolean foundfixitem = false;
        while (!foundfixitem) {
            try {
                shoeReflactionMenu(17);
                String st = scanner.nextLine();
                char c = st.charAt(0);
                Character.toLowerCase(c);
                switch (c) {
                    case 'a': {
                        int x = 1;
                        selectitemupdate(obj, idStore, x);
                        break;
                    }
                    case 'A': {
                        int x = 1;
                        selectitemupdate(obj, idStore, x);
                        break;
                    }
                    case 'b': {
                        int x = 2;
                        selectitemupdate(obj, idStore, 2);
                        break;

                    }
                    case 'B': {
                        int x = 2;
                        selectitemupdate(obj, idStore, 2);
                        break;
                    }
                    case 'c': {
                        int x = 3;
                        selectitemupdate(obj, idStore, 3);
                        break;

                    }
                    case 'C': {
                        int x = 3;
                        selectitemupdate(obj, idStore, 3);
                        break;
                    }
                    default: {
                        System.out.println("please tap according to instructions please");
                        foundfixitem = false;
                    }
                }
            } catch (IllegalFormatException e) {
                System.out.println("please select fix charactr according to instructions");
                foundfixitem = false;
            }
        }
    }

    public void selectitemupdate(classManeger obj, int idofstore, int x) {
        boolean fixitem = false;
        while (!fixitem) {
            try {
                shoeReflactionMenu(18);
                String st = scanner.nextLine();
                int idofitem = Integer.parseInt(st);
                if(x==1)
                {
                    obj.legalcheckAddItemToStore(idofstore,idofitem);
                    fixitem=true;
                }
                if(x==3) {
                    obj.idofitemfoundinstore(idofstore, idofitem);
                    fixitem = true;
                }
                if (x == 2) {
                    RemoveitemInStore(obj, idofstore, idofitem);
                } else {
                    SelectPrice(obj, idofstore, idofitem, x);
                }

            }
            catch (tryadditemthatsoldinstore e)
            {
                e.print();
                showMenu(obj);
            }
            catch (IdOfItemNotFound e) {
                e.print();
                fixitem = false;
            } catch (IdOfStoreNotFound e) {
                e.print();
                fixitem = false;
            } catch (IllegalFormatException e) {
                System.out.println("please select number that indicate id of item that found in the store");
                fixitem = false;
            }
        }
    }

    public void SelectPrice(classManeger obj, int idofstore, int idofitem, int x) {
        boolean fixprice = false;
        while (!fixprice) {
            shoeReflactionMenu(19);
            try {
                String st = scanner.nextLine();
                double price = Double.parseDouble(st);
                if (x == 1) {
                    obj.Additemtostore(idofstore, idofitem, price);
                    showMenu(obj);
                }
                if (x == 3) {
                    obj.updateprice(idofstore, idofitem, price);
                    showMenu(obj);
                }
            } catch (IdOfStoreNotFound e) {
                e.print();
               Updateitem(obj);
            } catch (IdOfItemNotFound e) {
                e.print();
                fixprice = false;
                Updateitem(obj);
            } catch (tryadditemthatsoldinstore e) {
                e.print();
                fixprice = false;
               showMenu(obj);
            } catch (IllegalFormatException e) {
                System.out.println("please select number to indicate price item");
                fixprice = false;
                showMenu(obj);
            }
        }
    }

    public void RemoveitemInStore(classManeger obj, int idofstore, int idofitem) {
        try {
            obj.RemoveItem(idofstore, idofitem);
            showMenu(obj);
        } catch (IdOfStoreNotFound e) {
            e.print();
            showMenu(obj);
        } catch (IdOfItemNotFound e) {
            e.print();
            showMenu(obj);
        } catch (impossiletoremoveitem e) {
            e.print();
            showMenu(obj);
        }
    }

    public void loadDatatoFile(classManeger obj) {
        System.out.println("please select path file to bring data to file");
        Path path = Paths.get(scanner.nextLine());
        if (!Files.exists(path)) {
            System.out.println("The file not exist");
        } else {
            try {
                obj.WriteDataToFile(path);
                showMenu(obj);

            } catch (NullPointerException e) {
                System.out.println("first load from xml file");
                showMenu(obj);
            } catch (IllegalFormatException e) {
                System.out.println("please tap path to file");
            } catch (FileNotFoundException e) {
                System.out.println("sorry not found the file");
                showMenu(obj);
            } catch (IOException e) {
                System.out.println("sorry fails to send data to file");
                showMenu(obj);
            }
        }
    }

    public void loadDataFrmFile(classManeger obj) {
        System.out.println("This operation may change Listorders and DinmayListOrders in system, select y if you want or n");
        String select = scanner.nextLine();
        char c = select.charAt(0);
        if ((c == 'n') || (c == 'N'))
            showMenu(obj);
        else {
            if ((c == 'y') || (c == 'Y')) {
                boolean fixpath = false;
                System.out.println("please you give a path to file you give to load data to file due to to load data from file");
                Path path = Paths.get(scanner.nextLine());
                if (!Files.exists(path)) {
                    System.out.println("The file not exist");
                    showMenu(obj);
                }
                 else {
                    try {
                        obj.ReadDataFromFile(path);
                        showMenu(obj);
                    } catch (NullPointerException e) {
                        System.out.println("please load from xml file");
                        showMenu(obj);
                    } catch (IllegalFormatException e) {
                        System.out.println("please tap path to file");
                        fixpath = false;
                    } catch (FileNotFoundException e) {
                        System.out.println("sorry the file is not found");
                        showMenu(obj);
                    } catch (IOException e) {
                        System.out.println("sorry fail to read from file");
                        showMenu(obj);
                    } catch (ClassNotFoundException e) {
                        System.out.println("sorry not succss to convert from file to class");
                        showMenu(obj);
                    }
                }
            }
            else
            {
                System.out.println("you should to select according to instruction");
                showMenu(obj);
            }
        }
    }
}