<%-- 
    Document   : _TEMPLATE
    Created on : 29 mai 2017, 14:30:32
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouvelle réservation</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenu>
        <h1>Ajout d'une réservation</h1>
        
    <c:set var="cheminModif">
        <spring:url value="/reservations/ajouter" />
    </c:set>
        
    <form:form modelAttribute="reservation" action="${cheminModif}">
        <label>Client : </label><form:select path="client.id" items="${clients}" itemLabel="prenom" itemValue="id" /><br>
        <label>Date : </label><form:input path="dateReservation" /><br>
        <label>Prix total : </label><form:input path="prixTotal" /><br>
        <label>Etat : </label><form:input path="etatReservation" /><br>
        <!--<label>Chambres : </label><form:select path="chambres" items="${chambres}" itemLabel="nom" itemValue="id" multiple="true"/><br>-->
        <input type="submit" value="Enregistrer" />
        
    </form:form>
        
    </contenu>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
