package ar.edu.untref.aydoo;

import java.util.Map;
import java.util.Set;

public class Beneficio2x1 implements Beneficio {

    private static final int PRECIO_MINIMO = 100;

    public Beneficio2x1(final Establecimiento establecimiento) {

        establecimiento.setBeneficioClassic(this);
        establecimiento.setBeneficioPremium(this);
    }

    private Producto buscarProductoMasBarato(final Set<Producto> productos) {

        int menorPrecio = Integer.MAX_VALUE;
        Producto masBarato = null;
        for (Producto p : productos) {
            int precio = p.getPrecio();
            if (precio < menorPrecio) {
                menorPrecio = precio;
                masBarato = p;
            }
        }
        return masBarato;
    }

    private Producto buscarSegundoProductoMasBarato(
            final Set<Producto> productos, final Producto masBarato) {

        int segundoMenorPrecio = Integer.MAX_VALUE;
        Producto segundoMasBarato = null;
        for (Producto p : productos) {
            int precio = p.getPrecio();
            if (precio < segundoMenorPrecio && p != masBarato) {
                segundoMenorPrecio = precio;
                segundoMasBarato = p;
            }
        }
        return segundoMasBarato;
    }

    public int aplicar(final Compra compra) {

        Map<Producto, Integer> productos = compra.getProductos();
        int total = 0;
        int cantidad = 0;
        for (Map.Entry<Producto, Integer> e : productos.entrySet()) {
            total += e.getKey().getPrecio() * e.getValue();
            cantidad += e.getValue();
        }

        if (cantidad >= 2) {
            Producto masBarato = buscarProductoMasBarato(productos.keySet());
            int menorPrecio = masBarato.getPrecio();
            int segundoMenorPrecio;
            if (productos.get(masBarato).equals(1)) {
                Producto segundoMasBarato = buscarSegundoProductoMasBarato(
                        productos.keySet(), masBarato);
                segundoMenorPrecio = segundoMasBarato.getPrecio();
            } else {
                segundoMenorPrecio = menorPrecio;
            }
            if (segundoMenorPrecio >= PRECIO_MINIMO) {
                total -= menorPrecio;
            }
        }
        return total;
    }
}
