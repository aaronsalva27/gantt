package clases;

import java.util.ArrayList;

/**
 * Created by Aarón on 16/03/2017.
 */
public class Usuario {
    private String nombre;
    private String contraseña;
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
