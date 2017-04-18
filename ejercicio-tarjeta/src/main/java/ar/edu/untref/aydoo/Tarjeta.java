package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

abstract class Tarjeta {

    private final Cliente cliente;
    private List<Compra> compras;

    public Tarjeta(Cliente cliente) {

        this.compras = new ArrayList<Compra>();
        this.cliente = cliente;
    }

    public List<Compra> getCompras() {

        return this.compras;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public void registrarCompra(Compra compra) {

        compras.add(compra);
    }
}
