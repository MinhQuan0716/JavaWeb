<%-- 
    Document   : user
    Created on : Aug 10, 2022, 9:26:57 AM
    Author     : minhq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sapmle.utils.GooglePOJO"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.userID==null || sessionScope.LOGIN_USER.roleID == 'AD'}">
            <c:redirect url="login.jsp">
            </c:redirect>
    </c:if>           
   
            Welcome <h1>${sessionScope.LOGIN_USER.fullname}</h1> <br>
            User ID: ${sessionScope.LOGIN_USER.userID} <br>
        Password: ${sessionScope.LOGIN_USER.password}<br>
        Role ID: ${sessionScope.LOGIN_USER.roleID}    <br> 
        <a href="Shopping.jsp">Shopping Page</a>

   
        
    </body>
</html>
