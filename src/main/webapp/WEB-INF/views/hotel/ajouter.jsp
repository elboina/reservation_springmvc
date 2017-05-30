<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 14:30:32
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout d'un hôtel</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenu>
        <h1>Ajout d'un hotel</h1>
    <c:set var="nouvChemin">
        <spring:url value="/hotel/ajouter"></spring:url>
    </c:set>
    <form:form modelAttribute="nouvHotel" action="${nouvChemin}">
        <label>Nom :</label> <form:input path="nom" /> <br>
        <label>Numéro  : </label> <form:input path="adresse.num" /><br>
        <label>Rue :</label> <form:input path="adresse.rue" /><br>
        <label>Code Postal: </label><form:input path="adresse.codePostal" /><br>
        <label>Localité : </label><form:input path="adresse.localite" /><br>
        <label>Pays : </label><form:input path="adresse.pays" /><br>
        <input type="submit" value="Enregistrer"/>
    </form:form>
        
        
    </contenu>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
