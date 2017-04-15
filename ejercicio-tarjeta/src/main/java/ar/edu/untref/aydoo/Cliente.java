package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class Cliente {
    private final String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.email = email;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

}
