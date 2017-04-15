package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nicopaez on 4/12/17.
 */
public class ClienteTest {

    @Test
    public void debeCrearseConMail(){
        String email = "juan@gmail.com";
        Cliente juan = new Cliente("juan", email);

        assertEquals(email, juan.getEmail());

    }

}
