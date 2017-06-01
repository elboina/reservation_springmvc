<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 12:26:32
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<nav>
    <c:choose>
        <c:when test="${!utilConnecte}">
            <a href="<spring:url value="/identification" />">Identification</a>
            <a href="<spring:url value="/inscription" />">Inscription</a>
        </c:when>
        <c:when test="${adminConnecte}">
            <ul>
                <li>
                    <a href="<spring:url value="/hotel/lister"></spring:url>">Hotels</a>

                    </li>
                    <li>
                        <a href="<spring:url value="/chambre/lister"></spring:url>">Chambres</a>
                    </li>
                    <li>
                        <a href="<spring:url value="/client/lister" />">Clients</a>
                </li>
                <li>
                    <a href="<spring:url value="/reservations/lister" />">Reservations</a>
                </li>
                <li><a href="<spring:url value="/deconnexion" />">Déconnexion</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul>
                <li><a href="<spring:url value="/deconnexion" />">Déconnexion</a></li>
            </ul>
        </c:otherwise>
    </c:choose>

</nav>

