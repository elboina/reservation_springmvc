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
        <title>Ajout d'une chambre</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenu>
        <h1>Nouvelle Chambre</h1>
        
    <c:set var="newPath">
        <spring:url value="/chambre/ajouter"></spring:url>
    </c:set>
        
    <form:form modelAttribute="chambre" action="${newPath}">
        <label>Nom : </label> <form:input path="nom" /><br>
        <label>Prix : </label> <form:input path="prix" /><br>
        <label>Hotel : </label> <form:select path="hotel.id" items="${hotels}" itemLabel="nom" itemValue="id" /><br>
        <label>Date check-in : </label> <form:input path="dateCheckIn" /><br>
        <label>Date check-out : </label> <form:input path="dateCheckOut" /><br>
        <label>Nombre de personnes : </label> <form:input path="nbPersonnes" /><br>
        <input type="submit" value="Enregistrer"/>
    </form:form>
        
    </contenu>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
