package ar.edu.untref.aydoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SalidaArchivo implements Salida {

    String nombreArchivo;

    public SalidaArchivo(String archivo){
        nombreArchivo = archivo;
    }

    public void limpiarArchivo(){

        try{
            Files.write(Paths.get(nombreArchivo), "".getBytes());
        }catch(Exception e){

        }
    }

    public void escribirLinea(String texto){

        texto += "\n";
        try{
            Files.write(Paths.get(nombreArchivo), texto.getBytes(), StandardOpenOption.APPEND);
        }catch(Exception e){

        }
    }
}
