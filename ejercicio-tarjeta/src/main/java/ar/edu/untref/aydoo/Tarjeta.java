package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

abstract class Tarjeta {

    private final Cliente cliente;
    private List<Compra> compras;

    Tarjeta(final Cliente clienteNuevo) {

        this.compras = new ArrayList<>();
        this.cliente = clienteNuevo;
        clienteNuevo.setTarjeta(this);
    }

    public List<Compra> getCompras() {

        return this.compras;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public void registrarCompra(final Compra compra) {

        compras.add(compra);
    }

    abstract int aplicarBeneficio(Compra compra);
}
