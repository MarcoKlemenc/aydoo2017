package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FormatoQuietTest {

    FormatoQuiet f = new FormatoQuiet();

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel1EnFormatoQuiet() {

        List<Integer> factores = Arrays.asList();
        String esperado = "";

        String texto = f.aplicar(factores);

        assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel2EnFormatoQuiet() {

        List<Integer> factores = Arrays.asList(2);
        String esperado = "2\n";

        String texto = f.aplicar(factores);

        assertEquals(esperado, texto);
    }

    @Test
    public void presentaCorrectamenteLosFactoresPrimosDel40EnFormatoQuiet() {

        List<Integer> factores = Arrays.asList(2, 2, 2, 5);
        String esperado = "2\n2\n2\n5\n";

        String texto = f.aplicar(factores);

        assertEquals(esperado, texto);
    }
}
