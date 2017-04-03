package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloTest {

    @Test
    public void testCrearArticuloDeberiaFijarNombreYPrecio() {
        Articulo ejemplo = new Articulo("Ejemplo", 10);
        Assert.assertEquals("Ejemplo", ejemplo.getNombre());
        Assert.assertEquals(10, ejemplo.getPrecio(), 0.0);
    }

    @Test(expected = Error.class)
    public void testCrearArticuloPrecioNegativoDeberiaDarError() {
        Articulo negativo = new Articulo("Precio negativo", -15);
    }

    @Test(expected = Error.class)
    public void testCrearArticuloPrecioCeroDeberiaDarError() {
        Articulo cero = new Articulo("Precio 0", 0);
    }
}
