package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.*;
import clasinEx.Notifications.FeedbackNotification.OrderNotification;
import clasinEx.UsersWeb.UserWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try
        {
            boolean LostMoney=false;
          int  countKindItems=0;
            double sumSend=0;
            double costSum=0;
            store s=null;
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            classManeger tempobj = user.searchList(Att.getNameZone());
            UserWeb use=user.searchUser(Att.getUsername());
            if(Att.getSelectorder()==1) {
                tempobj.initiall();
              sumSend =  Att.sumCostStatie(tempobj,Att.getItemtoorder());
                 costSum = Att.CostStatieItems(Att.getItemtoorder());
                 countKindItems=Att.KindItems(Att.getItemtoorder());
                if (use.getUserMoney() < sumSend + costSum)
                    LostMoney = true;
                else {
                    for (itemToOrder it : Att.getItemtoorder()) {
                        tempobj.additemorder(it);
                    }
                    int idorder = user.getIdOrder();
                    idorder = idorder + 1;
                    tempobj.updatetoOrder(Att.getValue(), Att.getIdstore(), Att.getDate(), idorder);
                    user.setIdOrder(idorder);
                    tempobj.initiall();
                    session.setAttribute("Username", Att);
                    use.setFinancialAction(Att.getDate().toString(),sumSend+costSum,0);
                }
            }
            else {
                tempobj.initiall2();
                sumSend = Att.sendCostDinamy(tempobj, Att.getItemsdinamyorder());
                costSum = Att.dinamyCostItems(Att.getItemsdinamyorder());
                countKindItems=Att.getItemsdinamyorder().size();
                if (use.getUserMoney() < sumSend + costSum)
                    LostMoney = true;
                else {
                    for (itemToOrderDinamy it : Att.getItemsdinamyorder()) {
                        tempobj.additemdinamyorder(it);
                    }
                    int idorder = user.getIdOrder();
                    idorder = idorder + 1;
                    tempobj.updateDinamyToOrder(Att.getValue(), Att.getDate(), idorder);
                    user.setIdOrder(idorder);
                    tempobj.initiall2();
                    session.setAttribute("Username", Att);
                    use.setFinancialAction(Att.getDate().toString(),sumSend+costSum,0);

                }
            }
            if(!LostMoney)
            {
                String name="";
                String countkinditems="";
                String sumsend="";
                String costItems="";
                String idorder="";
             if(Att.getSelectorder()==1)
             {
                  countkinditems=String.format("%d",countKindItems);
                 sumsend=String.format("%.2f",sumSend);
                 costItems=String.format("%.2f",costSum);
                 idorder=String.format("%d",user.getIdOrder());
                 for(store st:tempobj.getStores().getStoress())
                 {
                     if(st.getId()==Att.getIdstore())
                     {
                         name=st.getNameStoreManege();
                         break;
                     }
                 }
                 UserWeb usesManege=user.searchUser(name);
                 OrderNotification orderNotification=new OrderNotification(idorder,Att.getUsername(),countkinditems,costItems,sumsend);
                 usesManege.addOrderUpdate(orderNotification);
                 usesManege.setFinancialAction(Att.getDate().toString(),sumSend+costSum,1);
             }
             else {
                 store st = null;
                 customer custom = null;
                 double sumPriceItems = 0;
                 double priceSend = 0;
                 int countKindItemss = 0;
                 int count = 0;
                 int k = 0;
                 String nameMneger = null;
                 for (int i = 0; i < Att.getItemsdinamyorder().size() - 1; i++) {
                     priceSend = 0;
                     count = 0;
                     sumPriceItems = 0;
                     countKindItemss = 0;
                     for (int j = i + 1; j < Att.getItemsdinamyorder().size(); j++) {
                         if (Att.getItemsdinamyorder().get(i).getNameStoreManegerOfItem().equals(Att.getItemsdinamyorder().get(j).getNameStoreManegerOfItem())) {
                             count++;
                         }
                     }
                     if (count == 0) {
                         for (k = 0; k < i; k++) {
                             if (Att.getItemsdinamyorder().get(i).getNameStoreManegerOfItem().equals(Att.getItemsdinamyorder().get(k).getNameStoreManegerOfItem())) {
                                 countKindItemss++;
                                 sumPriceItems = sumPriceItems + Att.getItemsdinamyorder().get(k).getSumPriceItem() + Att.getItemsdinamyorder().get(k).getPricemadeDiscount();
                             }
                         }
                         countKindItemss++;
                         sumPriceItems = sumPriceItems + Att.getItemsdinamyorder().get(i).getSumPriceItem() + Att.getItemsdinamyorder().get(i).getPricemadeDiscount();
                         ArrayList<itemToOrderDinamy> itemss = new ArrayList<>();
                         for (k = 0; k < i; k++) {
                             if (Att.getItemsdinamyorder().get(i).getNameStoreManegerOfItem().equals(Att.getItemsdinamyorder().get(k).getNameStoreManegerOfItem()))
                                 itemss.add(Att.getItemsdinamyorder().get(k));
                         }
                         UserWeb useNamage = user.searchUser(Att.getItemsdinamyorder().get(i).getNameStoreManegerOfItem());
                         itemss.add(Att.getItemsdinamyorder().get(i));
                         priceSend = sendhishbu(Att, tempobj, itemss);
                         String countItemsString = String.format("%d", countKindItemss);
                         String sumsendStr = String.format("%.2f", priceSend);
                         String costItemsStr = String.format("%.2f", sumPriceItems);
                         idorder = String.format("%d", user.getIdOrder());
                         OrderNotification orderNotification = new OrderNotification(idorder, Att.getUsername(), countItemsString, costItemsStr, sumsendStr);
                         useNamage.addOrderUpdate(orderNotification);
                         useNamage.setFinancialAction(Att.getDate().toString(),priceSend+sumPriceItems,1);



                     }
                     count = 0;


                 }
                 countKindItemss = 0;
                 sumPriceItems = 0;
                 int i = Att.getItemsdinamyorder().size() - 1;
                 ArrayList<itemToOrderDinamy> itemms = new ArrayList<>();
                 for (int j = 0; j < i; j++) {
                     if (Att.getItemsdinamyorder().get(i).getNameStoreManegerOfItem().equals(Att.getItemsdinamyorder().get(j).getNameStoreManegerOfItem())) {
                         countKindItemss++;
                         sumPriceItems = sumPriceItems + Att.getItemsdinamyorder().get(j).getSumPriceItem() + Att.getItemsdinamyorder().get(j).getPricemadeDiscount();
                     }
                 }
                 countKindItemss++;
                 sumPriceItems = sumPriceItems + Att.getItemsdinamyorder().get(i).getSumPriceItem() + Att.getItemsdinamyorder().get(i).getPricemadeDiscount();
                 for (k = 0; k < i; k++) {
                     if (Att.getItemsdinamyorder().get(i).getNameStoreManegerOfItem().equals(Att.getItemsdinamyorder().get(k).getNameStoreManegerOfItem()))
                         itemms.add(Att.getItemsdinamyorder().get(k));
                 }
                 UserWeb useNamage = user.searchUser(Att.getItemsdinamyorder().get(i).getNameStoreManegerOfItem());
                 itemms.add(Att.getItemsdinamyorder().get(i));
                 priceSend = sendhishbu(Att, tempobj, itemms);
                 String countItemsString = String.format("%d", countKindItemss);
                 String sumsendStr = String.format("%.2f", priceSend);
                 String costItemsStr = String.format("%.2f", sumPriceItems);
                 idorder = String.format("%d", user.getIdOrder());
                 OrderNotification orderNotification = new OrderNotification(idorder, Att.getUsername(), countItemsString, costItemsStr, sumsendStr);
                 useNamage.addOrderUpdate(orderNotification);
                 useNamage.setFinancialAction(Att.getDate().toString(),sumPriceItems+priceSend,1);
             }
             out.println("1");
            }
            else
            {
                out.println("3");
            }


        }
        catch (Exception e)
        {
            out.println("no suceess");
        }
    }

        public double sendhishbu(sessionAtt Att,classManeger obj,ArrayList<itemToOrderDinamy>itemms)
        {
            double sending=0;
            store st=null;
           customer cust=null;
           for(customer custs:obj.getIcostomers().getSdmcustomers())
           {
               if(custs.getId()==Att.getValue())
               {
                   cust=custs;
                   break;
               }
           }
           int count=0;
           for(int i=0;i<itemms.size()-1;i++)
           {
               count=0;
               for(int j=i+1;j<itemms.size();j++)
               {
                   if(itemms.get(i).getIdOfStoreOfItem()==itemms.get(j).getIdOfStoreOfItem())
                   count++;
               }
               if(count==0)
               {
                   for(store s:obj.getStores().getStoress())
                   {
                       if(s.getId()==itemms.get(i).getIdOfStoreOfItem())
                       {
                           st=s;
                           break;
                       }
                   }
                   double hefreshribuiyiX=Math.pow((double)(st.getLocation().getX()-cust.getLocation().getX()),2);
                   double hefreshribuiyiY=Math.pow((double)(st.getLocation().getY()-cust.getLocation().getY()),2);
                   double distance=Math.sqrt(hefreshribuiyiX+hefreshribuiyiY);
                   sending=sending+(distance)*((double)(st.getDelivery()));
               }
               count=0;
           }
           int i=itemms.size()-1;
           for(store s:obj.getStores().getStoress())
           {
               if(s.getId()==itemms.get(i).getIdOfStoreOfItem())
               {
                   st=s;
                   break;
               }
           }
            double hefreshribuiyiX=Math.pow((double)(st.getLocation().getX()-cust.getLocation().getX()),2);
            double hefreshribuiyiY=Math.pow((double)(st.getLocation().getY()-cust.getLocation().getY()),2);
            double distance=Math.sqrt(hefreshribuiyiX+hefreshribuiyiY);
            sending=sending+(distance)*((double)(st.getDelivery()));
           return  sending;


        }

        }
