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
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../_MENU.jsp"></c:import>
    <contenu>
        <h1>Hello World!</h1>
    <c:set var="newPath">
        <spring:url value="/chambre/modifier"></spring:url>
    </c:set> 
    <form:form modelAttribute="maChambre" action="${newPath}">
        <form:hidden path="id"/>
        <label>Nom : </label> <form:input path="nom"/><br>
        <label>Prix :</label> <form:input path="prix" /><br>
        <label> Hotel : </label> <form:select path="hotel.id"  items="${hotels}" itemLabel="nom" itemValue="id" />
        <input type="submit" value="Envoyer" />
    </form:form>
        
    </contenu>
        <c:import url="../_PIED.jsp"></c:import>
    </body>
</html>
