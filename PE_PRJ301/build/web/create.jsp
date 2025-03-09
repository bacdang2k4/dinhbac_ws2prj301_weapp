<%-- 
    Document   : create
    Created on : Mar 6, 2025, 10:46:48 PM
    Author     : bacda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h1>New Certificate</h1>
        <h3 style="color:red">PLEASE DO NOT LEAVE ANY BLANK!!!</h3>
        
        <form name="createForm" action="MainController" method="POST" onsubmit="validateForm(event)">
            <table>
                <tr>
                    <td><label>Certificate ID:</label></td>
                    <td><input name="id" type="text" size="60" value="${newId}" readonly></td>
                </tr>
                <tr>
                    <td><label>Certificate Name:</label></td>
                    <td><input name="name" type="text" size="60" placeholder="Certificate Name"></td>
                </tr>
                <tr>
                    <td><label>Issuer:</label></td>
                    <td><input name="issuer" type="text" size="60" placeholder="Issuer"></td>
                </tr>
                <tr>
                    <td><label>Issue Date:</label></td>
                    <td><input name="issuedate" type="date" size="60" placeholder="Issue Date"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input type=hidden name="action" value="create">
                        <input value="Create" type="submit">  
                    </td>
                </tr>
            </table>
        </form>
        
        <script>
            function validateForm(event) {
                var name = document.forms["createForm"]["name"].value.trim();
                var issuer = document.forms["createForm"]["issuer"].value.trim();
                var issuedate = document.forms["createForm"]["issuedate"].value;

                if (name === "" || issuer === "" || issuedate === "") {
                    alert("Please enter complete information.");
                    event.preventDefault();
                }
            }
            </script>
        </body>
    </html>
