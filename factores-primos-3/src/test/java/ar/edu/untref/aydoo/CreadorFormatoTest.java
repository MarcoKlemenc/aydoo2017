package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreadorFormatoTest {

    CreadorFormato cf = new CreadorFormato();

    @Test
    public void debeCrearFormatoPretty() {

        String tipo = "pretty";
        int numero = 1;
        Formato f = cf.crear(tipo, numero);

        assertTrue(f instanceof FormatoPretty);
    }

    @Test
    public void debeCrearFormatoQuiet() {

        String tipo = "quiet";
        int numero = 1;
        Formato f = cf.crear(tipo, numero);

        assertTrue(f instanceof FormatoQuiet);
    }

    @Test(expected = IllegalArgumentException.class)
    public void debeLanzarExcepcionConFormatoIncorrecto() {

        String tipo = "nada";
        int numero = 1;
        Formato f = cf.crear(tipo, numero);
    }
}
