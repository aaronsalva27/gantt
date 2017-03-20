package clases;

import java.util.ArrayList;

/**
 * Created by Aarón on 13/03/2017.
 */
public class Subtarea {
    private String nombre;
    private Integer tiempo;
    private Integer inicio;
    private Integer finaliza;
    private Integer estado;
    public static ArrayList<Subtarea> listaSubTareas = new ArrayList<>();


    public Subtarea(String nombre, Integer tiempo, Integer inicio, Integer finaliza, Integer estado) {
        this.nombre = nombre;
        this.tiempo = finaliza-inicio+1;
        this.inicio = inicio;
        this.finaliza = finaliza;
        this.estado = estado;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Subtarea{" +
                "nombre='" + nombre + '\'' +
                ", tiempo=" + tiempo +
                ", inicio=" + inicio +
                ", finaliza=" + finaliza +
                ", estado='" + estado + '\'' +
                '}';
    }
}
