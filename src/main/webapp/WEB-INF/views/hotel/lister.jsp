<%-- 
    Document   : lister
    Created on : 29 mai 2017, 12:26:02
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <c:import url="../_MENU.jsp"></c:import>
            </header>
            <c:choose>
                <c:when test="${adminConnecte}">  <button><a href="<spring:url value="/hotel/ajouter"></spring:url>">Nouvel hôtel</a></button>
            <h1>Hotels</h1>


            <table style="border-collapse: collapse">

                <thead>
                    <tr>
                        <th style="border: 1px black solid;">ID</th>
                        <th style="border: 1px black solid;">Nom</th>
                        <th style="border: 1px black solid;">Numéro</th>
                        <th style="border: 1px black solid;">Rue</th>
                        <th style="border: 1px black solid;">Code Postal</th>
                        <th style="border: 1px black solid;">Localité</th>
                        <th style="border: 1px black solid;">Pays</th>
                        <th style="border: 1px black solid;">Action</th>
                        <th style="border: 1px black solid;">Action 2</th>

                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${hotels}" var="h">
                    <tr>
                        <td style="border: 1px black solid;">${h.id}</td>
                        <td style="border: 1px black solid;">${h.nom}</td>
                        <td style="border: 1px black solid;">${h.adresse.num}</td>
                        <td style="border: 1px black solid;">${h.adresse.rue}</td>
                        <td style="border: 1px black solid;">${h.adresse.codePostal}</td>
                        <td style="border: 1px black solid;">${h.adresse.localite}</td>
                        <td style="border: 1px black solid;">${h.adresse.pays}</td>
                        <td style="border: 1px black solid;"><a href='<spring:url value="/hotel/supprimer/${h.id}" />'>Supprimer</a></td>
                        <td style="border: 1px black solid;"><a href='<spring:url value="/hotel/modifier/${h.id}" />'>Modifier</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table></c:when>
            </c:choose>
              
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
