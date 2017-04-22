package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SalidaArchivoTest {

    @Test
    public void debeEscribirUnTextoDeEjemploAArchivo() throws IOException {

        String archivo = "ejemplo.txt";
        SalidaArchivo s = new SalidaArchivo(archivo);
        String esperado = "Hola\n";

        String linea = "Hola";
        s.limpiarArchivo();
        s.escribirLinea(linea);
        String salida = new String(Files.readAllBytes(Paths.get(archivo)));

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void debeEscribirDosRenglonesAArchivo() throws IOException {

        String archivo = "ejemplo.txt";
        SalidaArchivo s = new SalidaArchivo(archivo);
        String esperado = "Linea 1\nLinea 2\n";

        String lineaUno = "Linea 1";
        String lineaDos = "Linea 2";
        s.limpiarArchivo();
        s.escribirLinea(lineaUno);
        s.escribirLinea(lineaDos);
        String salida = new String(Files.readAllBytes(Paths.get(archivo)));

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void debeAtraparExcepcionSiNombreEstaEnBlanco() {

        String archivo = "";

        SalidaArchivo s = new SalidaArchivo(archivo);
        s.limpiarArchivo();
        s.escribirLinea(archivo);
    }
}
