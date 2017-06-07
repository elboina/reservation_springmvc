<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 14:30:32
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche chambres</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <contenu>
            <h1>Rechercher</h1>
        <c:set var="chemin">
            <spring:url value="/utilisateur/recherche" />
        </c:set>
        

        <form:form modelAttribute="chambre" >
            <label>Ville :</label> <form:input path="hotel.adresse.localite" />
            <label>Nombre de personnes :</label> <form:input path="nbPersonnes" />
            <label>Date d'arrivée :</label> <form:input path="reservations[0].dateCheckIn" />
            <label>Date de départ :</label> <form:input path="reservations[0].dateCheckOut" />
            <input type="Submit" value="Rechercher" />
        </form:form>
            
            <h1>Résultats (${nombreResultats})</h1>

         <table>
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Hotel</th>
                    <th>Reserver ?</th>
                </tr>

            </thead>
            <tbody>
                <c:forEach items="${resultats}" var="ch">
                    <tr>
                        <td>${ch.nom}</td>
                        <td>${ch.prix}</td>
                        <td>${ch.hotel.nom}</td>
                        <td><button><a href="<spring:url value="/detailreservation/reserver/${ch.id}" />">Réserver</a></button></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </contenu>
    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>
