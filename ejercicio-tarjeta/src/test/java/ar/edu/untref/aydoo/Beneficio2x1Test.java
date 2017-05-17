package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class Beneficio2x1Test {

    @Test
    public void debeCrearseConExito() {

        String nombre = "Nike";
        Establecimiento nike = new Establecimiento(nombre);

        Beneficio2x1 beneficio = new Beneficio2x1(nike);

        assertEquals(beneficio, nike.getBeneficioClassic());
        assertEquals(beneficio, nike.getBeneficioPremium());
    }

    @Test
    public void noDebeAplicarConUnSoloProducto() {

        String nombreEstablecimiento = "Nike";
        Establecimiento nike = new Establecimiento(nombreEstablecimiento);

        Beneficio2x1 beneficio = new Beneficio2x1(nike);

        String nombreZapatillas = "Zapatillas";
        int precioZapatillas = 90;
        Producto zapatillas = new Producto(nombreZapatillas, precioZapatillas, nike);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        productos.put(zapatillas, 1);

        String nombreCaseros = "Caseros";
        Sucursal caseros = new Sucursal(nombreCaseros, nike);

        String nombreCliente = "juan";
        String email = "juan@gmail.com";
        Cliente juan = new Cliente(nombreCliente, email);
        TarjetaClassic visa = new TarjetaClassic(juan);

        Compra compra = new Compra(caseros, visa, productos);

        int precioFinal = 90;
        Assert.assertEquals(precioFinal, beneficio.aplicar(compra));
    }

    @Test
    public void noDebeAplicarSiPrecioMayorEsMenorA100() {

        String nombreEstablecimiento = "Nike";
        Establecimiento nike = new Establecimiento(nombreEstablecimiento);

        Beneficio2x1 beneficio = new Beneficio2x1(nike);

        String nombreZapatillas = "Zapatillas";
        int precioZapatillas = 90;
        Producto zapatillas = new Producto(nombreZapatillas, precioZapatillas, nike);

        String nombreRemera = "Remera";
        int precioRemera = 50;
        Producto remera = new Producto(nombreRemera, precioRemera, nike);

        SortedMap<Producto, Integer> productos = new TreeMap<>();
        productos.put(remera, 1);
        productos.put(zapatillas, 1);

        String nombreCaseros = "Caseros";
        Sucursal caseros = new Sucursal(nombreCaseros, nike);

        String nombreCliente = "juan";
        String email = "juan@gmail.com";
        Cliente juan = new Cliente(nombreCliente, email);
        TarjetaClassic visa = new TarjetaClassic(juan);

        Compra compra = new Compra(caseros, visa, productos);

        int precioFinal = 140;
        Assert.assertEquals(precioFinal, beneficio.aplicar(compra));
    }
}
