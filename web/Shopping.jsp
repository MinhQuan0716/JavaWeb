<%-- 
    Document   : Shopping
    Created on : Aug 15, 2022, 7:47:00 AM
    Author     : minhq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Hello Quan's Store </h1>
        Choose your fruit 
        <form action="MainController">
            <select name="cmvTree">
                <option value="TB1-Ben Tre Coconut-10">Ben Tre Coconut-10M</option>
                <option value="TB2-Africa Catcus-5">Africa Catcus-5M</option>
                <option value="TB3-Rock Lotus-3">Rock Lotus-3M</option>
                <option value="TB4-Viet Nam XaNU-3">Viet Nam XaNU-3M</option>
                <option value="TB5-Lemon Tree-1">Lemon Tree-1M</option>  
            </select>
            <select name="cmbQuantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
               <option value="5">5</option>
               <option value="6">6</option>
               <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>

                                              
            </select>
            <input type="submit" name="action" value="Add"/> 
                        <input type="submit" name="action" value="View"/> 
        </form>
        ${requestScope.MESSAGE}
    </body>
</html>
