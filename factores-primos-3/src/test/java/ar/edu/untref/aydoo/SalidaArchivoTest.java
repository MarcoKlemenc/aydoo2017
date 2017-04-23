package ar.edu.untref.aydoo;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class SalidaArchivoTest {

    @Test
    public void debeEscribirUnTextoDeEjemploAArchivo() throws IOException {

        String archivo = "ejemplo.txt";
        SalidaArchivo s = new SalidaArchivo(archivo);
        String esperado = "Hola\n";

        String linea = "Hola";
        s.escribirLinea(linea);
        String salida = new String(Files.readAllBytes(Paths.get(archivo)));

        assertEquals(esperado, salida);

        Files.deleteIfExists(Paths.get(archivo));
    }

    @Test
    public void debeEscribirDosRenglonesAArchivo() throws IOException {

        String archivo = "ejemplo.txt";
        SalidaArchivo s = new SalidaArchivo(archivo);
        String esperado = "Linea 1\nLinea 2\n";

        String lineaUno = "Linea 1";
        String lineaDos = "Linea 2";
        s.escribirLinea(lineaUno);
        s.escribirLinea(lineaDos);
        String salida = new String(Files.readAllBytes(Paths.get(archivo)));

        assertEquals(esperado, salida);

        Files.deleteIfExists(Paths.get(archivo));
    }

    @Test
    public void debeAtraparExcepcionSiNombreEstaEnBlanco() {

        String archivo = "";

        SalidaArchivo s = new SalidaArchivo(archivo);
        s.escribirLinea(archivo);
    }
}
