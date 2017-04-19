package ar.edu.untref.aydoo;

import java.util.Set;
import java.util.SortedMap;

public class Compra {

    private SortedMap<Producto, Integer> productos;
    private Sucursal sucursal;
    private Tarjeta tarjeta;

    public Compra(Sucursal sucursal, Tarjeta tarjeta, SortedMap<Producto, Integer> productos) {

        this.productos = productos;
        this.sucursal = sucursal;
        this.tarjeta = tarjeta;
        tarjeta.registrarCompra(this);
        sucursal.registrarCompra();
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

        String establecimiento = sucursal.getEstablecimiento().getNombre() + " | ";
        String productosComprados;
        if (productos.isEmpty()){
            productosComprados = " - ";
        } else {
            productosComprados = "";
            for (SortedMap.Entry<Producto, Integer> e : productos.entrySet()) {
                productosComprados += e.getKey().getNombre() + " x " + e.getValue() + " - ";
            }
            productosComprados = productosComprados.substring(0, productosComprados.length() - 3);
        }

        String montoBruto = " | " + String.valueOf(calcularMontoBruto()) + " | ";
        String beneficio = String.valueOf(calcularMontoBruto() - calcularMontoNeto());
        return establecimiento + productosComprados + montoBruto + beneficio;
    }

    public Set<Producto> getProductos() {

        return productos.keySet();
    }
}
