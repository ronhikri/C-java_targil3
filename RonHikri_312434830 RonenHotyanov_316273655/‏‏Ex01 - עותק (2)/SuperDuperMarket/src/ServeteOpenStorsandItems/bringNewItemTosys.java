package ServeteOpenStorsandItems;

import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.classManeger;
import clasinEx.itemToSystem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class bringNewItemTosys extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            userManegerToServet user = UserUtils.getuser(getServletContext());
            String name_Zone=request.getParameter("ZonSelect");
            Att.setNanecurrentZoneToAddItem(name_Zone);
            classManeger tempobj = user.searchList(Att.getNanecurrentZoneToAddItem());
            String name_item=request.getParameter("nameitemto");
            String howToAcheive=request.getParameter("howBuyItemTo");
            int maxi=tempobj.maxidItem();
            int id_item=maxi+1;
            itemToSystem iter=new itemToSystem();
            iter.setIditem(id_item);
            iter.setHowToBuy(howToAcheive);
            iter.setNameitem(name_item);
            Att.setItemed(iter);
            Att.setCountStoresToItem(0);
            session.setAttribute("Username", Att);
            out.println("1");
        }
        catch (Exception e)
        {
            out.println("no success");
        }
    }
}
