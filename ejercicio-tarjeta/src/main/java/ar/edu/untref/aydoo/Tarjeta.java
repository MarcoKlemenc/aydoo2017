package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Tarjeta {

    private final Cliente cliente;
    private List<Compra> compras;
    private boolean esPremium;

    public Tarjeta(Cliente cliente, boolean esPremium) {

        this.compras = new ArrayList<Compra>();
        this.cliente = cliente;
        this.esPremium = esPremium;
    }

    public List<Compra> getCompras() {
        return this.compras;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public boolean esPremium() {

        return esPremium;
    }

    public void registrarCompra(Compra compra) {
        compras.add(compra);
    }
}
