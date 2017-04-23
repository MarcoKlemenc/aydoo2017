package ar.edu.untref.aydoo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SalidaArchivo implements Salida {

    private String nombreArchivo;

    public SalidaArchivo(final String archivo) {

        nombreArchivo = archivo;
        limpiarArchivo();
    }

    public void limpiarArchivo() {

        try {
            Files.write(Paths.get(nombreArchivo), "".getBytes());
        } catch (Exception e) {

        }
    }

    public void escribirLinea(final String texto) {

        String valor = texto + "\n";
        try {
            Files.write(Paths.get(nombreArchivo), valor.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (Exception e) {

        }
    }
}
