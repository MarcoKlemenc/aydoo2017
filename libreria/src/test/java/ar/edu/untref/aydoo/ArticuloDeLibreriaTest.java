package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloDeLibreriaTest {

    @Test
    public void testCrearBiromeDeberiaFijarNombreYPrecioConIva() {
        ArticuloDeLibreria birome = new ArticuloDeLibreria("Birome", 5);
        Assert.assertEquals("Birome", birome.getNombre());
        Assert.assertEquals(6.05, birome.getPrecio(), 0.0);
    }

    @Test(expected = Error.class)
    public void testCrearBiromePrecioNegativoDeberiaDarError() {
        ArticuloDeLibreria birome = new ArticuloDeLibreria("Birome", -10);
    }

    @Test(expected = Error.class)
    public void testCrearBiromePrecioCeroDeberiaDarError() {
        ArticuloDeLibreria birome = new ArticuloDeLibreria("Birome", 0);
    }
}
