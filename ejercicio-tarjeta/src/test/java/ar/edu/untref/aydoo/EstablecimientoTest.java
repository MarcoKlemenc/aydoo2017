package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstablecimientoTest {

    @Test
    public void debeCrearseConNombre() {
        
        String nombre = "Nike";
        Establecimiento nike = new Establecimiento(nombre);

        assertEquals(nombre, nike.getNombre());
    }
}
