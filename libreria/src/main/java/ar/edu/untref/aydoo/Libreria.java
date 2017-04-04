package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;

public class Libreria {

    private ArrayList<Cliente> clientes;
    private ArrayList<Articulo> articulos;
    private HashMap<String, HashMap<Cliente, Double>> montosPorMes;

    public Libreria() {
        this.clientes = new ArrayList<Cliente>();
        this.articulos = new ArrayList<Articulo>();
        this.montosPorMes = new HashMap<String, HashMap<Cliente, Double>>();
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

    public void vender(Cliente cliente, Articulo articulo, String mes) {
        if (this.clientes.contains(cliente) && this.articulos.contains(articulo)) {
            cliente.comprar(articulo);
            if (!montosPorMes.containsKey(mes)) {
                montosPorMes.put(mes, new HashMap<Cliente, Double>());
            }
            HashMap<Cliente, Double> clientesDeMes = montosPorMes.get(mes);
            if (!clientesDeMes.containsKey(cliente)) {
                clientesDeMes.put(cliente, articulo.getPrecio());
            } else clientesDeMes.put(cliente, clientesDeMes.get(cliente) + articulo.getPrecio());
        }
    }

    public void suscribir(Cliente cliente, Publicacion publicacion, String mes, Integer meses) {
        if (this.clientes.contains(cliente) && this.articulos.contains(publicacion)) {
            cliente.suscribirse(publicacion, meses == 12);
        }
    }

    public Double calcularMontoACobrar(String mes, Cliente cliente) {
        return montosPorMes.get(mes).get(cliente);
    }
}
