<%--
    Document   : taula
    Created on : 27/01/2012, 10:30:00
    Author     : sergi grau
--%>

<%@tag language="java" description="taula" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table-bordered">
<c:set var="total" scope="session" value="5"/>

    <tr>
        <th>Projecto</th>
        <c:forEach var="j" begin="1" end="30" step="1">
            <th> ${j} </th>
        </c:forEach>
    </tr>
    <tr>
        <td>${tarea.getNombre()}</td>
        <c:forEach var="i" begin="1" end="30" step="1">
            <c:choose>
                <c:when test="${ tarea.getInicio()<=i and tarea.getFinaliza()>=i }">
                    <td style="background-color: ${ tarea.getInicio()<=i and tarea.getEstado()>=i  ? 'gray' : 'green'};"></td>
                </c:when>
                <c:otherwise>
                    <td bgcolor=""></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
    <c:forEach  items="${subtareas}" var="tareas">
        <tr>
            <td>${tareas.getNombre()}</td>
            <c:forEach var="i" begin="1" end="30" step="1">
                <c:choose>
                    <c:when test="${ tareas.getInicio()<=i and tareas.getFinaliza()>=i }">
                        <td style="background-color: ${ tareas.getInicio()<=i and tareas.getEstado()>=i  ? 'gray' : 'aqua'};"></td>
                    </c:when>
                    <c:otherwise>
                        <td bgcolor=""></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </c:forEach>

</table>

