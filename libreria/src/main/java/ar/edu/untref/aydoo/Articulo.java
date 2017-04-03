package ar.edu.untref.aydoo;

public class Articulo {

    private String nombre;
    private double precio;

    // Si el precio es negativo o cero, tiro un error.
    public Articulo(String nombre, double precio) {
        if (precio > 0) {
            this.nombre = nombre;
            this.precio = precio;
        } else throw new Error("Precio invalido");
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }
}
