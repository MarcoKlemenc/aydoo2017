package ar.edu.untref.aydoo;

import java.util.Set;

public class Beneficio2x1 {

    public Beneficio2x1(Establecimiento establecimiento) {

        establecimiento.setBeneficio2x1(this);
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

    public int aplicar(Set<Producto> productos) throws UnSoloProductoException {

        if (productos.size() >= 2) {
            int montoARestar = buscarMasBarato(productos);
            int total = 0;
            for (Producto p : productos) {
                total += p.getPrecio();
            }
            return total - montoARestar;
        } else {
            throw new UnSoloProductoException();
        }
    }
}
