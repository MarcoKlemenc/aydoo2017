package ar.edu.untref.aydoo;

// Entity
public class Articulo {

    private String nombre;
    private double precio;

    // Si el precio es negativo o cero o el nombre no es valido, tiro un error.
    public Articulo(String nombre, double precio) {
        if (precio > 0 && nombre != null && nombre != "") {
            this.nombre = nombre;
            this.precio = precio;
        } else throw new Error("Datos invalidos");
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }
}
