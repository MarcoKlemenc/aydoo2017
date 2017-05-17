package ar.edu.untref.aydoo;

import java.util.Set;

public class Beneficio2x1 implements Beneficio {

    public Beneficio2x1(final Establecimiento establecimiento) {

        establecimiento.setBeneficioClassic(this);
        establecimiento.setBeneficioPremium(this);
    }

    private int buscarMenorPrecio(final Set<Producto> productos) {

        int masBarato = -1;
        for (Producto p : productos) {
            int precio = p.getPrecio();
            if (precio < masBarato || masBarato == -1) {
                masBarato = precio;
            }
        }
        return masBarato;
    }

    public int aplicar(final Compra compra) {

        Set<Producto> productos = compra.getProductosKeySet();
        int total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        int menorPrecio = buscarMenorPrecio(productos);
        if (productos.size() >= 2 && total - menorPrecio >= 100) {
            total -= menorPrecio;
        }
        return total;
    }
}
