package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FormatoPrettyTest {

    FormatoPretty f;

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoPretty() {

        int valor = 1;
        List<Integer> factores = Arrays.asList();
        String esperado = "Factores primos 1: ";
        f = new FormatoPretty(valor);

        String texto = f.aplicar(factores);

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoPretty() {

        int valor = 2;
        List<Integer> factores = Arrays.asList(2);
        String esperado = "Factores primos 2: 2 ";
        f = new FormatoPretty(valor);

        String texto = f.aplicar(factores);

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoPretty() {

        int valor = 40;
        List<Integer> factores = Arrays.asList(2, 2, 2, 5);
        String esperado = "Factores primos 40: 2 2 2 5 ";
        f = new FormatoPretty(valor);

        String texto = f.aplicar(factores);

        Assert.assertEquals(esperado, texto);
    }
}
