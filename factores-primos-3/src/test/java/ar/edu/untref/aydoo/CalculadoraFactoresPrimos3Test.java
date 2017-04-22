package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void muestraUnErrorAlEspecificarUnFormatoIncorrecto() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.\n";
        String[] argumentos = {"2", "--format=nada"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoPrettyAlIngresarlosPorConsola() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 1: \n";
        String[] argumentos = {"1", "--format=pretty"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoPrettyAlIngresarlosPorConsolaConMayusculas() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 1: \n";
        String[] argumentos = {"1", "--format=pReTtY"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoQuietAlIngresarlosPorConsola() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "\n";
        String[] argumentos = {"1", "--format=quiet"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoQuietAlIngresarlosPorConsolaConMayusculas() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "\n";
        String[] argumentos = {"1", "--format=qUiEt"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaLosFactoresPrimosEnFormatoPrettyAlNoEspecificarFormato() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 2: 2 \n";
        String[] argumentos = {"2"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoPrettyAlIngresarlosPorConsola() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 2: 2 \n";
        String[] argumentos = {"2", "--format=pretty"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoQuietAlIngresarlosPorConsola() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "2\n\n";
        String[] argumentos = {"2", "--format=quiet"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoPrettyAlIngresarlosPorConsola() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 40: 2 2 2 5 \n";
        String[] argumentos = {"40", "--format=pretty"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoQuietAlIngresarlosPorConsola() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "5\n2\n2\n2\n\n";
        String[] argumentos = {"40", "--format=quiet"};

        CalculadoraFactoresPrimos3.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }
}
