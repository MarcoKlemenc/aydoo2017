package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductoTest {

    @Test
    public void debeCrearseConNombrePrecioYEstablecimiento() {

        String nombre = "Kilogramo de helado";
        int precio = 200;
        Establecimiento establecimiento = new Establecimiento("Freddo");

        Producto kgHelado = new Producto(nombre, precio, establecimiento);

        assertEquals(nombre, kgHelado.getNombre());
        assertEquals(precio, kgHelado.getPrecio());
        assertEquals(establecimiento, kgHelado.getEstablecimiento());
    }
}
