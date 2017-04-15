package ar.edu.untref.aydoo;

public class Tarjeta {

    private final Cliente cliente;
    private boolean esPremium;

    public Tarjeta(Cliente cliente, boolean esPremium) {

        this.cliente = cliente;
        this.esPremium = esPremium;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public boolean esPremium() {

        return esPremium;
    }
}
