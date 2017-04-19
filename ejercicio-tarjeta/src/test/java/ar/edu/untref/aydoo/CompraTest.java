package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class CompraTest {

    @Test
    public void deberiaCalcularMontoBruto() {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        SortedMap<Producto, Integer> productos = new TreeMap<Producto, Integer>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra unaCompra = new Compra(frioCaseros, visa, productos);

        assertEquals(20, unaCompra.calcularMontoBruto());
    }

    @Test
    public void deberiaCalcularMontoNeto() throws PorcentajeInvalidoException {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        DescuentoPremium diezFrio = new DescuentoPremium(10, heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        SortedMap<Producto, Integer> productos = new TreeMap<Producto, Integer>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra unaCompra = new Compra(frioCaseros, visa, productos);

        assertEquals(18, unaCompra.calcularMontoNeto());
    }

    @Test
    public void deberiaCalcularMontoBrutoParaMasDeUnArticulo() throws PorcentajeInvalidoException {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        DescuentoPremium diezFrio = new DescuentoPremium(10, heladeriaFrio);
        Producto unKilo = new Producto("1 kg", 200, heladeriaFrio);
        Producto medioKilo = new Producto("1/2 kg", 120, heladeriaFrio);

        SortedMap<Producto, Integer> productos = new TreeMap<Producto, Integer>();
        int cantidadKilo = 2;
        int cantidadMedioKilo = 1;
        productos.put(unKilo, cantidadKilo);
        productos.put(medioKilo, cantidadMedioKilo);
        Compra unaCompra = new Compra(frioCaseros, visa, productos);

        assertEquals(520, unaCompra.calcularMontoBruto());
    }
}
