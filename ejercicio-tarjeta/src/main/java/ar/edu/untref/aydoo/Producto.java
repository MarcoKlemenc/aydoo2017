package ar.edu.untref.aydoo;

public class Producto {

    private final String nombre;
    private final Establecimiento establecimiento;
    private int precio;

    public Producto(String nombre, int precio,
                    Establecimiento establecimiento) {

        this.precio = precio;
        this.nombre = nombre;
        this.establecimiento = establecimiento;
    }

    public String getNombre() {

        return nombre;
    }

    public Establecimiento getEstablecimiento() {

        return establecimiento;
    }

    public int getPrecio() {

        return precio;
    }
}
