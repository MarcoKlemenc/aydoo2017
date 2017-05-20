package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class SucursalTest {

    Establecimiento establecimiento;

    @Before
    public void setUp(){

        establecimiento = new Establecimiento(null);
    }

    @Test
    public void debeFijarseUnNombre() {

        String nombreSucursal = "Caseros";
        Sucursal caseros = new Sucursal(nombreSucursal, establecimiento);

        assertEquals(nombreSucursal, caseros.getNombre());
    }

    @Test
    public void debeFijarseUnEstablecimiento() {

        Sucursal sucursal = new Sucursal(null, establecimiento);

        assertEquals(establecimiento, sucursal.getEstablecimiento());
    }

    @Test
    public void debeRegistrarUnaCompra() {

        Sucursal sucursal = new Sucursal(null, establecimiento);
        sucursal.registrarCompra();

        int total = 1;
        assertEquals(total, sucursal.getCantidadBeneficiosOtorgados());
    }

    @Test
    public void debeAplicarDescuento() throws PorcentajeInvalidoException {

        Sucursal sucursal = new Sucursal(null, establecimiento);
        Cliente cliente = new Cliente(null, null);
        Tarjeta tarjeta = new TarjetaClassic(cliente);
        int porcentaje = 40;
        Beneficio beneficio = new DescuentoClassic(porcentaje, establecimiento);

        String nombreHelado = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombreHelado, precio, establecimiento);
        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int total = 12;
        assertEquals(total, sucursal.aplicarDescuento(compra, tarjeta));
    }
}
