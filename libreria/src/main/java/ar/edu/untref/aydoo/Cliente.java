package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente {

    private ArrayList<Articulo> articulosComprados;
    private HashMap<Publicacion, Boolean> suscripciones;
    private String nombre, direccion;
    private int dni;

    // Si el DNI es negativo o el nombre o direccion no son validos, tira error
    public Cliente(String nombre, String direccion, int dni) {
        if (dni >= 0 && nombre != null && nombre != "" && direccion != null && direccion != "") {
            this.nombre = nombre;
            this.direccion = direccion;
            this.dni = dni;
            this.articulosComprados = new ArrayList<Articulo>();
            this.suscripciones = new HashMap<Publicacion, Boolean>();
        } else throw new Error("Datos invalidos");
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public int getDni() {
        return this.dni;
    }

    public ArrayList<Articulo> getArticulosComprados() {
        return this.articulosComprados;
    }

    public HashMap<Publicacion, Boolean> getSuscripciones() {
        return this.suscripciones;
    }

    public void comprar(Articulo articulo) {
        this.articulosComprados.add(articulo);
    }

    public void suscribirse(Publicacion publicacion, Boolean anual) {
        this.suscripciones.put(publicacion, anual);
    }
}
