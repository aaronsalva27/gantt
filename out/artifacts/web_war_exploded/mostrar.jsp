<%--
  Created by IntelliJ IDEA.
  User: Aarón
  Date: 12/03/2017
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="error.jsp" %>
<html>
<head>
    <title>mostrar</title>
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
                <h3>Tus proyectos</h3>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div id="contenido">
                <form action="/controlador">
                    <button type="submit" value="inicio" name="accion" class="btn btn-default">
                        Inicio <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    </button>
                </form>
            </div>
            <ct:lista/>
        </div>
    </div>






</div>

</body>
</html>
