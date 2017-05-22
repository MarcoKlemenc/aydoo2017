package ar.edu.untref.aydoo;

import java.util.SortedMap;

public class FormatoCompra {

    private static final int CARACTERES_A_REMOVER = 3;

    public String formatear(final Compra compra) {

        String establecimiento = compra.getSucursal().getEstablecimiento()
                .getNombre() + " | ";
        String productosComprados;
        if (compra.getProductos().isEmpty()) {
            productosComprados = "-";
        } else {
            productosComprados = "";
            for (SortedMap.Entry<Producto, Integer> e : compra.getProductos()
                    .entrySet()) {
                productosComprados += e.getKey().getNombre() + " x "
                        + e.getValue() + " - ";
            }
            productosComprados = productosComprados.substring(0,
                    productosComprados.length() - CARACTERES_A_REMOVER);
        }

        String montoBruto = " | " + String.valueOf(compra.calcularMontoBruto())
                + " | ";
        String beneficio = String.valueOf(compra.calcularMontoBruto()
                - compra.calcularMontoNeto());
        return establecimiento + productosComprados + montoBruto + beneficio;
    }
}
