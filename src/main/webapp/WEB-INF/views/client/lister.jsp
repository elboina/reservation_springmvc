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
        <title>Gestion des clients</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenu>
        <h1>Gestion des clients</h1>
    <c:choose>
        <c:when test="${adminConnecte}">
            <a href="<spring:url value="/client/ajouter" />">Nouveau client</a>
            <table>
            <thead>
                <tr>
                    <th>Id </th>
                    <th>Prénom </th>
                    <th>Nom </th>
                    <th>Numéro</th>
                    <th>Rue</th>
                    <th>Code Postal</th>
                    <th>Localité</th>
                    <th>Pays</th>
                    <th>Action 1</th>
                    <th>Action 2</th>
                </tr> 
            </thead>
            <tbody>
            <c:forEach items="${clients}" var="cl">
                <tr>
                    <td>${cl.id}</td>
                    <td>${cl.prenom}</td>
                    <td>${cl.nom}</td>
                    <td>${cl.adresse.num}</td>
                    <td>${cl.adresse.rue}</td>
                    <td>${cl.adresse.codePostal}</td>
                    <td>${cl.adresse.localite}</td>
                    <td>${cl.adresse.pays}</td>
                    <td><a href="<spring:url value="/client/modifier/ ${cl.id}" />">Modifier</a></td>
                    <td><a href="<spring:url value="/client/supprimer/${cl.id}"/>">Supprimer</a></td>
                        
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
