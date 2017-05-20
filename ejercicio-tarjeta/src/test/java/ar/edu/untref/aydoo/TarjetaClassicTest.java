package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TarjetaClassicTest {

    Cliente cliente;
    Tarjeta tarjeta;

    @Before
    public void setUp() {

        cliente = new Cliente(null, null);
        tarjeta = new TarjetaClassic(cliente);
    }

    @Test
    public void debeFijarseUnCliente() {

        assertEquals(cliente, tarjeta.getCliente());
    }

    @Test
    public void debeRegistrarUnaCompra() {

        Establecimiento establecimiento = new Establecimiento(null);
        Sucursal sucursal = new Sucursal(null, establecimiento);

        String nombre = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombre, precio, establecimiento);
        TreeMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        assertEquals(compra, tarjeta.getCompras().get(0));
    }

    @Test
    public void debeDarMontoBrutoSiNoHayBeneficioClassic() {

        Establecimiento establecimiento = new Establecimiento(null);
        Sucursal sucursal = new Sucursal(null, establecimiento);

        String nombre = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombre, precio, establecimiento);
        TreeMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int total = 20;
        assertEquals(total, tarjeta.aplicarBeneficio(compra));
    }

    @Test
    public void debeAplicarBeneficioClassic() throws PorcentajeInvalidoException {

        Establecimiento establecimiento = new Establecimiento(null);
        Sucursal sucursal = new Sucursal(null, establecimiento);
        int descuento = 20;
        Descuento veintePorciento = new DescuentoClassic(descuento, establecimiento);

        String nombre = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombre, precio, establecimiento);
        TreeMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int total = 16;
        assertEquals(total, tarjeta.aplicarBeneficio(compra));
    }
}
