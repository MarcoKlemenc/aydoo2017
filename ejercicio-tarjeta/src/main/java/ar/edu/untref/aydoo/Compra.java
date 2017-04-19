package ar.edu.untref.aydoo;

import java.util.Set;
import java.util.SortedMap;

public class Compra {

    private static final int CARACTERES_A_REMOVER = 3;

    private SortedMap<Producto, Integer> productos;
    private Sucursal sucursal;
    private Tarjeta tarjeta;

    public Compra(final Sucursal sucursalNueva, final Tarjeta tarjetaNueva,
                  final SortedMap<Producto, Integer> productosNuevos) {

        productos = productosNuevos;
        sucursal = sucursalNueva;
        tarjeta = tarjetaNueva;
        tarjetaNueva.registrarCompra(this);
        sucursalNueva.registrarCompra();
    }

    public int calcularMontoBruto() {

        int monto = 0;
        for (SortedMap.Entry<Producto, Integer> e : productos.entrySet()) {
            monto += e.getKey().getPrecio() * e.getValue();
        }
        return monto;
    }

    public int calcularMontoNeto() {

        return sucursal.aplicarDescuento(this, tarjeta);
    }

    @Override
    public String toString() {

        String establecimiento = sucursal.getEstablecimiento().getNombre()
                + " | ";
        String productosComprados;
        if (productos.isEmpty()) {
            productosComprados = " - ";
        } else {
            productosComprados = "";
            for (SortedMap.Entry<Producto, Integer> e : productos.entrySet()) {
                productosComprados += e.getKey().getNombre() + " x "
                        + e.getValue() + " - ";
            }
            productosComprados = productosComprados.substring(0,
                    productosComprados.length() - CARACTERES_A_REMOVER);
        }

        String montoBruto = " | " + String.valueOf(calcularMontoBruto())
                + " | ";
        String beneficio = String.valueOf(calcularMontoBruto()
                - calcularMontoNeto());
        return establecimiento + productosComprados + montoBruto + beneficio;
    }

    public Set<Producto> getProductos() {

        return productos.keySet();
    }
}
