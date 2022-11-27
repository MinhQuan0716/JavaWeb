<%-- 
    Document   : ViewCart
    Created on : Aug 15, 2022, 8:51:13 AM
    Author     : minhq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.tree.Tree"%>
<%@page import="sample.tree.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>View Cart </h1>

  <c:if test="${not empty sessionScope.CART}">


            <table border="1">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                          <th>Edit</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="tree" items="${sessionScope.CART.getCart().values()}" varStatus="counter">
                        <c:set var="total" value="${total +(tree.price * tree.quantity)}"/>

                    <form action="MainController">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${tree.id}
                                <input type="hidden" name="id" value="${tree.id}" />
                            </td>
                            <td>${tree.name}</td>
                            <td>${tree.price}</td>
                            <td>
                                <input type="number" name="quantity" value="${tree.quantity}" min="1"/>
                            </td>
                            <td>${tree.price * tree.quantity} $</td>
                            <td> 
                                <input type="submit" value="edit" name="action" />
                            </td>
                            <td> 
                                <input type="submit" value="remove" name="action" />
                            </td>
                        </tr>
                    </form>
                </c:forEach>

            </tbody>
        </table>
        <h1> Total : ${total} M</h1>

    </c:if>
        <a href="Shopping.jsp">add more</a>


            
 
    </body>
</html>
