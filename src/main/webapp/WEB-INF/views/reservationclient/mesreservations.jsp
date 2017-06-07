<%-- 
    Document   : mesreservations
    Created on : 6 juin 2017, 11:18:23
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="urlapayer">
    <spring:url value="/detailreservation"/>
</c:set>
<c:set var="urlpayees">
    <spring:url value="/detailreservation/paye"/>
</c:set>
<c:set var="urlannulees">
    <spring:url value="/detailreservation/annulees"/>
</c:set>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
        <contenu>
            <h1>Mes réservations à payer</h1>

            <table style="border: black solid 1px; text-align: center;">
                <thead>
                    <tr><th>RESERVATIONS A PAYER</th></tr>
                    <tr>
                        <th style="border: black solid 1px">ID Réservation</th>
                        <th style="border: black solid 1px">Nom Client</th>
                        <th style="border: black solid 1px">Date</th>
                        <th style="border: black solid 1px">Prix</th>
                        <th style="border: black solid 1px">Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${reservationsAPayer}" var="resap">
                    <tr>
                        <td style="border: black solid 1px">${resap.id}</td>
                        <td style="border: black solid 1px">${resap.client.nom}</td>
                        <td style="border: black solid 1px">${resap.dateCheckIn}</td>
                        <td style="border: black solid 1px">${resap.prixTotal}</td>
                        <td style="border: black solid 1px"><a href="${urlpayees}/${resap.id}">Payer</a>/<a href="${urlannulees}/${resap.id}">Annuler</a>/<a href="<spring:url value="/detailreservation/${resap.id}"/>">Details</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            
            <h1>Mes réservations payées</h1>

            <table style="border: black solid 1px; text-align: center;">
                <thead>
                    <tr><th>RESERVATIONS PAYEES</th></tr>
                    <tr>
                        <th style="border: black solid 1px">ID Réservation</th>
                        <th style="border: black solid 1px">Nom Client</th>
                        <th style="border: black solid 1px">Date</th>
                        <th style="border: black solid 1px">Prix</th>
                        <th style="border: black solid 1px">Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${reservationsPayees}" var="resap">
                    <tr>
                        <td style="border: black solid 1px">${resap.id}</td>
                        <td style="border: black solid 1px">${resap.client.nom}</td>
                        <td style="border: black solid 1px">${resap.dateCheckIn}</td>
                        <td style="border: black solid 1px">${resap.prixTotal}</td>
                        <td style="border: black solid 1px"><a href="${urlpayees}/${resap.id}">Payer</a>/<a href="${urlannulees}/${resap.id}">Annuler</a>/<a href="<spring:url value="/detailreservation/${resap.id}"/>">Details</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            
            <h1>Mes réservations annulées</h1>

            <table style="border: black solid 1px; text-align: center;">
                <thead>
                    <tr><th>RESERVATIONS ANNULEES</th></tr>
                    <tr>
                        <th style="border: black solid 1px">ID Réservation</th>
                        <th style="border: black solid 1px">Nom Client</th>
                        <th style="border: black solid 1px">Date</th>
                        <th style="border: black solid 1px">Prix</th>
                        <th style="border: black solid 1px">Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${reservationsAnnulees}" var="resap">
                    <tr>
                        <td style="border: black solid 1px">${resap.id}</td>
                        <td style="border: black solid 1px">${resap.client.nom}</td>
                        <td style="border: black solid 1px">${resap.dateCheckIn}</td>
                        <td style="border: black solid 1px">${resap.prixTotal}</td>
                        <td style="border: black solid 1px"><a href="${urlpayees}/${resap.id}">Payer</a>/<a href="${urlannulees}/${resap.id}">Annuler</a>/<a href="<spring:url value="/detailreservation/${resap.id}"/>">Details</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>

        </contenu>
    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>