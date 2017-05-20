package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

    @Test
    public void debeAsignarseUnNombre() {

        String nombre = "juan";
        Cliente juan = new Cliente(nombre, null);

        assertEquals(nombre, juan.getNombre());
    }

    @Test
    public void debeAsignarseUnEmail() {

        String email = "juan@gmail.com";
        Cliente juan = new Cliente(null, email);

        assertEquals(email, juan.getEmail());
    }

    @Test
    public void debeAsignarseUnaTarjeta() {

        Cliente cliente = new Cliente(null, null);
        Tarjeta visa = new TarjetaClassic(cliente);

        assertEquals(visa, cliente.getTarjeta());
    }
}
