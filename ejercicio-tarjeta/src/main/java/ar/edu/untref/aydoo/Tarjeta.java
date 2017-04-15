package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class Tarjeta {
    public Cliente getCliente() {
        return cliente;
    }

    private final Cliente cliente;
    private boolean esPremium;

    public Tarjeta(Cliente cliente, boolean esPremium) {
        this.cliente = cliente;
        this.esPremium = esPremium;
    }

    public boolean esPremium() {
        return esPremium;
    }
}
