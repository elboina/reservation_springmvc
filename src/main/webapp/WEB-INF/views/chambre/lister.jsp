<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 14:30:32
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <c:choose>
            <c:when test="${adminConnecte}">
        <a href="<spring:url value='/chambre/ajouter'></spring:url>">Nouvelle Chambre</a>
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
                    <th>
                       Hotel
                    </th>
                    <th>Action</th>
                    <th>Action 2</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${listeChambres}" var="ch">
                    <tr>
                        <td>${ch.id}</td>
                        <td>${ch.nom}</td>
                        <td>${ch.prix}</td>
                        <td>${ch.hotel.nom}</td>
                        <td><a href="<spring:url value='/chambre/modifier/${ch.id}'></spring:url>">Modifier</a></td>
                        <td><a href="<spring:url value="/chambre/supprimer/${ch.id}" />">Supprimer</a></td>
                    </tr>
                    
                </c:forEach>
            </tbody>
        </table>
            </c:when>
        </c:choose>
    </body>
</html>
