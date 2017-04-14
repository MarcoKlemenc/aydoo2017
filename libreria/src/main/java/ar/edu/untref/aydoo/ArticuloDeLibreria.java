package ar.edu.untref.aydoo;

// Entity
public class ArticuloDeLibreria extends Articulo {

    // Puse el IVA en una variable aparte por si en algun momento se debe modificar
    private static double porcentajeIva = 1.21;

    public ArticuloDeLibreria(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * ArticuloDeLibreria.porcentajeIva;
    }
}
