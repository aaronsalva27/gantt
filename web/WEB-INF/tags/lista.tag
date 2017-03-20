<%--
    Document   : taula
    Created on : 27/01/2012, 10:30:00
    Author     : sergi grau
--%>

<%@tag language="java" description="taula" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="index" value="${0}"/>
<table border="1">
    <form action="/grafico">
        <select name="tarea" class="form-control">
            <c:forEach  items="${tareas}" var="tarea">
                <option value="${index}" class="form-control"><c:out value="${tarea.nombre}" /></option>
                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </select>
        <input type="submit" name="enviar" value="enviar" class="form-control">
    </form>
</table>