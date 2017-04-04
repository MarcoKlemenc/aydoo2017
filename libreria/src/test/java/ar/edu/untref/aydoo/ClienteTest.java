package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void testCrearClienteDeberiaFijarNombreDireccionYDni() {
        Cliente ejemplo = new Cliente("Juan Perez", "9 de Julio 123", 11111111);
        Assert.assertEquals("Juan Perez", ejemplo.getNombre());
        Assert.assertEquals("9 de Julio 123", ejemplo.getDireccion());
        Assert.assertEquals(11111111, ejemplo.getDni());
    }

    @Test(expected = Error.class)
    public void testCrearClienteNombreNuloDeberiaDarError() {
        Cliente nombreNulo = new Cliente(null, "9 de Julio 123", 11111111);
    }

    @Test(expected = Error.class)
    public void testCrearClienteNombreVacioDeberiaDarError() {
        Cliente nombreVacio = new Cliente("", "9 de Julio 123", 11111111);
    }

    @Test(expected = Error.class)
    public void testCrearClienteDireccionNulaDeberiaDarError() {
        Cliente direccionNula = new Cliente("Juan Perez", null, 11111111);
    }

    @Test(expected = Error.class)
    public void testCrearClienteDireccionVaciaDeberiaDarError() {
        Cliente direccionVacia = new Cliente("Juan Perez", "", 11111111);
    }

    @Test(expected = Error.class)
    public void testCrearClienteDniNegativoDeberiaDarError() {
        Cliente ejemplo = new Cliente("Juan Perez", "9 de Julio 123", -1);
    }

    @Test
    public void testCrearClienteYComprarArticuloDeberiaGuardarse() {
        Cliente ejemplo = new Cliente("Juan Perez", "9 de Julio 123", 11111111);
        Articulo libro = new Articulo("Libro", 49.99);
        ejemplo.comprar(libro);
        Assert.assertEquals(libro, ejemplo.getArticulosComprados().get(0));
    }

    @Test
    public void testCrearClienteYSuscribirseDeberiaGuardarse() {
        Cliente ejemplo = new Cliente("Juan Perez", "9 de Julio 123", 11111111);
        Publicacion clarin = new Publicacion("Clarin", 15, 1);
        ejemplo.suscribirse(clarin, false);
        Assert.assertTrue(ejemplo.getSuscripciones().keySet().contains(clarin));
    }
}
