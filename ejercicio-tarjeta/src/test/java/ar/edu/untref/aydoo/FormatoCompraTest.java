package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class FormatoCompraTest {

    Establecimiento establecimiento;
    Sucursal sucursal;
    Cliente cliente;
    Tarjeta tarjeta;
    Beneficio beneficio;
    FormatoCompra formato;

    @Before
    public void SetUp() throws PorcentajeInvalidoException{

        String nombreEstablecimiento = "Establecimiento";
        establecimiento = new Establecimiento(nombreEstablecimiento);
        sucursal = new Sucursal(null, establecimiento);
        cliente = new Cliente(null, null);
        tarjeta = new TarjetaClassic(cliente);
        int porcentaje = 10;
        beneficio = new DescuentoClassic(porcentaje, establecimiento);
        formato = new FormatoCompra();
    }

    @Test
    public void DebeFormatearCompraConUnProducto() {

        String nombre = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombre, precio, establecimiento);
        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        String esperado = "Establecimiento | Helado x 2 | 20 | 2";
        assertEquals(esperado, formato.formatear(compra));
    }

    @Test
    public void DebeFormatearCompraSinProductos() {

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        Compra compra = new Compra(sucursal, tarjeta, productos);

        String esperado = "Establecimiento | - | 0 | 0";
        assertEquals(esperado, formato.formatear(compra));
    }

    @Test
    public void DebeFormatearCompraConDosProductos() {

        String nombreTeclado = "Teclado";
        int precioTeclado = 100;
        Producto teclado = new Producto(nombreTeclado, precioTeclado, establecimiento);
        String nombreMouse = "Mouse";
        int precioMouse = 50;
        Producto mouse = new Producto(nombreMouse, precioMouse, establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidadTeclado = 2;
        productos.put(teclado, cantidadTeclado);
        int cantidadMouse = 2;
        productos.put(mouse, cantidadMouse);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        String esperado = "Establecimiento | Mouse x 2 - Teclado x 2 | 300 | 30";
        assertEquals(esperado, formato.formatear(compra));
    }
}
