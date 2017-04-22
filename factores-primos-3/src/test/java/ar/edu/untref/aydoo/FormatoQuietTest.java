package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FormatoQuietTest {

    FormatoQuiet f;

    @Before
    public void setUp(){
        f = new FormatoQuiet();
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoQuiet() {

        ArrayList<Integer> factores = CalculadoraFactoresPrimos3.calcularFactoresPrimos(1);
        String esperado = "";

        String texto = f.aplicar(factores, "1");

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoQuiet() {

        ArrayList<Integer> factores = CalculadoraFactoresPrimos3.calcularFactoresPrimos(2);
        String esperado = "2\n";

        String texto = f.aplicar(factores, "2");

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoQuiet() {

        ArrayList<Integer> factores = CalculadoraFactoresPrimos3.calcularFactoresPrimos(40);
        String esperado = "5\n2\n2\n2\n";

        String texto = f.aplicar(factores, "40");

        Assert.assertEquals(esperado, texto);
    }
}
