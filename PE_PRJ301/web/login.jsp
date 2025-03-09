<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <p style="color: red;"><%= error %></p>
        <% } %>
        <form action="./LoginController" method="post">
            <input name="username" type="text" size="30" placeholder="username"><br/>
            <input name="password" type="password" size="30" placeholder="password"><br/>
            <input type=hidden name="action" value="login">
            <input value="Login" type="submit">   
        </form>
        
        
    </body>
    
</html>

