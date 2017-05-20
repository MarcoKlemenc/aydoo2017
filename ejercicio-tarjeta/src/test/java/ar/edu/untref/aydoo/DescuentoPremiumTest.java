package ar.edu.untref.aydoo;

import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class DescuentoPremiumTest {

    Establecimiento establecimiento;

    @Before
    public void setUp() {

        establecimiento = new Establecimiento(null);
    }

    @Test(expected = PorcentajeInvalidoException.class)
    public void debeLanzarExcepcionConPorcentajeInferiorA5() throws PorcentajeInvalidoException {

        int porcentaje = 4;
        Descuento descuento = new DescuentoPremium(porcentaje, null);
    }

    @Test
    public void debeFijarPorcentaje() throws PorcentajeInvalidoException {

        int porcentaje = 10;
        Descuento descuento = new DescuentoPremium(porcentaje, establecimiento);

        assertEquals(porcentaje, descuento.getPorcentaje());
    }

    @Test
    public void debeFijarseEnEstablecimiento() throws PorcentajeInvalidoException {

        int porcentaje = 10;
        Descuento descuento = new DescuentoPremium(porcentaje, establecimiento);

        assertEquals(descuento, establecimiento.getBeneficioPremium());
    }

    @Test
    public void debeAplicarseACompra() throws PorcentajeInvalidoException {

        Sucursal sucursal = new Sucursal(null, establecimiento);
        Cliente cliente = new Cliente(null, null);
        Tarjeta tarjeta = new TarjetaPremium(cliente);
        int descuento = 20;
        Descuento veintePorciento = new DescuentoPremium(descuento, establecimiento);

        String nombreHelado = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombreHelado, precio, establecimiento);
        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 1;
        productos.put(helado, cantidad);
        Compra compra = new Compra(sucursal, tarjeta, productos);

        int total = 8;
        assertEquals(total, veintePorciento.aplicar(compra));
    }
}
