<%-- 
    Document   : edit
    Created on : Mar 6, 2025, 9:33:41 AM
    Author     : bacda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit Certificate</h1>
        <h3 style="color:red">PLEASE DO NOT LEAVE ANY BLANK!!!</h3>
        <form name="editForm" action="MainController" method="POST" onsubmit="validateForm(event)"> 
            <table>
                <tr>
                    <td><label>ID:</label></td>
                    <td><input value="${detailc.id}" name="id" type="text" readonly size="60"></td>
                </tr>
                <tr>
                    <td><label>Name:</label></td>
                    <td><input value="${detailc.name}" name="name" type="text" size="60"></td>
                </tr>
                <tr>
                    <td><label>Issuer:</label></td>
                    <td><input value="${detailc.issuer}" name="issuer" type="text" size="60"></td>
                </tr>
                <tr>
                    <td><label>Issue Date:</label></td>
                    <td><input value="${detailc.issueDate}" name="issuedate" type="date" size="60"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input name="action" type="hidden" value="update">
                        <input value="Update" type="submit">
                    </td>
                </tr>
            </table>  
        </form>
        <script>
            function validateForm(event) {
                var name = document.forms["editForm"]["name"].value.trim();
                var issuer = document.forms["editForm"]["issuer"].value.trim();
                var issuedate = document.forms["editForm"]["issuedate"].value;

                if (name === "" || issuer === "" || issuedate === "") {
                    alert("Please enter complete information!");
                    event.preventDefault(); 
                }
            }
        </script>

    </body>
</html>
