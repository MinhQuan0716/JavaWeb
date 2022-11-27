/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import sample.tree.Cart;
import sample.tree.Tree;

/**
 *
 * @author minhq
 */
@WebServlet(name = "AddController", urlPatterns = {"/AddController"})
public class AddController extends HttpServlet {
private static final String ERROR="error.jsp";
private static final String SUCCESS="Shopping.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try  {
            String treeString = request.getParameter("cmvTree");
           String [] tmp=treeString.split("-");
           String id=tmp[0];
            String name=tmp[1];
             double  price= Double.parseDouble(tmp[2]);
              int quantity =Integer.parseInt(request.getParameter("cmbQuantity"));
           HttpSession session=request.getSession();
           Cart cart =(Cart ) session.getAttribute("CART");
           if(cart==null){
               cart=new Cart();
           } 
           Tree tree =new Tree(id,name,price,quantity);
           cart.add(tree);
           session.setAttribute("CART", cart);
           request.setAttribute("MESSAGE", name + "added successfully"  +quantity);
               url=SUCCESS;
        } catch (Exception e){
            
        } finally {
            request.getRequestDispatcher(url).forward(request, response);        }
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
