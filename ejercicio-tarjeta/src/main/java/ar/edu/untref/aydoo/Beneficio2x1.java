package ar.edu.untref.aydoo;

import java.util.Set;

public class Beneficio2x1 implements Beneficio {

    private static final int PRECIO_MINIMO = 100;

    public Beneficio2x1(final Establecimiento establecimiento) {

        establecimiento.setBeneficioClassic(this);
        establecimiento.setBeneficioPremium(this);
    }

    private int buscarMenorPrecio(final Set<Producto> productos) {

        int menorPrecio = Integer.MAX_VALUE;
        for (Producto p : productos) {
            menorPrecio = Math.min(p.getPrecio(), menorPrecio);
        }
        return menorPrecio;
    }

    public int aplicar(final Compra compra) {

        Set<Producto> productos = compra.getProductosKeySet();
        int total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        int menorPrecio = buscarMenorPrecio(productos);
        if (productos.size() >= 2 && total - menorPrecio >= PRECIO_MINIMO) {
            total -= menorPrecio;
        }
        return total;
    }
}
