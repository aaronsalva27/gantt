<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Proyecto</title>
    <meta content="utf-8">
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
            <h2 class="text-center">Proyecto Java Enterprise Gaficos de GANTT</h2>
          </div>
        </div>
      <div>

      <div class="row">
        <div class="col-md-12">
          <div id="contenido">
            <form action="/controlador">
              <button type="submit" value="crear" name="accion" class="btn btn-primary">
                Nuevo <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
              </button>
              <button type="submit" value="mostrar" name="accion" class="btn btn-primary">
                Tus proyectos <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
              </button>
              <button type="submit" value="exit" name="accion" class="btn btn-default pull-right">
                Salir <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
              </button>
            </form>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <div class="descripcion">
            <h4><u>Descripcion</u></h4>
            <p>Se trata de desarrollar una aplicación Web, que presente organizar las tareas de varios
              proyectos mediante diagramas  <a href="https://es.wikipedia.org/wiki/Diagrama_de_Gantt">GANTT</a>.
            </p>
            <p>
              El diagrama de Gantt es una herramienta gráfica
              cuyo objetivo es exponer el tiempo de dedicación
              previsto para diferentes tareas o actividades
              a lo largo de un tiempo total determinado.
              A pesar de esto, el diagrama de Gantt no indica las
              relaciones existentes entre actividades.
            </p>
            <img src="./images/ejemplosvg.svg" class="img-responsive">
          </div>
        </div>
      </div>

    </div>
  </div>
  </div>
  </body>
</html>