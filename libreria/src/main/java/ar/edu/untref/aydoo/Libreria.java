package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Libreria {

    private ArrayList<Cliente> clientes;
    private ArrayList<Articulo> articulos;

    public Libreria() {
        this.clientes = new ArrayList<Cliente>();
        this.articulos = new ArrayList<Articulo>();
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public ArrayList<Articulo> getArticulos() {
        return this.articulos;
    }

    public void registrar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void registrar(Articulo articulo) {
        this.articulos.add(articulo);
    }

    public void vender(Cliente cliente, Articulo articulo) {
        if (this.clientes.contains(cliente) && this.articulos.contains(articulo)) {
            cliente.comprar(articulo);
        }
    }

    public void suscribir(Cliente cliente, Publicacion publicacion, Boolean anual) {
        if (this.clientes.contains(cliente) && this.articulos.contains(publicacion)) {
            cliente.suscribirse(publicacion, anual);
        }
    }
}
