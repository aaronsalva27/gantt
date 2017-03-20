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
import java.io.FileNotFoundException;
import java.io.IOException;

import static clases.Subtarea.listaSubTareas;
import static clases.Tarea.listaTareas;
import static clases.Usuario.listaUsuarios;

/**
 * Created by Aarón on 16/03/2017.
 */
@WebServlet(name = "/autentificacion")
public class autentificacion extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String contraseña = request.getParameter("password");
        String accion = request.getParameter("accion");
        String vista = " ";

        listaTareas.clear();
        listaUsuarios.clear();
        listaSubTareas.clear();

        if(request.getParameter("logout")!=null){
            HttpSession session = request.getSession();
            session.invalidate();
        }

        HttpSession session = request.getSession();

        Usuario usuario = new Usuario(nombre,contraseña);

        EscrituraXML xml2  = new EscrituraXML();

        try {
            xml2.lecturaXMLUsuario();
        } catch (FileNotFoundException e){
            System.out.println("aun no hay usuarios");
        }


        switch (accion){
            case "login":
                if(isUsuario(nombre,contraseña)){
                    session.setAttribute("usuario",usuario);
                    vista="index.jsp";
                    Usuario a = (Usuario) session.getAttribute("usuario");
                    System.out.println(a.getNombre());

                } else {
                    vista="errorLogin.jsp";
                }

                break;

            case"registrar":
                vista ="registro.jsp";
                break;
        }


        RequestDispatcher rd = request.getRequestDispatcher(vista);
        request.setAttribute("usuario",usuario);
        rd.forward(request,response);
    }


    public boolean isUsuario(String nombre,String contraseña){

        for (int a =0;a<listaUsuarios.size();a++){
            if(listaUsuarios.get(a).getNombre().equals(nombre) && listaUsuarios.get(a).getContraseña().equals(contraseña)){
                return true;
            }
        }
        return false;
    }
}
