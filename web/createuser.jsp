<%-- 
    Document   : createuser
    Created on : Aug 12, 2022, 8:34:16 AM
    Author     : minhq
--%>

<%@page import="sample.user.UserErr"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <body>

        <form action="MainController" method="POST">
            User ID <input type="text" name="usrdID" required="" placeholder="user id"/>${requestScope.USER_ERROR.userIDError} <br>
            Full name <input type="text" name="fullname" required=""/>${requestScope.USER_ERROR.fullnameError} <br>
            Password <input type="password" name="password" required=""/> <br>
            Confirm  <input type="password" name="confirm" required="" /> ${requestScope.USER_ERROR.confirmError} <br>
            Role ID <input type="text" name="roleID" required="" /> <br>
            Status  <input type="text" name="status" value="true" required="" /> <br>
           <input type="submit" name="action" value="Create"/>
          <input type="reset" name="Reset"/>                  
                        
            
        </form>
       </body>
</html>
