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

import static clases.Subtarea.listaSubTareas;
import static clases.Tarea.listaTareas;

/**
 * Created by Aarón on 16/03/2017.
 */
@WebServlet(name = "/modificar")
public class modificar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Integer tiempo = Integer.parseInt(request.getParameter("tiempo"));
        Integer tareas = Integer.parseInt(request.getParameter("tareas"));
        Integer inicio = Integer.parseInt(request.getParameter("inicio"));
        Integer finaliza = Integer.parseInt(request.getParameter("finaliza"));
        String descripcion = request.getParameter("descripcion");
        Integer estado = Integer.parseInt(request.getParameter("estado"));

        String accion = request.getParameter("accion");

        String[] nombreSub = request.getParameterValues("nombreSub");
        String[] tiempoSub = request.getParameterValues("tiempoSub");
        String[] inicioSub = request.getParameterValues("inicioSub");
        String[] finalizaSub = request.getParameterValues("finalizaSub");
        String[] estadoSub = request.getParameterValues("estadoSub");



        String vista = "grafico.jsp";
        Integer index;
        Integer indexSub;

        index =getTarea(nombre);


        switch (accion){
            case "modificar":
                listaTareas.get(index).setNombre(nombre);
                listaTareas.get(index).setTiempo(tiempo);
                listaTareas.get(index).setTareas(tareas);

                listaTareas.get(index).setInicio(inicio);
                listaTareas.get(index).setFinaliza(finaliza);
                listaTareas.get(index).setDescripcion(descripcion);
                listaTareas.get(index).setEstado(estado);
                listaTareas.get(index).estado=0;
                try {
                    //listaSubTareas.clear();
                    for (int a = 0; a < tiempoSub.length; a++) {
                        listaSubTareas.get(getSubTarea(nombreSub[a])).setNombre(nombreSub[a]);
                        listaSubTareas.get(getSubTarea(nombreSub[a])).setTiempo(Integer.parseInt(tiempoSub[a]));
                        listaSubTareas.get(getSubTarea(nombreSub[a])).setInicio(Integer.parseInt(inicioSub[a]));
                        listaSubTareas.get(getSubTarea(nombreSub[a])).setFinaliza(Integer.parseInt(finalizaSub[a]));
                        listaSubTareas.get(getSubTarea(nombreSub[a])).setEstado(Integer.parseInt(estadoSub[a]));

                        listaTareas.get(index).estado += -(listaSubTareas.get(getSubTarea(nombreSub[a])).getFinaliza() -
                                listaSubTareas.get(getSubTarea(nombreSub[a])).getEstado() -
                                listaSubTareas.get(getSubTarea(nombreSub[a])).getTiempo());

                    }

                }catch (Exception e){
                    System.out.println("No tiene tascas");
                }
                request.setAttribute("tarea",listaTareas.get(index));
                request.setAttribute("subtareas", listaSubTareas);
                System.out.println("Nuevos: "+listaSubTareas);

                break;

            case "eliminar" :
                listaTareas.remove(listaTareas.get(index));
                vista="index.jsp";
                break;
        }


        System.out.println(listaTareas);
        EscrituraXML xml1 = new EscrituraXML();


        HttpSession session = request.getSession();
        Usuario a = (Usuario) session.getAttribute("usuario");

        xml1.crearXML(a.getNombre());
        xml1.crearXMLTareas(nombre);


        RequestDispatcher rd = request.getRequestDispatcher(vista);

        rd.forward(request,response);


    }


    public int getTarea(String nombre){
        int index =0;
        System.out.println("NOMBRE: "+nombre);
        for (int a =0;a<listaTareas.size();a++){
            if (listaTareas.get(a).getNombre().equals(nombre)){
                index= a;
            }
        }
        return  index;
    }

    public int getSubTarea(String nombre){
        int index =0;

        for (int a =0;a<listaSubTareas.size();a++){
            if (listaSubTareas.get(a).getNombre().equals(nombre)){
                index= a;
            }
        }
        return  index;
    }

}
