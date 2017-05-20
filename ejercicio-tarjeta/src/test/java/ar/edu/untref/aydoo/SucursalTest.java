package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class SucursalTest {

    @Test
    public void debeCrearseConNombreYEstablecimiento() {

        String nombreEstablecimiento = "Nike";
        String nombreSucursal = "Caseros";
        Establecimiento nike = new Establecimiento(nombreEstablecimiento);

        Sucursal caseros = new Sucursal(nombreSucursal, nike);

        assertEquals(nombreSucursal, caseros.getNombre());
        assertEquals(nike, caseros.getEstablecimiento());
    }

    @Test
    public void debeCobrarPrecioBrutoSiNoHayBeneficios() {
        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        SortedMap<Producto, Integer> productos = new TreeMap<Producto, Integer>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra unaCompra = new Compra(frioCaseros, visa, productos);

        assertEquals(unaCompra.calcularMontoBruto(), unaCompra.calcularMontoNeto());
    }
}
