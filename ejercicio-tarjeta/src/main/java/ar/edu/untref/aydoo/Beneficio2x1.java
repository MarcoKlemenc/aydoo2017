package ar.edu.untref.aydoo;

import java.util.Map;
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

        Set<Producto> productos = compra.getProductos().keySet();
        int total = 0;
        int cantidad = 0;
        for (Map.Entry<Producto, Integer> e : compra.getProductos()
                .entrySet()) {
            total += e.getKey().getPrecio() * e.getValue();
            cantidad += e.getValue();
        }
        int menorPrecio = buscarMenorPrecio(productos);
        if (cantidad >= 2 && total - menorPrecio >= PRECIO_MINIMO) {
            total -= menorPrecio;
        }
        return total;
    }
}
