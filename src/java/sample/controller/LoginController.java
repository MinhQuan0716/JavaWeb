/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
import sapmle.utils.VerifyCaptcha;


/**
 *
 * @author minhq
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
private static  final String ERROR="login.jsp";
private static final String ADMIN_PAGE="admin.jsp";
private static final String USER_PAGE="user.jsp";
private static final String AD="AD";
private static final String US="US";

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
              String userId=request.getParameter("usrdID");
           String password=request.getParameter("password");
         String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
          boolean verify = VerifyCaptcha.verify(gRecaptchaResponse);
          if (verify){
               UserDAO dao=new UserDAO();
           UserDTO user=dao.checkLogin(userId, password);

          
           if(user!=null){
               String roleID=user.getRoleID();
               HttpSession session=request.getSession();
               session.setAttribute("LOGIN_USER", user);
               if(AD.equals(roleID)){
                   url=ADMIN_PAGE;
               } else if(US.equals(roleID)){
                   url=USER_PAGE;
               }  else{
                   request.setAttribute("ERROR", "Your role is not support");
               }
           } else {
               request.setAttribute("ERROR", "Incorrect username or password");
           } 
          } else {
              request.setAttribute("ERROR", "Miss the recpatcha");
               url=ERROR;
          }
          
       
        } catch(Exception e){
            log("Error at LoginController:"+e.toString());
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
