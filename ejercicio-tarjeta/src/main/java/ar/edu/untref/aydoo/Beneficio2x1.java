package ar.edu.untref.aydoo;

import java.util.Map;

public class Beneficio2x1 implements Beneficio {

    private static final int PRECIO_MINIMO = 100;

    public Beneficio2x1(final Establecimiento establecimiento) {

        establecimiento.setBeneficioClassic(this);
        establecimiento.setBeneficioPremium(this);
    }

    private Producto buscarProductoMasBarato(final Map<Producto, Integer>
                                                     productos) {

        int menorPrecio = Integer.MAX_VALUE;
        Producto masBarato = null;
        for (Producto p : productos.keySet()) {
            int precio = p.getPrecio();
            if (precio < menorPrecio) {
                menorPrecio = precio;
                masBarato = p;
            }
        }
        return masBarato;
    }

    private Producto buscarSegundoProductoMasBarato(
            final Map<Producto, Integer> productos, final Producto masBarato) {

        if (productos.get(masBarato) == 1) {
            int segundoMenorPrecio = Integer.MAX_VALUE;
            Producto segundoMasBarato = null;

            for (Producto p : productos.keySet()) {
                int precio = p.getPrecio();
                if (precio < segundoMenorPrecio && p != masBarato) {
                    segundoMenorPrecio = precio;
                    segundoMasBarato = p;
                }
            }
            return segundoMasBarato;
        }
        return masBarato;
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

            Producto masBarato = buscarProductoMasBarato(productos);
            int menorPrecio = masBarato.getPrecio();
            int segundoMenorPrecio = buscarSegundoProductoMasBarato(productos,
                    masBarato).getPrecio();

            if (segundoMenorPrecio >= PRECIO_MINIMO) {
                total -= menorPrecio;
            }
        }
        return total;
    }
}
