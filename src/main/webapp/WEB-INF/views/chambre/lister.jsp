<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 14:30:32
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des chambres</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <h1>Liste des chambres</h1>
        <table>
            <thead>
                <tr>
                    <th>
                       ID 
                    </th>
                    <th>
                       Nom 
                    </th>
                    <th>
                       Prix
                    </th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${listeChambres}" var="ch">
                    <tr>
                        <td>${ch.id}</td>
                        <td>${ch.nom}</td>
                        <td>${ch.prix}</td>
                    </tr>
                    
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
