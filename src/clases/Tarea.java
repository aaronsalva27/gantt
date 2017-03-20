package clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Aarón on 12/03/2017.
 */
public class Tarea implements Serializable{
    private String nombre;
    private Integer tiempo;
    private Integer tareas;
    private Integer inicio;
    private Integer finaliza;
    private String descripcion;
    public Integer estado;
    public ArrayList<Subtarea> Subtareas;
    public static ArrayList<Tarea> listaTareas = new ArrayList<>();


    public Tarea(String nombre, Integer tiempo, Integer tareas, Integer inicio, Integer finaliza, String descripcion, Integer estado) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.tareas = tareas;
        this.inicio = inicio;
        this.finaliza = finaliza-inicio+1;
        this.descripcion = descripcion;
        this.estado=0;
    }

    public Integer getTareas() {
        return tareas;
    }

    public void setTareas(Integer tareas) {
        this.tareas = tareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Integer getFinaliza() {
        return finaliza;
    }

    public void setFinaliza(Integer finaliza) {
        this.finaliza = finaliza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", tiempo=" + tiempo +
                ", tareas=" + tareas +
                ", inicio=" + inicio +
                ", finaliza=" + finaliza +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
