package servlets;

import clases.EscrituraXML;
import clases.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static clases.Usuario.listaUsuarios;

/**
 * Created by Aarón on 16/03/2017.
 */
@WebServlet(name = "/registro")
public class registro extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String contraseña = request.getParameter("password");

        Usuario usuario1 = new Usuario(nombre,contraseña);
        EscrituraXML xml2  = new EscrituraXML();

        listaUsuarios.add(usuario1);
        xml2.crearXMLUsuario();

        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request,response);
    }
}
