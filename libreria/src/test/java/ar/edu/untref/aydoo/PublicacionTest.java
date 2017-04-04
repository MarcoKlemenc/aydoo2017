package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PublicacionTest {

    @Test
    public void testCrearDiarioDeberiaFijarNombrePrecioYPeriodicidad() {
        Publicacion nytimes = new Publicacion("New York Times", 20.0, 1);
        Assert.assertEquals("New York Times", nytimes.getNombre());
        Assert.assertEquals(20, nytimes.getPrecio(), 0.0);
        Assert.assertEquals(1, nytimes.getPeriodicidad());
        Assert.assertEquals(30, nytimes.getEdicionesPorMes());
    }

    @Test
    public void testCrearRevistaDeberiaFijarNombrePrecioYPeriodicidad() {
        Publicacion barcelona = new Publicacion("Barcelona", 30.0, 14);
        Assert.assertEquals("Barcelona", barcelona.getNombre());
        Assert.assertEquals(30, barcelona.getPrecio(), 0.0);
        Assert.assertEquals(14, barcelona.getPeriodicidad());
        Assert.assertEquals(2, barcelona.getEdicionesPorMes());
    }

    @Test(expected = Error.class)
    public void testCrearDiarioNombreNuloDeberiaDarError() {
        Publicacion nombreNulo = new Publicacion(null, 20, 1);
    }

    @Test(expected = Error.class)
    public void testCrearDiarioNombreVacioDeberiaDarError() {
        Publicacion nombreVacio = new Publicacion("", 20, 1);
    }

    @Test(expected = Error.class)
    public void testCrearDiarioPrecioNegativoDeberiaDarError() {
        Publicacion nytimes = new Publicacion("New York Times", -35.0, 1);
    }

    @Test(expected = Error.class)
    public void testCrearRevistaPeriodicidadNegativaDeberiaDarError() {
        Publicacion barcelona = new Publicacion("Barcelona", 30.0, -7);
    }

    @Test(expected = Error.class)
    public void testCrearDiarioPrecioCeroDeberiaDarError() {
        Publicacion nytimes = new Publicacion("New York Times", 0, 1);
    }

    @Test(expected = Error.class)
    public void testCrearRevistaPeriodicidadCeroDeberiaDarError() {
        Publicacion barcelona = new Publicacion("Barcelona", 30.0, 0);
    }
}
