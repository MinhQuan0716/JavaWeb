/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;

/**
 *
 * @author minhq
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
private static final String ERROR="error.html";
private static final String LOGIN="Login";
private static final String LOGIN_Controller="LoginController";
private static final String SEARCH_Controller="SearchController";
private static final String SEARCH="Search";
private static final String DELETE_Controller="DeleteController";
private static final String DELETE="Delete";
private static final String UPDATE_Controller="UpdateController";
private static final String UPDATE="Update";
private static final String CREATE_Controller="CreateController";
private static final String CREATE="Create";
private static final String LOGOUT_Controller="LogoutController";
private static final String LOGOUT="Logout";
private static final String ADD_Controller="AddController";
private static final String ADD="Add";
private static final String VIEW_PAGE="ViewPage.jsp";
private static final String VIEW="View";
private static final String EDIT_Controller="EditController";
private static final String EDIT="edit";
private static final String REMOVE_Controller="RemoveController";
private static final String REMOVE="remove";
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
        String action=request.getParameter("action");
        String url=ERROR;
        try  {
            if(LOGIN.equals(action)){
                url=LOGIN_Controller;
            } else if(SEARCH.equals(action)){
                url=SEARCH_Controller;
            } else if(DELETE.equals(action)){
                url=DELETE_Controller;
            }    else if(UPDATE.equals(action)){
                url=UPDATE_Controller;
            }   else if(CREATE.equals(action)){
                url=CREATE_Controller;
            } else if(LOGOUT.equals(action)){
                url=LOGOUT_Controller;
            } else if(ADD.equals(action)){
                url=ADD_Controller;
            } else if(VIEW.equals(action)){
                url=VIEW_PAGE;
            } else if(EDIT.equals(action)){
                url=EDIT_Controller;
            } else if(REMOVE.equals(action)){
                url=REMOVE_Controller;
            }
                     
        } catch(Exception e){
            log("Error at MainController:"+e.toString());
        } finally{
            request.getRequestDispatcher(url).forward(request, response);
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
