package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class Compra {

    private final int cantidad;
    private final Producto producto;
    private Sucursal sucursal;
    private Tarjeta tarjeta;

    public Compra(int cantidadDeCompra, Producto producto, Sucursal sucursal, Tarjeta tarjeta) {
        this.cantidad =  cantidadDeCompra;
        this.producto = producto;
        this.sucursal = sucursal;
        this.tarjeta = tarjeta;
        sucursal.registrarCompra(this);
    }

    public int calcularMontoBruto() {
        return cantidad * producto.getPrecio();
    }

    public int calcularMontoNeto() {
        return sucursal.aplicarDescuento(calcularMontoBruto(), tarjeta);
    }
}
