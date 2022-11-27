<%-- 
    Document   : admin
    Created on : Aug 10, 2022, 9:23:29 AM
    Author     : minhq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin JSP</title>
    </head>
    <body>
     <c:if test="${sessionScope.LOGIN_USER.userID==null || sessionScope.LOGIN_USER.roleID == 'US'}">
            <c:redirect url="login.jsp">
            </c:redirect>
    </c:if>           
     Welcome <h1>${sessionScope.LOGIN_USER.fullname}</h1>
            <a href="MainController?action=Logout" >Log Out </a>
            <c:url var="Logout" value="MainController" >
                <c:param name="action" value="Logout"></c:param>
            </c:url>
            <form action="MainController" method="POST">
                Search <input type="text" name="search"/>
                <input type="submit" name="action" value="Search"/>
            </form>
            <c:if test="${requestScope.LIST_USER!=null}">
                <c:if test ="${not empty requestScope.LIST_USER}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>User ID</th>
                                <th>Full name</th>
                                <th>Role ID</th>
                                <th>Password</th>
                                <th>Status</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
                            <form action="MainController">

                          
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <input type="text" name="usrdID" value="${user.userID}" readonly=""/>
                                </td>
                                <td>
                                    <input type="text" name="fullName" value="${user.fullname}" required=""/>
                                </td>
                                <td>
                                       <input type="text" name="roleID" value="${user.roleID}" required=""/>
                                </td>
                                <td>${user.password}</td>
                                <td>${user.status}</td>
                                <td>
                                    <input type="submit" name="action" value="Update"/>
                                    <input type="hidden" name="Search" value="${param.search}"/> 
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="Delete" ></c:param>
                                        <c:param name="search" value="${param.search}" ></c:param>
                                        <c:param name="usrdID" value="${user.userID}" ></c:param>
                                        
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                            </tr>                           
                            </form>                        
                            </c:forEach>
                        </tbody>

                    </table>

                </c:if>
             <c:if test="${requestScope.LIST_USER!=null}">
                    NO RECORD FOUND
                </c:if>
            </c:if>

          </body>
</html>
