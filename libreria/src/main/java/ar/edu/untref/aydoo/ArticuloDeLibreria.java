package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Articulo {

    private static double porcentajeIva = 1.21;

    public ArticuloDeLibreria (String nombre, double precio){
        super(nombre, precio);
    }

    @Override
    public double getPrecio(){
        return super.getPrecio() * ArticuloDeLibreria.porcentajeIva;
    }
}
