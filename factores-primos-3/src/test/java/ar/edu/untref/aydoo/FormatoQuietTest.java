package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FormatoQuietTest {

    FormatoQuiet f;

    @Before
    public void setUp() {
        f = new FormatoQuiet();
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoQuiet() {

        List<Integer> factores = Arrays.asList();
        String esperado = "";

        String texto = f.aplicar(factores);

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoQuiet() {

        List<Integer> factores = Arrays.asList(2);
        String esperado = "2\n";

        String texto = f.aplicar(factores);

        Assert.assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoQuiet() {

        List<Integer> factores = Arrays.asList(2, 2, 2, 5);
        String esperado = "5\n2\n2\n2\n";

        String texto = f.aplicar(factores);

        Assert.assertEquals(esperado, texto);
    }
}
