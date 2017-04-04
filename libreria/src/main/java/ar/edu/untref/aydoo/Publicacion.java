package ar.edu.untref.aydoo;

public class Publicacion extends Articulo {

    // La periodicidad implica cada cuantos dias se lanza una edicion
    private int periodicidad;

    // Si la periodicidad es negativa o cero, tiro un error.
    public Publicacion(String nombre, double precio, int periodicidad) {
        super(nombre, precio);
        if (periodicidad > 0) {
            this.periodicidad = periodicidad;
        } else throw new Error("Datos invalidos");
    }

    public int getPeriodicidad() {
        return this.periodicidad;
    }

    public int getEdicionesPorMes() {
        return 30 / this.periodicidad;
    }
}
