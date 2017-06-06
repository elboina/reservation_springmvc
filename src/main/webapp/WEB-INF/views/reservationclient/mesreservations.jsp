<%-- 
    Document   : mesreservations
    Created on : 6 juin 2017, 11:18:23
    Author     : formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>Mes réservations</h1>

            <table>
                <thead>
                    <tr>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${reservations}" var="resliste">
                    <tr>
                        <td></td>
                    </tr>
                </tbody>

            </table>

        </contenu>
    <c:import url="../_PIED.jsp"></c:import>
</body>
</html>