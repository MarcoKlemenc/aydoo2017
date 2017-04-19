package ar.edu.untref.aydoo;

public class Cliente {

    private String nombre;
    private String email;
    private Tarjeta tarjeta;

    public Cliente(final String nombreNuevo, final String emailNuevo) {

        email = emailNuevo;
        nombre = nombreNuevo;
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

    public void setTarjeta(final Tarjeta tarjetaNueva) {

        tarjeta = tarjetaNueva;
    }

}
