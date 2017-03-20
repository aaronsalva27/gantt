package servlets;

import clases.EscrituraXML;
import clases.Tarea;

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
 * Created by Aarón on 15/03/2017.
 */
@WebServlet(name = "grafico")
public class grafico extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer parametro = Integer.parseInt(request.getParameter("tarea"));
        String vista = "grafico.jsp";

        HttpSession session = request.getSession();
        session.setAttribute("nombreTarea2",listaTareas.get(parametro));

        //Tarea tarea3 = (Tarea) session.getAttribute("nombreTarea");
        EscrituraXML xml4 = new EscrituraXML();

        listaSubTareas.clear();

        //System.out.println(tarea3);
        xml4.lecturaXMLTareas(listaTareas.get(parametro).getNombre());

        listaTareas.get(parametro).Subtareas = listaSubTareas;

        System.out.println(listaTareas.get(parametro).Subtareas);

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        request.setAttribute("tarea", listaTareas.get(parametro));
        request.setAttribute("subtareas", listaSubTareas);
        rd.forward(request, response);
    }

}
