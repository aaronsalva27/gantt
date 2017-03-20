<%--
    Document   : taula
    Created on : 27/01/2012, 10:30:00
    Author     : sergi grau
--%>

<%@tag language="java" description="taula" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1">
       <c:forEach  items="${subtareas}" var="tarea">
           <h3>${tarea.nombre}</h3>
           Nombre::<input type="text" name="nombreSub" value="${tarea.nombre}" class="form-control"><br>
           Tiempo:<input type="number" name="tiempoSub" value="${tarea.tiempo}" class="form-control"><br>
           Inicio:<input type="number" name="inicioSub" value="${tarea.inicio}" class="form-control"><br>
           Finaliza:<input type="number" name="finalizaSub" value="${tarea.finaliza}" class="form-control"><br>
           Estado:<input type="number" name="estadoSub" value="${tarea.estado}" class="form-control"><br>
       </c:forEach>
</table>
