package ar.edu.untref.aydoo;

import org.junit.Test;

public class DescuentoPremiumTest {

    @Test (expected = PorcentajeInvalidoException.class)
    public void debeLanzarExcepcionConPorcentajeInferiorA5()
            throws PorcentajeInvalidoException{

        int porcentaje = 4;
        DescuentoPremium descuento = new DescuentoPremium(porcentaje, null);
    }
}
