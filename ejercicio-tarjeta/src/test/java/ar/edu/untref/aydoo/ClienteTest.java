package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

    @Test
    public void debeCrearseConNombreYMail(){
        String nombre = "juan";
        String email = "juan@gmail.com";
        Cliente juan = new Cliente(nombre, email);

        assertEquals(nombre, juan.getNombre());
        assertEquals(email, juan.getEmail());

    }

}
