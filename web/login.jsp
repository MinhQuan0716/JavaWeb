<%-- 
    Document   : login
    Created on : Aug 10, 2022, 9:20:54 AM
    Author     : minhq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP</title>
            <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>
         <form action="MainController" method="POST">
            User Id <input type="text" name="usrdID" required=""/><br>
            Password <input type="password" name="password" required=""/><br>
<div  class="g-recaptcha" data-sitekey="6LdTb4IhAAAAAFfnVMkf6zh-XPnRobhSkEZ3okgk"></div>
            <input type="submit" name="action" value="Login"/>
              <input type="reset" name="Reset"/>
        </form>
        <a href="createuser.jsp">Create new user</a> <br>
           <a href="https://accounts.google.com/o/oauth2/auth?scope=email+profile&redirect_uri=http://localhost:8084/PRJ301_SU22_3W_JSP/LoginGoogle&response_type=code
              &client_id=1043905399296-hn1s534602rp00ijgo0n68lm0b97lasf.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  <br>
       
         ${requestScope.ERROR}
           
    </body>
</html>
