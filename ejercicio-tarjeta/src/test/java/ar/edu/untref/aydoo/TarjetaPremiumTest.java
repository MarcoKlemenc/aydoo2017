package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TarjetaPremiumTest {

    @Test
    public void debeCrearseConCliente() {

        String nombre = "juan";
        String email = "juan@gmail.com";
        Cliente juan = new Cliente(nombre, email);

        Tarjeta visa = new TarjetaPremium(juan);

        assertEquals(juan, visa.getCliente());
    }

    @Test
    public void debeRegistrarseUnaCompra() {

        String nombre = "juan";
        String email = "juan@gmail.com";
        Cliente juan = new Cliente(nombre, email);
        Tarjeta visa = new TarjetaPremium(juan);

        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        Compra unaCompra = new Compra(frioCaseros, visa);
        unaCompra.agregar(helado, 2);

        assertEquals(1, visa.getCompras().size());
    }
}
