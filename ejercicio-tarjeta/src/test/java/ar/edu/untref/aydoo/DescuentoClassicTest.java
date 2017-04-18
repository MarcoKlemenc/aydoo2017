package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DescuentoClassicTest {

    @Test(expected = PorcentajeInvalidoException.class)
    public void debeLanzarExcepcionConPorcentajeInferiorA5()
            throws PorcentajeInvalidoException {

        int porcentaje = 4;
        DescuentoClassic descuento = new DescuentoClassic(porcentaje, null);
    }

    @Test
    public void debeCrearseConExitoConPorcentajeNoInferiorA5()
            throws PorcentajeInvalidoException {

        String nombre = "Nike";
        Establecimiento nike = new Establecimiento(nombre);

        int porcentaje = 10;
        DescuentoClassic descuento = new DescuentoClassic(porcentaje, nike);

        assertEquals(porcentaje, descuento.getPorcentaje());
        assertEquals(descuento, nike.getDescuentoClassic());
    }
}
