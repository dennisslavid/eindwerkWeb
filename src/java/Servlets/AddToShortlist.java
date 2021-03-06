package Servlets;

import DAL.Internship;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.InternshipEJB;
import services.ShortlistEJB;

/**
 *
 * @author denni
 */
public class AddToShortlist extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    InternshipEJB internshipService;
    @EJB
    ShortlistEJB shortlistService;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Internship> shortlist = shortlistService.getShortlist();
        HttpSession session = request.getSession();
        session.setAttribute("shortlist", shortlist);
        RequestDispatcher rd = request.getRequestDispatcher("shortlistPage.jsp");
        rd.forward(request, response);
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
        HttpSession session = request.getSession();
        Internship current = (Internship)session.getAttribute("requestedInternship");
        int deleteId = 0;
        if(request.getParameter("deleteId") != null) {
            deleteId = Integer.parseInt(request.getParameter("deleteId"));
            List<Internship> shortlist = shortlistService.getShortlist();
            int indexToRemove = 0;
            for (Internship i : shortlist) {
                if(deleteId == i.getId()) {
                    indexToRemove = shortlist.indexOf(i);
                }
            }
            shortlistService.removeFromShortlist(indexToRemove);
        } else {
            if(!shortlistService.containsInternship(current.getId())) {
                shortlistService.addToShortlist(current);
            }
        }
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
