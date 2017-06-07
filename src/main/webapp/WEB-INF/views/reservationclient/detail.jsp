<%-- 
    Document   : detail
    Created on : 6 juin 2017, 11:18:32
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails réservation</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <contenu>
            <h1>Détails de la réservation</h1>
            <table>
                <thead>
                    <tr>
                        <th>Chambre</th>
                        <th>Client</th>
                        <th>Date CheckIn</th>
                        <th>Date CheckOut</th>
                        <th>Prix Total</th>
                        <th>Etat</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${reservation.chambres[0].nom}</td>
                    <td> ${reservation.client.prenom} ${reservation.client.nom}</td>
                    <td> ${reservation.dateCheckIn}</td>
                    <td> ${reservation.dateCheckOut}</td>
                    <td> ${reservation.prixTotal}</td>
                    <td> ${reservation.etatReservation}</td>
                </tr>
            </tbody>
        </table>
                    <a href="<spring:url value="/mesreservations"/>">Retour Liste Réservations</a>

    </contenu>
    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>