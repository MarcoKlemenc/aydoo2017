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
        sucursal.registrarCompra(this);
    }

    public void agregar(Producto producto, int cantidad){
        int cantidadActual = productos.containsKey(producto) ?
                productos.get(producto) : 0;
        productos.put(producto, cantidadActual + cantidad);
    }

    public int calcularMontoBruto() {

        int monto = 0;
        for (Map.Entry<Producto, Integer> e : productos.entrySet()){
            monto += e.getKey().getPrecio() * e.getValue();
        }
        return monto;
    }

    public int calcularMontoNeto() {

        return sucursal.aplicarDescuento(calcularMontoBruto(), tarjeta);
    }
}
