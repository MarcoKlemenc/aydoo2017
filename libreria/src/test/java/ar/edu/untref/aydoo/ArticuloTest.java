package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloTest {

    @Test
    public void testCrearArticuloDeberiaFijarNombreYPrecio() {
        Articulo ejemplo = new Articulo("Ejemplo", 10);
        Assert.assertEquals("Ejemplo", ejemplo.getNombre());
        Assert.assertEquals(10, ejemplo.getPrecio(), 0.0);
    }

    @Test
    public void testCrearArticuloPrecioNegativoDeberiaInvertirlo() {
        Articulo negativo = new Articulo("Precio negativo", -15);
        Assert.assertEquals("Precio negativo", negativo.getNombre());
        Assert.assertEquals(15, negativo.getPrecio(), 0.0);
    }
}
