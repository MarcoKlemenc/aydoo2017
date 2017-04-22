package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FormatoPrettyTest {

    FormatoPretty f;

    @Before
    public void setUp() {
        f = new FormatoPretty();
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoPretty() {

        List<Integer> factores = CalculadoraFactoresPrimos3.calcular(1);
        String esperado = "Factores primos 1: ";

        String texto = f.aplicar(factores, "1");

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoPretty() {

        List<Integer> factores = CalculadoraFactoresPrimos3.calcular(2);
        String esperado = "Factores primos 2: 2 ";

        String texto = f.aplicar(factores, "2");

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoPretty() {

        List<Integer> factores = CalculadoraFactoresPrimos3.calcular(40);
        String esperado = "Factores primos 40: 2 2 2 5 ";

        String texto = f.aplicar(factores, "40");

        Assert.assertEquals(esperado, texto);
    }
}
