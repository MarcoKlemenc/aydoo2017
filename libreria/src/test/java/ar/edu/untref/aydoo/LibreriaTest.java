package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

    @Test
    public void testCrearLibreriaDeberiaDarLibreriaVacia() {
        Libreria trampolin = new Libreria();
        Assert.assertEquals(0, trampolin.getArticulos().size());
        Assert.assertEquals(0, trampolin.getClientes().size());
    }

    @Test
    public void testCrearLibreriaRegistrarClienteDeberiaGuardarse() {
        Libreria trampolin = new Libreria();
        Cliente fulano = new Cliente("Fulano", "Peron 789", 11111111);
        trampolin.registrar(fulano);
        Assert.assertEquals(fulano, trampolin.getClientes().get(0));
    }

    @Test
    public void testCrearLibreriaRegistrarArticuloDeberiaGuardarse() {
        Libreria trampolin = new Libreria();
        Articulo libro = new Articulo("Libro", 55);
        trampolin.registrar(libro);
        Assert.assertEquals(libro, trampolin.getArticulos().get(0));
    }

    @Test
    public void testVenderArticuloRegistradoAClienteRegistradoDeberiaRealizarVenta() {
        Libreria trampolin = new Libreria();
        Cliente fulano = new Cliente("Fulano", "Peron 789", 11111111);
        Articulo libro = new Articulo("Libro", 55);
        trampolin.registrar(fulano);
        trampolin.registrar(libro);
        trampolin.vender(fulano, libro);
        Assert.assertEquals(libro, fulano.getArticulosComprados().get(0));
    }

    @Test
    public void testVenderArticuloNoRegistradoAClienteRegistradoDeberiaIgnorarVenta() {
        Libreria trampolin = new Libreria();
        Cliente fulano = new Cliente("Fulano", "Peron 789", 11111111);
        Articulo libro = new Articulo("Libro", 55);
        trampolin.registrar(fulano);
        trampolin.vender(fulano, libro);
        Assert.assertEquals(0, fulano.getArticulosComprados().size());
    }

    @Test
    public void testVenderArticuloRegistradoAClienteNoRegistradoDeberiaIgnorarVenta() {
        Libreria trampolin = new Libreria();
        Cliente fulano = new Cliente("Fulano", "Peron 789", 11111111);
        Articulo libro = new Articulo("Libro", 55);
        trampolin.registrar(libro);
        trampolin.vender(fulano, libro);
        Assert.assertEquals(0, fulano.getArticulosComprados().size());
    }

    @Test
    public void testGuardarSuscripcionRegistradaAClienteRegistradoDeberiaGuardar() {
        Libreria trampolin = new Libreria();
        Cliente fulano = new Cliente("Fulano", "Peron 789", 11111111);
        Publicacion diario = new Publicacion("Diario", 15, 1);
        trampolin.registrar(fulano);
        trampolin.registrar(diario);
        trampolin.suscribir(fulano, diario, false);
        Assert.assertTrue(fulano.getSuscripciones().keySet().contains(diario));
    }

    @Test
    public void testGuardarSuscripcionNoRegistradaAClienteRegistradoDeberiaIgnorar() {
        Libreria trampolin = new Libreria();
        Cliente fulano = new Cliente("Fulano", "Peron 789", 11111111);
        Publicacion diario = new Publicacion("Diario", 15, 1);
        trampolin.registrar(fulano);
        trampolin.suscribir(fulano, diario, false);
        Assert.assertEquals(0, fulano.getSuscripciones().keySet().size());
    }

    @Test
    public void testGuardarSuscripcionRegistradaAClienteNoRegistradoDeberiaIgnorar() {
        Libreria trampolin = new Libreria();
        Cliente fulano = new Cliente("Fulano", "Peron 789", 11111111);
        Publicacion diario = new Publicacion("Diario", 15, 1);
        trampolin.registrar(diario);
        trampolin.suscribir(fulano, diario, false);
        Assert.assertEquals(0, fulano.getSuscripciones().keySet().size());
    }
}
