package ar.edu.untref.aydoo;

import java.util.Set;

public class Beneficio2x1 implements Beneficio {

    public Beneficio2x1(Establecimiento establecimiento) {

        establecimiento.setBeneficioClassic(this);
        establecimiento.setBeneficioPremium(this);
    }

    private int buscarMasBarato(Set<Producto> productos) {

        int masBarato = -1;
        for (Producto p : productos) {
            int precio = p.getPrecio();
            if (precio < masBarato || masBarato == -1) {
                masBarato = precio;
            }
        }
        return masBarato;
    }

    public int aplicar(Compra compra) {

        Set<Producto> productos = compra.getProductos();
        int total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        total -= (productos.size() >= 2 ? buscarMasBarato(productos) : 0);
        return total;
    }
}
