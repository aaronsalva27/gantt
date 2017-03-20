<%--
  Created by IntelliJ IDEA.
  User: Aarón
  Date: 12/03/2017
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error.jsp" %>
<html>
<head>
    <title>crear</title>
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
            <div id="header">
                <h3 class="text-center">Crear un nuevo Proyecto</h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div id="contenido">
                <form action="/controlador">
                    <button type="submit" value="inicio" name="accion" class="btn btn-default">
                        Inicio <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    </button>
                </form>

                <form action="/nuevaTarea">
                    Nombre de la tarea<input type="text" name="nombre" class="form-control">
                    Tiempo<input type="number" name="tiempo" class="form-control" min="1" max="30">
                    Nombre de Subtareas<input type="number" name="tareas" class="form-control">
                    Inicio <input type="number" name="inicio" class="form-control" min="1" max="30">
                    Finaliza <input type="number"name="finaliza" class="form-control" min="1" max="30">
                    Descripcion <textarea name="descripcion" class="form-control"></textarea>
                    Estado <input type="number" name="estado" class="form-control" min="1" max="30">
                    <input type="submit" value="crear" name="crear" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>


