package ar.edu.untref.aydoo;

import java.util.SortedMap;

public class Compra {

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

    public SortedMap<Producto, Integer> getProductos() {

        return productos;
    }

    public Sucursal getSucursal() {

        return sucursal;
    }

    public Tarjeta getTarjeta() {

        return tarjeta;
    }
}
