package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nicopaez on 4/12/17.
 */
public class CompraTest {

    @Test
    public void deberiaCalcularMontoBruto() {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new Tarjeta(juan, true);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        Producto helado =  new Producto("helado", 10, heladeriaFrio);
        Compra unaCompra = new Compra(2,helado, frioCaseros, null);

        assertEquals(20, unaCompra.calcularMontoBruto());
    }

    @Test
    public void deberiaCalcularMontoNeto() {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new Tarjeta(juan, true);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        DescuentoParaTarjetaPremium diezPorcientoFrio = new DescuentoParaTarjetaPremium(10, heladeriaFrio);
        Producto helado =  new Producto("helado", 10, heladeriaFrio);
        Compra unaCompra = new Compra(2,helado, frioCaseros, visa);

        assertEquals(18, unaCompra.calcularMontoNeto());
    }
}
