import java.util.ArrayList;

public class factoryMenu {

    public InterfaceshowMr create(int x) {
        InterfaceshowMr showmenu=null;
        switch (x) {
            case 1: {
                showmenu = new showMenu1();
                break;
            }
            case 2: {
                showmenu = new loadxmlfile();
                break;
            }
            case 3: {
                showmenu = new selectstoretoorder();
                break;
            }
            case 4: {
                showmenu = new dateSelectToOrder();
                break;
            }
            case 5: {
                showmenu = new cordinatosMenu();
                break;
            }
            case 6: {
                showmenu = new selectIdofItemToOrder();
                break;
            }
            case 7: {
                showmenu = new tapidofitem();
                break;
            }
            case 8: {
                showmenu = new selectpriveaccordingamount();
                break;
            }
            case 9: {
                showmenu = new selectweightitem();
                break;
            }
            case 10:
            {
                showmenu=new ApprovalOrderForSending();
                break;
            }
            case 11:
            {
                showmenu=new dateSelectDinamyOrder();
                break;
            }
            case 12:
            {
                showmenu=new cordinatosOfDinamyOrder();
                break;
            }
            case 13:
            {
                showmenu=new continueItemOrNotdinamy();
                break;
            }
            case 14:
            {
                showmenu=new idItemToDinamyOrder();
                break;
            }
            case 15:
            {
                showmenu=new ApprovedinamyOrder();
                break;
            }

            case 16:
            {
                showmenu=new selectIdOfStoreYouWantToUpdate();
                break;
            }
            case 17:
            {
                showmenu=new selectidOfItemThatyouWantToUpdate();
                break;
            }
            case 18:
            {
                showmenu=new selectnumberidtoupdateitem();
                break;
            }
            case 19:
            {
                showmenu=new tappriceupdateItemInStore();
                break;
            }


        }
return showmenu;
    }
}