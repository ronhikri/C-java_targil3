package ServetsCreateOrder;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.*;
import sun.util.resources.LocaleData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class SeveteDate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            userManegerToServet user = UserUtils.getuser(getServletContext());
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            classManeger tempobj=user.searchList(Att.getNameZone());
            String dateYear=request.getParameter("Year");
            String dateMonth=request.getParameter("Month");
            String  dareDay=request.getParameter("Day");
            String radio=request.getParameter("staticOrDynamic");
            String x=request.getParameter("X");
            String y=request.getParameter("Y");
            boolean fixdate=true;
            try {
                int yearNumber = Integer.parseInt(dateYear);
                int MonthDate = Integer.parseInt(dateMonth);
                int DayDate = Integer.parseInt(dareDay);
                int xspace = Integer.parseInt(x);
                int yspace = Integer.parseInt(y);
                switch (MonthDate) {
                    case 1: {
                        if ((DayDate <= 0) || (DayDate >= 32)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 2: {
                        if ((DayDate <= 0) || (DayDate >= 29)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 3: {
                        if ((DayDate <= 0) || (DayDate > 32)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 4: {
                        if (((DayDate) <= 0) || (DayDate >= 31)) {
                            out.println("The date not fix");
                            fixdate = false;

                        }
                        break;
                    }
                    case 5: {
                        if ((DayDate <= 0) || (DayDate >= 32))
                            out.println("The date not fix");
                        break;
                    }
                    case 6: {
                        if (((DayDate) <= 0) || (DayDate >= 31)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 7: {
                        if ((DayDate <= 0) || (DayDate >= 32)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 8: {
                        if ((DayDate <= 0) || (DayDate >= 32)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 9: {
                        if (((DayDate) <= 0) || (DayDate >= 31)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 10: {
                        if ((DayDate <= 0) || (DayDate >= 32)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 11: {
                        if (((DayDate) <= 0) || (DayDate >= 31)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    case 12: {
                        if ((DayDate <= 0) || (DayDate >= 32)) {
                            out.println("The date not fix");
                            fixdate = false;
                        }
                        break;
                    }
                    default: {
                        out.println("The monthDate not fix");
                    }

                }

                if (fixdate) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                    String date = dareDay + '/' + dateMonth + '/' + dateYear;
                    LocalDate datei = LocalDate.parse(date, formatter);
                    customers cs = null;
                    if (tempobj.getIcostomers() == null) {
                        cs = new customers();
                    } else
                        cs = tempobj.getIcostomers();
                    boolean foundlocation = true;
                    for (customer c : cs.getSdmcustomers()) {
                        if (((xspace == c.getLocation().getX()) && (yspace == c.getLocation().getY()))&&!(Att.getNameZone().equals(c.getName()))) {
                            foundlocation = false;
                            break;
                        }
                    }
                    for (store st : tempobj.getStores().getStoress()) {
                        if ((xspace == st.getLocation().getX()) && (yspace == st.getLocation().getY())) {
                            foundlocation = false;
                            break;
                        }
                    }
                    if (!foundlocation) {
                        out.println("The location of customer exist in zone");
                    } else {
                        location l = null;
                        customer tempc = null;
                        if ((xspace <= 0) || (xspace > 50) || (yspace <= 0) || (yspace > 50))
                            out.println("The location not fix");
                        else {
                            tempc = new customer();
                            tempc.setId(Att.getValue());
                            tempc.setName(Att.getUsername());
                            l = new location();
                            l.setX(xspace);
                            l.setY(yspace);
                            tempc.setLocation(l);
                            cs.Addd(tempc);
                            tempobj.setIcostomers(cs);
                            user.Removi(Att.getNameZone());
                            user.getObjs().add(tempobj);
                            Att.setDate(datei);
                            if(radio.equals("Dynamic")) {
                                Att.setSelectorder(2);
                                session.setAttribute("Username", Att);
                                out.println("2");
                            }
                            else {
                                Att.setSelectorder(1);
                                session.setAttribute("Username", Att);
                                out.println("1");
                            }
                        }


                    }
                }
            }
            catch (DateTimeParseException e)
            {
                out.println("The date not fix");
            }
            catch (NumberFormatException e)
            {
                out.println("The date not fix or locations");
            }
            catch (Exception e)
            {
                out.println("you not dselect type order or no sucess");
            }

        }

    }

}

