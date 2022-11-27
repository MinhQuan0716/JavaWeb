/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sapmle.utils.GooglePOJO;
import sapmle.utils.GoogleUtils;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author minhq
 */
@WebServlet(name = "LoginGoogle", urlPatterns = {"/LoginGoogle"})
public class LoginGoogle extends HttpServlet {
private final String USER="user.jsp";
private final String LOGIN="login.jsp";
private final String INDEX="index.jsp";
private final String Login_Control="LoginController";
      private static final long serialVersionUID = 1L;
//  public LoginGoogle() {
//    super();
//  }

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
        String url=INDEX;
   String code = request.getParameter("code");
  
       try{
            if (code == null || code.isEmpty()) {
          url=LOGIN;
    } else {
      String accessToken = GoogleUtils.getToken(code);
      GooglePOJO googlePojo = GoogleUtils.getUserInfo(accessToken);
       HttpSession session=request.getSession();
       String userId=googlePojo.getEmail();
       String fullname=googlePojo.getName();
      
       String password=googlePojo.getEmail().replaceAll("[^0-9]", "");
     UserDTO dto =new UserDTO(userId,fullname,"***","US",true);
     UserDAO dao=new UserDAO();
   
    UserDTO checkUser=dao.checkLogin(userId,password );
    if (checkUser==null){ 
          boolean check= dao.insert(dto);
              if(check){
     session.setAttribute("LOGIN_USER", dto);
            url=USER;}
    } else{
     session.setAttribute("LOGIN_USER", dto);
     url=USER;
    }

         }
  }
        catch (Exception e){
           e.printStackTrace();
                   
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
