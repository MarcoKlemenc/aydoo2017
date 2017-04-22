package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FormatoPrettyTest {

    FormatoPretty f;

    @Before
    public void setUp(){
        f = new FormatoPretty();
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoPretty() {

        ArrayList<Integer> factores = CalculadoraFactoresPrimos3.calcularFactoresPrimos(1);
        String esperado = "Factores primos 1: ";

        String texto = f.aplicar(factores, "1");

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoPretty() {

        ArrayList<Integer> factores = CalculadoraFactoresPrimos3.calcularFactoresPrimos(2);
        String esperado = "Factores primos 2: 2 ";

        String texto = f.aplicar(factores, "2");

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoPretty() {

        ArrayList<Integer> factores = CalculadoraFactoresPrimos3.calcularFactoresPrimos(40);
        String esperado = "Factores primos 40: 2 2 2 5 ";

        String texto = f.aplicar(factores, "40");

        Assert.assertEquals(esperado, texto);
    }
}
