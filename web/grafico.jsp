<%--
  Created by IntelliJ IDEA.
  User: Aarón
  Date: 15/03/2017
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="error.jsp" %>
<html>
<head>
    <title>Gráfico</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center">Gráfico to' flama</h3>
            <form action="/controlador">
                <button type="submit" value="inicio" name="accion" class="btn btn-default">
                    Inicio <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                </button>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3 tareas">
            ${tarea}
            <h4> Proyecto: ${tarea.getNombre()}</h4>
            <form action="/modificar">
                Nombre:<input type="text" value="${tarea.getNombre()}" name="nombre" class="form-control"><br>
                Tiempo:<input type="number" value="${tarea.getTiempo()}" name="tiempo" class="form-control"><br>
                Tareas:<input type="number" value="${tarea.getTareas()}" name="tareas" class="form-control"><br>
                Inicio:<input type="number" value="${tarea.getInicio()}" name="inicio" class="form-control"><br>
                Finaliza:<input type="number" value="${tarea.getFinaliza()}" name="finaliza" class="form-control"><br>
                Descripcion:<textarea name="descripcion" class="form-control">${tarea.getDescripcion()}</textarea><br>
                Estado:<input type="number" value="${tarea.getEstado()}" name="estado" class="form-control"><br>

                <ct:subtareas/>

                <input type="submit" name="accion" value="modificar" class="btn btn-primary">
                <input type="submit" name="accion" value="eliminar" class="btn btn-danger">
            </form>

        </div>

        <div class="col-md-9">
            <ct:grafico></ct:grafico>
        </div>
    </div>
</div>

</body>
</html>
