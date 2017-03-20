package servlets;

import clases.EscrituraXML;
import clases.Tarea;
import clases.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static clases.Tarea.listaTareas;

/**
 * Created by Aarón on 12/03/2017.
 */
@WebServlet(name = "/nuevaTarea")
public class nuevaTarea extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Integer tiempo = Integer.parseInt(request.getParameter("tiempo"));
        Integer tareas = Integer.parseInt(request.getParameter("tareas"));
        Integer inicio = Integer.parseInt(request.getParameter("inicio"));
        Integer finaliza = Integer.parseInt(request.getParameter("finaliza"));
        String descripcion = request.getParameter("descripcion");
        Integer estado = Integer.parseInt(request.getParameter("estado"));

        String vista = "nueva.jsp";


        HttpSession session = request.getSession();
        Usuario a = (Usuario) session.getAttribute("usuario");

        Tarea tarea1 = new Tarea(nombre,tiempo,tareas,inicio,finaliza,descripcion,estado);
        listaTareas.add(tarea1);
        session.setAttribute("nombreTarea",tarea1);

        System.out.println(listaTareas);
        EscrituraXML xml1 = new EscrituraXML();



        xml1.crearXML(a.getNombre());

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        request.setAttribute("tarea",tarea1);
        rd.forward(request,response);
    }
}
