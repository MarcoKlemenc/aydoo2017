package ar.edu.untref.aydoo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/*
 * Uso ByteArrayOutputStream y PrintStream para tomar las salidas por consola que hace el main.
 * Después las comparo con lo que debería obtener.
 * Las pruebas giran en base a pocos números porque hay muchos casos cubiertos en las del ejercicio original.
 * Decidí enfocarme más en probar salidas y lectura de argumentos.
 */
public class CalculadoraFactoresPrimos3Test {

    @Test
    public void presentaLosFactoresPrimosEnFormatoPrettyAlEspecificarOtroArgumento() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 2: 2 \n";
        String[] argumentos = {"2", "--algo=nada"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        assertEquals(esperado, salida);
    }

    @Test
    public void muestraUnErrorAlEspecificarUnFormatoIncorrecto() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.\n";
        String[] argumentos = {"2", "--format=nada"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosEnFormatoPrettyAlIngresarlosPorConsola() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 27: 3 3 3 \n";
        String[] argumentos = {"27", "--format=pretty"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosEnFormatoQuietAlIngresarlosPorConsolaConMayusculas() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "\n";
        String[] argumentos = {"1", "--format=qUiEt"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        assertEquals(esperado, salida);
    }

    @Test
    public void presentaLosFactoresPrimosEnFormatoPrettyAlNoEspecificarFormato() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 2: 2 \n";
        String[] argumentos = {"2"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        assertEquals(esperado, salida);
    }

    @Test
    public void escribeLosFactoresPrimosEnArchivoAlUsarElArgumento() throws IOException {

        String archivo = "salida.txt";
        String esperado = "Factores primos 2: 2 \n";
        String[] argumentos = {"2", "--output-file="+archivo};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(Files.readAllBytes(Paths.get(archivo)));

        assertEquals(esperado, salida);
    }
}
