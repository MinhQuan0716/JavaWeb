/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserErr;

/**
 *
 * @author minhq
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {
private static final String ERROR="createuser.jsp";
private static final String SUCCESS="LoginController";
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
         UserErr error=new UserErr();
         boolean validation =false;
        try  {
           UserDAO dao=new UserDAO();
              String userId=request.getParameter("usrdID");
           String password=request.getParameter("password");
           String fullname=request.getParameter("fullname");
           String roleID=request.getParameter("roleID");
           String confirm =request.getParameter("confirm");
           //check userID length
           if(userId.length()>10 || userId.length()<2){
               validation=false;
              error.setUserIDError("UserID [3...10]");
              
           } 
           //check duplicate user ID
           //boolean checkDup=dao.checkID(userId);
          //      if(checkDup){
          //     validation=false;
          //    error.setUserIDError("Duplicate user id");
              
         //  } 
             //check fullanme length
                 if(fullname.length()>100 || fullname.length()<5){
               validation=false;
              error.setFullnameError("Full name [6...100]");
              
           } 
                 //check password length
                  if(!password.equals(confirm)){
               validation=false;
              error.setConfirmError("Password do not match ");
              
           } 
                  
         if(validation==false){
             boolean check=dao.insertV2(new UserDTO(userId,fullname,password,roleID,false));
             if(check){
                 url=SUCCESS;
             }
         } else {
             request.setAttribute("USER_ERROR", error);
             
         }
        } catch(Exception e){
            log("Error at CreateController:"+e.toString());
            if(e.toString().contains("duplicate")){
                 error.setUserIDError("Duplicate user id");
                 request.setAttribute("USER_ERROR", error); 
            }
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
