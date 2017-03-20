package servlets;

import clases.EscrituraXML;
import clases.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static clases.Tarea.listaTareas;

/**
 * Created by Aarón on 12/03/2017.
 */
@WebServlet(name = "/controlador")
public class controlador extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parametro = request.getParameter("accion");
        String vista = "index.jsp";

        HttpSession session = request.getSession();
        Usuario a = (Usuario) session.getAttribute("usuario");

        switch (parametro){
            case "mostrar":
                vista = "mostrar.jsp";
                break;

            case "crear":
                vista = "crear.jsp";
                break;

            case "inicio":
                vista ="index.jsp";
                break;

            case "exit":
                vista ="login.jsp";
                session.invalidate();
                break;
        }


        EscrituraXML xml1 = new EscrituraXML();



        try {
            //init?
            if (listaTareas.size() == 0) {
                xml1.lecturaXML(a.getNombre());
            }

        }catch (Exception e){
            System.out.println("aun no tienes tareas");
        }

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        request.setAttribute("tareas",listaTareas);
        rd.forward(request,response);
    }
}
