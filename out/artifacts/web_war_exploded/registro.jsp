<%--
  Created by IntelliJ IDEA.
  User: Aarón
  Date: 16/03/2017
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error.jsp" %>
<html>
<head>
    <title>Registro</title>
</head>
<body>
<h3>Registro</h3>

<form action="/registro">
    Nombre<input type="text" name="nombre"><br>
    Constraseña<input type="password" name="password"><br>
    <input type="submit" name="registro">
</form>

</body>
</html>
