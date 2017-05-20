package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class Beneficio2x1Test {

    Establecimiento establecimiento;
    Beneficio2x1 beneficio;

    @Before
    public void setUp() {

        establecimiento = new Establecimiento(null);
        beneficio = new Beneficio2x1(establecimiento);
    }

    @Test
    public void debeFijarseABeneficioClassic() {

        assertEquals(beneficio, establecimiento.getBeneficioClassic());
    }

    @Test
    public void debeFijarseABeneficioPremium() {

        assertEquals(beneficio, establecimiento.getBeneficioPremium());
    }

    @Test
    public void debeAplicarseConDosProductosIguales() {

        String nombreZapatillas = "Zapatillas";
        int precioZapatillas = 120;
        Producto zapatillas = new Producto(nombreZapatillas, precioZapatillas,
                establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(zapatillas, cantidad);

        Sucursal sucursal = new Sucursal(null, establecimiento);
        Cliente cliente = new Cliente(null, null);
        TarjetaClassic tarjeta = new TarjetaClassic(cliente);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int precioFinal = 120;
        assertEquals(precioFinal, beneficio.aplicar(compra));
    }

    @Test
    public void debeAplicarseConTresProductos() {

        String nombreZapatillas = "Zapatillas";
        int precioZapatillas = 200;
        Producto zapatillas = new Producto(nombreZapatillas, precioZapatillas,
                establecimiento);

        String nombreRemera = "Remera";
        int precioRemera = 120;
        Producto remera = new Producto(nombreRemera, precioRemera,
                establecimiento);

        String nombrePelota = "Pelota";
        int precioPelota = 40;
        Producto pelota = new Producto(nombrePelota, precioPelota,
                establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 1;
        productos.put(zapatillas, cantidad);
        productos.put(remera, cantidad);
        productos.put(pelota, cantidad);

        Sucursal sucursal = new Sucursal(null, establecimiento);
        Cliente cliente = new Cliente(null, null);
        TarjetaClassic tarjeta = new TarjetaClassic(cliente);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int precioFinal = 320;
        assertEquals(precioFinal, beneficio.aplicar(compra));
    }

    @Test
    public void debeAplicarseDosProductosDeMismoPrecio() {

        String nombreZapatillas = "Zapatillas";
        int precioZapatillas = 120;
        Producto zapatillas = new Producto(nombreZapatillas, precioZapatillas,
                establecimiento);

        String nombreRemera = "Remera";
        int precioRemera = 120;
        Producto remera = new Producto(nombreRemera, precioRemera,
                establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 1;
        productos.put(zapatillas, cantidad);
        productos.put(remera, cantidad);

        Sucursal sucursal = new Sucursal(null, establecimiento);
        Cliente cliente = new Cliente(null, null);
        TarjetaClassic tarjeta = new TarjetaClassic(cliente);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int precioFinal = 120;
        assertEquals(precioFinal, beneficio.aplicar(compra));
    }

    @Test
    public void noDebeAplicarConUnSoloProducto() {

        String nombreZapatillas = "Zapatillas";
        int precioZapatillas = 90;
        Producto zapatillas = new Producto(nombreZapatillas, precioZapatillas,
                establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 1;
        productos.put(zapatillas, cantidad);

        Sucursal sucursal = new Sucursal(null, establecimiento);
        Cliente cliente = new Cliente(null, null);
        TarjetaClassic tarjeta = new TarjetaClassic(cliente);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int precioFinal = 90;
        assertEquals(precioFinal, beneficio.aplicar(compra));
    }

    @Test
    public void noDebeAplicarSiPrecioMayorEsMenorA100() {

        String nombreZapatillas = "Zapatillas";
        int precioZapatillas = 90;
        Producto zapatillas = new Producto(nombreZapatillas, precioZapatillas,
                establecimiento);

        String nombreRemera = "Remera";
        int precioRemera = 50;
        Producto remera = new Producto(nombreRemera, precioRemera,
                establecimiento);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 1;
        productos.put(remera, cantidad);
        productos.put(zapatillas, cantidad);

        Sucursal sucursal = new Sucursal(null, establecimiento);
        Cliente cliente = new Cliente(null, null);
        TarjetaClassic tarjeta = new TarjetaClassic(cliente);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int precioFinal = 140;
        assertEquals(precioFinal, beneficio.aplicar(compra));
    }
}
