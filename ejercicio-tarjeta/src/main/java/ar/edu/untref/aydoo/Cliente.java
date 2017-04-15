package ar.edu.untref.aydoo;

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
