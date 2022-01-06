package servlets;

import Utils.DataInPlacaes;
import Utils.UserUtils;
import Utils.sessionAtt;
import Utils.userManegerToServet;
import clasinEx.DatsInPlace;
import clasinEx.classManeger;
import com.google.gson.Gson;
import javafx.scene.chart.XYChart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class dataStores extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            userManegerToServet user = UserUtils.getuser(getServletContext());
            HttpSession session = request.getSession();
            sessionAtt Att = (sessionAtt) session.getAttribute("Username");
            ArrayList<DatsInPlace> datas = new ArrayList<>();
            if (user.getObjs().size() != 0) {
                for (classManeger obj : user.getObjs()) {
                    DatsInPlace data = obj.createdataInPlace();
                    datas.add(data);
                }

            }
            DataInPlacaes dat = new DataInPlacaes(datas);
            System.out.println("yoni");
            Gson gson = new Gson();
            String json=gson.toJson(datas);
            System.out.println("yoni");




            out.println(json);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
