package ar.edu.untref.aydoo;

public class Articulo {

    private String nombre;
    private double precio;

    public Articulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = Math.abs(precio);
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio(){
        return this.precio;
    }
}
