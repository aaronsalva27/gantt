package servlets;

import clases.EscrituraXML;
import clases.Subtarea;
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

import static clases.Subtarea.listaSubTareas;
import static clases.Tarea.listaTareas;

/**
 * Created by Aarón on 17/03/2017.
 */
@WebServlet(name = "/tareas")
public class tareas extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] nombre = request.getParameterValues("nombreT");
        String[] tiempo = request.getParameterValues("tiempoT");
        String[] inicio = request.getParameterValues("inicioT");
        String[] finaliza = request.getParameterValues("finalizaT");
        String[] estado = request.getParameterValues("estadoT");

        String vista = "index.jsp";

        HttpSession session = request.getSession();

        listaSubTareas.clear();

        for (int a = 0;a<nombre.length;a++) {
            Subtarea subtarea = new Subtarea(nombre[a], Integer.parseInt(tiempo[a]), Integer.parseInt(inicio[a]),Integer.parseInt(finaliza[a]),Integer.parseInt(estado[a]));
            System.out.println(subtarea);
            listaSubTareas.add(subtarea);

        }

        Tarea tarea2 = (Tarea) session.getAttribute("nombreTarea");

        EscrituraXML xml3 = new EscrituraXML();
        xml3.crearXMLTareas(tarea2.getNombre());

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);


    }
}
