<%-- 
    Document   : detail
    Created on : Mar 5, 2025, 3:07:11 AM
    Author     : bacda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certificate Details</title>
    </head>
    <body>
        <h1>Certificate Details</h1>
        <h3><span style="color: blue">ID: </span>${detail.id}</h3>
        <h3><span style="color: blue">Name: </span>${detail.name}</h3>
        <h3><span style="color: blue">Issuer: </span>${detail.issuer}</h3>
        <h3><span style="color: blue">Issue Date: </span>${detail.issueDate}</h3>
        <form action="MainController" method=POST> 
            <input name="id" value="${detail.id}" type="hidden">
            <input name="action" type="hidden" value="edit">
            <input type="submit" value="Edit">
        </form>
    </body>
</html>
