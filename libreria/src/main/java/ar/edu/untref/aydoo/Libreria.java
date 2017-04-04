package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;

public class Libreria {

    /*
     * Voy guardando los montos a cobrar a medida que se realizan las compras para que operaciones futuras (como la
     * modificacion de un precio o la eliminacion de un producto) no alteren los valores.
     * La suscripcion se realiza solamente sobre un mes, pero para el caso suministrado no hace falta mas.
     */
    private ArrayList<Cliente> clientes;
    private ArrayList<Articulo> articulos;
    private HashMap<Mes, HashMap<Cliente, Double>> montosPorMes;

    public Libreria() {
        this.clientes = new ArrayList<Cliente>();
        this.articulos = new ArrayList<Articulo>();
        this.montosPorMes = new HashMap<Mes, HashMap<Cliente, Double>>();
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

    public void vender(Cliente cliente, Articulo articulo, Mes mes) {
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

    public void suscribir(Cliente cliente, Publicacion publicacion, Mes mes, Integer meses) {
        if (this.clientes.contains(cliente) && this.articulos.contains(publicacion)) {
            cliente.suscribirse(publicacion, meses == 12);
            if (!montosPorMes.containsKey(mes)) {
                montosPorMes.put(mes, new HashMap<Cliente, Double>());
            }
            HashMap<Cliente, Double> clientesDeMes = montosPorMes.get(mes);
            Double precioMensual = publicacion.getPrecio() * publicacion.getEdicionesPorMes() * (meses == 12 ? 0.8 : 1);
            if (!clientesDeMes.containsKey(cliente)) {
                clientesDeMes.put(cliente, precioMensual);
            } else clientesDeMes.put(cliente, clientesDeMes.get(cliente) + precioMensual);
        }
    }

    public Double calcularMontoACobrar(Mes mes, Cliente cliente) {
        return montosPorMes.get(mes).get(cliente);
    }
}
