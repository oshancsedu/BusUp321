package controller;

import jsonaction.*;
import listener.Provider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "JSONUpdateController", urlPatterns = {"/JSONUpdateController"})
public class JSONUpdateController extends HttpServlet {

    private Provider provider;
    private JSONUpdate json;
    private List<BusName> busName;
    private  List<StandDetail> standDetail;
    private JSONObject JfinalNode;
    private  JSONObject JbusName;
    private JSONObject Jroute;
    private JSONObject JstandDetail;
    private JSONObject JFinalBusStand;
    private JSONArray JBusStandArray;
    private JSONArray jArray;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        provider=  Provider.get_Provider();
        json = provider.context.getBean("jsonUpdate", JSONUpdate.class);
        busName= json.getAllBusName();
        standDetail =json.getAllStand();
        JfinalNode= new JSONObject();
        JbusName= new JSONObject();
        Jroute= new JSONObject();
        JstandDetail= new JSONObject();
        JFinalBusStand= new JSONObject();
        
        try {
        jArray = new JSONArray(); 
        JBusStandArray= new JSONArray();
        for(int i=0;i<busName.size();i++) {
            JSONObject JEachBus_Stand2= new JSONObject();
            JSONObject row = new JSONObject();
            row.put("name",busName.get(i).getName());
            row.put("color",busName.get(i).getColor());
            jArray.put(row);
            List<Name> busStand =json.getAllBusStand(busName.get(i).getName());
            List<Route> busRoute =json.getAllBusRoute(busName.get(i).getName());
            JSONObject JEachBus_Stand= new JSONObject();
            JSONArray jStandArray = new JSONArray();
            for(int j=0;j<busRoute.size();j++) {
                JSONObject row2 = new JSONObject();
                if(j<busStand.size())
                row2.put("name", busStand.get(j).getName());
                row2.put("lat", busRoute.get(j).getLat());
                row2.put("long", busRoute.get(j).getLng());
                jStandArray.put(row2);
            }
            JEachBus_Stand.put("Stands", jStandArray);
            JEachBus_Stand2.put(busName.get(i).getName(),JEachBus_Stand);
            JBusStandArray.put(JEachBus_Stand2);
        }
        JFinalBusStand.put("Bus Stands",JBusStandArray);
        JbusName.put("BusName", jArray);
        JfinalNode.put("Bus Name",JbusName);
        JfinalNode.put("Stand of Each Bus",JFinalBusStand);
        
        jArray = new JSONArray();
        for(int i=0;i<standDetail.size();i++) {
            JSONObject row = new JSONObject();
            row.put("name", standDetail.get(i).getStandName());
            row.put("latUp",standDetail.get(i).getLatUp());
            row.put("longUp",standDetail.get(i).getLongUp());
            row.put("latDown",standDetail.get(i).getLatDown());
            row.put("longDown",standDetail.get(i).getLongDown());
            jArray.put(row);
        }
        JstandDetail.put("Stand",jArray);
        JfinalNode.put("Stand Detail",JstandDetail);
        } catch (JSONException ex) {
                 ex.printStackTrace();
        }
        response.setContentType("application/json");
        response.getWriter().print(JfinalNode);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
