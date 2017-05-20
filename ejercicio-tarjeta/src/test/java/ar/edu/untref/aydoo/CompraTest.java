package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class CompraTest {

    Establecimiento establecimiento;
    Sucursal sucursal;
    Cliente cliente;
    Tarjeta tarjeta;

    @Before
    public void setUp(){
        establecimiento = new Establecimiento(null);
        sucursal = new Sucursal(null, establecimiento);
        cliente = new Cliente(null, null);
        tarjeta = new TarjetaClassic(cliente);
    }

    @Test
    public void deberiaFijarSucursal() {

        Compra compra = new Compra(sucursal, tarjeta, null);

        assertEquals(sucursal, compra.getSucursal());
    }

    @Test
    public void deberiaFijarTarjeta() {

        Compra compra = new Compra(sucursal, tarjeta, null);

        assertEquals(tarjeta, compra.getTarjeta());
    }

    @Test
    public void deberiaGuardarseEnSucursal() {

        Compra compra = new Compra(sucursal, tarjeta, null);

        int cantidadBeneficios = 1;
        assertEquals(cantidadBeneficios, sucursal.getCantidadBeneficiosOtorgados());
    }

    @Test
    public void deberiaGuardarseEnTarjeta() {

        Compra compra = new Compra(sucursal, tarjeta, null);

        assertEquals(compra, tarjeta.getCompras().get(0));
    }

    @Test
    public void deberiaCalcularMontoBruto() {

        String nombreHelado = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombreHelado, precio, establecimiento);
        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra unaCompra = new Compra(sucursal, tarjeta, productos);

        int total = 20;
        assertEquals(total, unaCompra.calcularMontoBruto());
    }

    @Test
    public void deberiaCalcularMontoNeto() throws PorcentajeInvalidoException {

        int diez = 10;
        Descuento diezPorciento = new DescuentoClassic(diez, establecimiento);
        String nombreLapiz = "Lapiz";
        Producto lapiz = new Producto(nombreLapiz, diez, establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(lapiz, cantidad);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int total = 18;
        assertEquals(total, compra.calcularMontoNeto());
    }

    @Test
    public void deberiaCalcularMontoBrutoParaMasDeUnArticulo() {

        String nombreTeclado = "Teclado";
        int precioTeclado = 100;
        Producto teclado = new Producto(nombreTeclado, precioTeclado, establecimiento);
        String nombreMouse = "Mouse";
        int precioMouse = 50;
        Producto mouse = new Producto(nombreMouse, precioMouse, establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidadTeclado = 2;
        productos.put(teclado, cantidadTeclado);
        int cantidadMouse = 1;
        productos.put(mouse, cantidadMouse);
        Compra unaCompra = new Compra(sucursal, tarjeta, productos);

        int total = 250;
        assertEquals(total, unaCompra.calcularMontoBruto());
    }

    @Test
    public void deberiaCalcularMontoNetoParaMasDeUnArticulo() throws PorcentajeInvalidoException {

        int descuento = 20;
        Descuento veintePorciento = new DescuentoClassic(descuento, establecimiento);

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
        Compra unaCompra = new Compra(sucursal, tarjeta, productos);

        int total = 240;
        assertEquals(total, unaCompra.calcularMontoNeto());
    }
}
