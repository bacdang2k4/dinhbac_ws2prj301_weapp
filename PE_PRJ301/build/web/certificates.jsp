<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="pe.Certificate.CertificateDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certificate List</title>
    </head>
    <body>
        <h2>WELCOME ${usersession.name}</h2>
        <h1>Certificate List</h1>
        <%@ include file="/menu.jsp" %>

        <form action='' method=POST> 
            <input name="keyword" type="text" value="${keyword}">
            <input type=hidden name="action" value="search">
            <input type="submit" value="Search">
        </form>

        <table border="1">
            <tr>
                <th>Certificate ID</th>
                <th>Certificate Name</th>
                <th>Issuer</th>
                <th>Issue Date</th>
            </tr>
            <%--<h2>Debugging Data</h2>
            <p>List Size: ${list.size()}</p>--%>
            <c:forEach items="${list}" var="o">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.name}</td>
                    <td>${o.issuer}</td>
                    <td>${o.issueDate}</td>
                    <td>
                        <form action='MainController' method=POST> 
                            <input name="id" value="${o.id}" type="hidden">
                            <input type=hidden name="action" value="details">
                            <input type="submit" value="Detail">
                        </form>
                    </td>
                    <td>
                        <form action='MainController' method=POST> 
                            <input name="id" value="${o.id}" type="hidden">
                            <input type=hidden name="action" value="delete">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    <td>
                        <form action='MainController' method=POST> 
                            <input name="id" value="${o.id}" type="hidden">
                            <input type=hidden name="action" value="">
                            <input type="submit" value="ADD TO SHELF">
                        </form>
                    </td>
                </tr>
            </c:forEach>                 
        </table>
        <br/>
        <form action='MainController' method=POST> 
            <input name="action" type="hidden" value="createPage">
            <input type="submit" value="Create">
        </form>
    </body> 
</html>
