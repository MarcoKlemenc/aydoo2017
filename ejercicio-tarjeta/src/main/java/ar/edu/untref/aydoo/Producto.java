package ar.edu.untref.aydoo;

public class Producto implements Comparable<Producto> {

    private final String nombre;
    private final Establecimiento establecimiento;
    private Integer precio;

    public Producto(final String nombreNuevo, final Integer precioNuevo,
                    final Establecimiento establecimientoNuevo) {

        this.precio = precioNuevo;
        this.nombre = nombreNuevo;
        this.establecimiento = establecimientoNuevo;
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

    public int compareTo(final Producto otro) {

        return this.nombre.compareTo(otro.getNombre());
    }
}
