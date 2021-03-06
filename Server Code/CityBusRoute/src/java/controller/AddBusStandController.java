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

@WebServlet(name = "AddBusStandController", urlPatterns = {"/AddBusStandController"})
public class AddBusStandController extends HttpServlet {

    private String detail[] = new String[20];
    private Provider provider;
    private HttpSession session;
    private DbOperator dbOperator;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        provider=  Provider.get_Provider();
        session= request.getSession();
        dbOperator= provider.context.getBean("addBusStand", AddBusStand.class);
        detail[0]=request.getParameter("etBusStand");
        detail[1]=request.getParameter("etLatUp");
        detail[2]=request.getParameter("etLongUp");
        detail[3]=request.getParameter("etLatDown");
        detail[4]=request.getParameter("etLongDown");
        
        if(detail[0]!=null) {
            if(provider.Provide(dbOperator, detail))
                System.out.println("Added");
            else
                System.out.println("Failed");
        }
       request.getRequestDispatcher("add_stopage.jsp").forward(request, response);
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
