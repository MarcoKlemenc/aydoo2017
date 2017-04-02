package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

public class CalculadoraFactoresPrimos2Test {

    @Test
    public void testUnoEnPretty() {
        ArrayList<Integer> factores = CalculadoraFactoresPrimos2.calcularFactoresPrimos(1);
        String texto = CalculadoraFactoresPrimos2.formatearPretty(factores, "1");
        String esperado = "Factores primos 1: ";
        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void testUnoEnQuiet() {
        ArrayList<Integer> factores = CalculadoraFactoresPrimos2.calcularFactoresPrimos(1);
        String texto = CalculadoraFactoresPrimos2.formatearQuiet(factores);
        String esperado = "";
        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void testDosEnPretty() {
        ArrayList<Integer> factores = CalculadoraFactoresPrimos2.calcularFactoresPrimos(2);
        String texto = CalculadoraFactoresPrimos2.formatearPretty(factores, "2");
        String esperado = "Factores primos 2: 2 ";
        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void testDosEnQuiet() {
        ArrayList<Integer> factores = CalculadoraFactoresPrimos2.calcularFactoresPrimos(2);
        String texto = CalculadoraFactoresPrimos2.formatearQuiet(factores);
        String esperado = "2\n";
        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void testCuarentaEnPretty() {
        ArrayList<Integer> factores = CalculadoraFactoresPrimos2.calcularFactoresPrimos(40);
        String texto = CalculadoraFactoresPrimos2.formatearPretty(factores, "40");
        String esperado = "Factores primos 40: 2 2 2 5 ";
        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void testCuarentaEnQuiet() {
        ArrayList<Integer> factores = CalculadoraFactoresPrimos2.calcularFactoresPrimos(40);
        String texto = CalculadoraFactoresPrimos2.formatearQuiet(factores);
        String esperado = "5\n2\n2\n2\n";
        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void testEspecificandoFormatoIncorrecto() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.\n";
        String[] argumentos = { "2", "--format=nada" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testUnoSinEspecificarFormato() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 1: \n";
        String[] argumentos = { "1" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testUnoEspecificandoFormatoPretty() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 1: \n";
        String[] argumentos = { "1", "--format=pretty" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testUnoEspecificandoFormatoQuiet() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "\n";
        String[] argumentos = { "1", "--format=quiet" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testDosSinEspecificarFormato() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 2: 2 \n";
        String[] argumentos = { "2" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testDosEspecificandoFormatoPretty() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 2: 2 \n";
        String[] argumentos = { "2", "--format=pretty" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testDosEspecificandoFormatoQuiet() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "2\n\n";
        String[] argumentos = { "2", "--format=quiet" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testCuarentaSinEspecificarFormato() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 40: 2 2 2 5 \n";
        String[] argumentos = { "40" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testCuarentaEspecificandoFormatoPretty() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "Factores primos 40: 2 2 2 5 \n";
        String[] argumentos = { "40", "--format=pretty" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }

    @Test
    public void testCuarentaEspecificandoFormatoQuiet() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String esperado = "5\n2\n2\n2\n\n";
        String[] argumentos = { "40", "--format=quiet" };

        CalculadoraFactoresPrimos2.main(argumentos);
        String salida = new String(baos.toByteArray());

        Assert.assertEquals(esperado, salida);
    }
}
