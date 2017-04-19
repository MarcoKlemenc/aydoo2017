package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TarjetaClassicTest {

    @Test
    public void debeCrearseConCliente() {

        String nombre = "juan";
        String email = "juan@gmail.com";
        Cliente juan = new Cliente(nombre, email);

        Tarjeta visa = new TarjetaClassic(juan);

        assertEquals(juan, visa.getCliente());
    }

    @Test
    public void debeRegistrarseUnaCompra() {

        String nombre = "juan";
        String email = "juan@gmail.com";
        Cliente juan = new Cliente(nombre, email);
        Tarjeta visa = new TarjetaClassic(juan);

        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        TreeMap<Producto, Integer> productos = new TreeMap<Producto, Integer>();
        int cantidadDeCompra = 2;
        productos.put(helado, cantidadDeCompra);
        Compra unaCompra = new Compra(frioCaseros, visa, productos);

        assertEquals(1, visa.getCompras().size());
    }
}
