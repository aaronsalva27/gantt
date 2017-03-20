<%--
    Document   : taula
    Created on : 27/01/2012, 10:30:00
    Author     : sergi grau
--%>

<%@tag language="java" description="taula" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="index" value="${0}"/>
<table border="1">
    <form action="/tareas">
        <c:forEach begin="1" end="${tarea.getTareas()}" varStatus="loop">
            <h3>Tarea ${index}</h3>
            Nombre:<input type="text" name="nombreT" class="form-control"><br>
            Tiempo:<input type="number" name="tiempoT" class="form-control" min="${tarea.getInicio()}" max="${tarea.getFinaliza()}"><br>
            Inicio:<input type="number" name="inicioT" class="form-control" min="${tarea.getInicio()}" max="${tarea.getFinaliza()}"> <br>
            Finaliza:<input type="number" name="finalizaT" class="form-control" min="${tarea.getInicio()}" max="${tarea.getFinaliza()}"><br>
            Estado:<input type="number" name="estadoT" class="form-control" min="${tarea.getInicio()}" max="${tarea.getFinaliza()}">
            <c:set var="index" value="${index+1}"/>
        </c:forEach>
        <input type="submit" name="enviar" value="enviar"class="btn btn-primary">
    </form>
</table>


