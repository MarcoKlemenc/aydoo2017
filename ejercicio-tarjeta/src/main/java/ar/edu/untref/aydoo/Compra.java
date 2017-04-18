package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

public class Compra {

    private Map<Producto, Integer> productos;
    private Sucursal sucursal;
    private Tarjeta tarjeta;

    public Compra(Sucursal sucursal, Tarjeta tarjeta) {

        this.productos = new HashMap<Producto, Integer>();
        this.sucursal = sucursal;
        this.tarjeta = tarjeta;
        tarjeta.registrarCompra(this);
        sucursal.registrarCompra(this);
    }

    public void agregar(Producto producto, int cantidad) {
        productos.put(producto, cantidad);
    }

    public int calcularMontoBruto() {

        int monto = 0;
        for (Map.Entry<Producto, Integer> e : productos.entrySet()) {
            monto += e.getKey().getPrecio() * e.getValue();
        }
        return monto;
    }

    public int calcularMontoNeto() {

        return sucursal.aplicarDescuento(calcularMontoBruto(), tarjeta);
    }

    @Override
    public String toString() {

        String establecimiento = sucursal.getEstablecimiento().getNombre() + " | ";
        String productosComprados = "";
        for (Map.Entry<Producto, Integer> e : productos.entrySet()) {
            productosComprados += e.getKey().getNombre() + " x " + e.getValue() + " - ";
        }
        productosComprados = productosComprados.substring(0, productosComprados.length() - 3);
        String montoBruto = " | " + String.valueOf(calcularMontoBruto()) + " | ";
        String beneficio = String.valueOf(calcularMontoBruto() - calcularMontoNeto());
        return establecimiento + productosComprados + montoBruto + beneficio;
    }
}
