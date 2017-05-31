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
        <title>Gestion des réservations</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenu>
        <h1>Liste des réservations</h1>
        
    <c:choose>
        <c:when test="${adminConnecte}">
            <a href="<spring:url value="/reservations/ajouter"/>">Nouvelle réservation</a>
            <table>
                <thead>
                    <tr>
                        <th>Client</th>
                        <th>Prix Total</th>
                        <th>Date de réservation</th>
                        <th>Etat de la réservation</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listeReservations}" var ="res">
                    <tr>
                        <td>${res.client.prenom} ${res.client.nom}</td>
                        <td>${res.prixTotal}</td>
                        <td>${res.dateReservation}</td>
                        <td>${res.etatReservation}</td>
                    </tr>
                    </c:forEach>
                               
                </tbody>
            </table>
        </c:when>
    </c:choose>
        
    </contenu>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
