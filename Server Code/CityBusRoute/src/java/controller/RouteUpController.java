package controller;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import listener.Provider;

@WebServlet(name = "RouteUpController", urlPatterns = {"/RouteUpController"})
public class RouteUpController extends HttpServlet {

    private String detail[] = new String[20];
    private Provider provider;
    private HttpSession session;
    private DbOperator dbOperator;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        provider=  Provider.get_Provider();
        session= request.getSession();
        String action=(String) request.getParameter("btSubmit");
        detail[0]=request.getParameter("etBusName");
        System.out.println("Action: "+action);
        
        if(action.equalsIgnoreCase("Add Stopage")) {
            detail[1]=request.getParameter("etStopage");  
            dbOperator= provider.context.getBean("addSingleStand", AddSingleStand.class);
            if(provider.Provide(dbOperator, detail))
                    System.out.println("Added");
            else
                    System.out.println("Failed");
            request.getRequestDispatcher("route_up_add_stand.jsp").forward(request, response);
        }
        
        else if(action.equalsIgnoreCase("Delete Stopage")) {
            
            detail[1]=request.getParameter("etStopage");  
            dbOperator= provider.context.getBean("removeSingleStand", RemoveSingleStand.class);
            if(provider.Provide(dbOperator, detail))
                    System.out.println("Added");
            else
                    System.out.println("Failed");
             request.getRequestDispatcher("route_up_remove_stand.jsp").forward(request, response);
        }
        
        else if(action.equalsIgnoreCase("Update Stopage")) {
            
            detail[1]=request.getParameter("etPrevStopage"); 
            detail[2]=request.getParameter("etNewStopage"); 
            dbOperator= provider.context.getBean("updateSingleStand", UpdateSingleStand.class);
            if(provider.Provide(dbOperator, detail))
                    System.out.println("Added");
            else
                    System.out.println("Failed");
            request.getRequestDispatcher("route_up_update_stopage.jsp").forward(request, response);
        }
        
        else if(action.equalsIgnoreCase("Add Coordinate")) {
            detail[1]=(String) request.getParameter("etLat"); 
            detail[2]=(String) request.getParameter("etLong");
            System.out.println(detail[1]+" "+detail[2]);
            dbOperator= provider.context.getBean("addSingleCoordinate", AddSingleCoordinate.class);
            if(provider.Provide(dbOperator, detail))
                    System.out.println("Added");
            else
                    System.out.println("Failed");
            request.getRequestDispatcher("route_up_add_coordinate.jsp").forward(request, response);
        }
       
        else if(action.equalsIgnoreCase("Delete Coordinate")) {
            detail[1]=(String) request.getParameter("etLat"); 
            detail[2]=(String) request.getParameter("etLong");
            System.out.println(detail[1]+" "+detail[2]);
            dbOperator= provider.context.getBean("removeSingleCoordinate", RemoveSingleCoordinate.class);
            if(provider.Provide(dbOperator, detail))
                    System.out.println("Added");
            else
                    System.out.println("Failed");
            request.getRequestDispatcher("route_up_remove_coordinate.jsp").forward(request, response);
        }
        
        else if(action.equalsIgnoreCase("Update Coordinate")) {
            detail[1]=(String) request.getParameter("etPrevLat"); 
            detail[2]=(String) request.getParameter("etPrevLong");
            detail[3]=(String) request.getParameter("etNewLat"); 
            detail[4]=(String) request.getParameter("etNewLong");
            
            System.out.println(detail[1]+" "+detail[2]);
            dbOperator= provider.context.getBean("updateSingleCoordinate", UpdateSingleCoordinate.class);
            if(provider.Provide(dbOperator, detail))
                    System.out.println("Added");
            else
                    System.out.println("Failed");
            request.getRequestDispatcher("route_up_update_coordinate.jsp").forward(request, response);
        }
        
        
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
