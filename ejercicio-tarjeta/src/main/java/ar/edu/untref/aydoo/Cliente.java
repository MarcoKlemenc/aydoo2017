package ar.edu.untref.aydoo;

public class Cliente {

    private final String nombre;
    private String email;
    private Tarjeta tarjeta;

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

    public Tarjeta getTarjeta() {

        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {

        this.tarjeta = tarjeta;
    }

}
