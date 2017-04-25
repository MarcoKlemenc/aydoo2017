package ar.edu.untref.aydoo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SalidaArchivo implements Salida {

    private String nombreArchivo;

    public SalidaArchivo(final String archivo) {

        nombreArchivo = archivo;
        limpiarArchivo();
    }

    private void limpiarArchivo() {

        try {
            Files.write(Paths.get(nombreArchivo), "".getBytes());
        } catch (IOException e) {
            System.out.println("No se ha podido escribir. Intente con otro "
                    + "archivo.");
        }
    }

    public void escribirLinea(final String texto) {

        String valor = texto + "\n";
        try {
            Files.write(Paths.get(nombreArchivo), valor.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("No se ha podido escribir. Intente con otro "
                    + "archivo.");
        }
    }
}
