package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TarjetaTest {

    @Test
    public void debeCrearseConClienteYSiEsPremium() {

        String nombre = "juan";
        String email = "juan@gmail.com";
        boolean esPremium = true;
        Cliente juan = new Cliente(nombre, email);

        Tarjeta visa = new Tarjeta(juan, esPremium);

        assertEquals(juan, visa.getCliente());
        assertEquals(esPremium, visa.esPremium());
    }

    @Test
    public void debeRegistrarseUnaCompra() {

        String nombre = "juan";
        String email = "juan@gmail.com";
        boolean esPremium = true;
        Cliente juan = new Cliente(nombre, email);
        Tarjeta visa = new Tarjeta(juan, esPremium);

        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        Compra unaCompra = new Compra(frioCaseros, visa);
        unaCompra.agregar(helado, 2);

        assertEquals(1, visa.getCompras().size());
    }
}
