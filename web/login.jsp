<%--
  Created by IntelliJ IDEA.
  User: Aarón
  Date: 16/03/2017
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="errorLogin.jsp" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">
    <div class="wrapper">

        <form action="/autentificacion" class="form-signin">
            <h3>Porfavor Inicie Sesión</h3>
            <input type="text" name="nombre" class="form-control" placeholder="Nombre"><br>
            <input type="password" name="password" class="form-control" placeholder="Contraseña"><br>
            <input type="submit" name="accion" value="login" class="btn btn-primary btn-lg btn-block">
            <input type="submit" name="accion" value="registrar" class="btn btn-primary btn-lg btn-block">
        </form>
    </div>

</div>
</body>
</html>
