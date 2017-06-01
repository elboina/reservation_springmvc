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
        <title>Inscription</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"></c:import>
    <contenu>
        <h1>Formulaire d'inscription</h1>
        
    <c:set var="newPath">
        <spring:url value="/inscription"></spring:url>
    </c:set>
        
    <form:form modelAttribute="newUtil" action="${newPath}">
        <label>Identifiant : </label> <form:input path="identifiant" /><br>
        <label>Mot de passe : </label> <form:input path="motDePasse" /><br>
        <label> E-mail : </label> <form:input path="email" /><br>
        <input type="submit" value="Enregistrer" />
    </form:form>
                
    </contenu>
        <c:import url="_PIED.jsp"></c:import>
    </body>
</html>
