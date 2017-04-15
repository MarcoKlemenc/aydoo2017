package ar.edu.untref.aydoo;

public class Producto {
    public String getNombre() {
        return nombre;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    private final String nombre;
    private final Establecimiento establecimiento;
    private int precio;

    public Producto(String nombre, int precioUnitario, Establecimiento establecimiento) {
        this.precio = precioUnitario;
        this.nombre = nombre;
        this.establecimiento = establecimiento;
    }

    public int getPrecio() {
        return precio;
    }
}
