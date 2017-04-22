package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SalidaConsolaTest {

    @Test
    public void debeEscribirUnTextoDeEjemploAConsola(){

        SalidaConsola s = new SalidaConsola();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Hola\n";

        String linea = "Hola";
        s.escribirLinea(linea);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void debeEscribirDosRenglonesAConsola(){

        SalidaConsola s = new SalidaConsola();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Linea 1\nLinea 2\n";

        String lineaUno = "Linea 1";
        String lineaDos = "Linea 2";
        s.escribirLinea(lineaUno);
        s.escribirLinea(lineaDos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }
}
