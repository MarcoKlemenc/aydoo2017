package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductoTest {

    @Test
    public void debeFijarseUnNombre() {

        String nombre = "Kilogramo de helado";
        Producto kgHelado = new Producto(nombre, null, null);

        assertEquals(nombre, kgHelado.getNombre());
    }

    @Test
    public void debeFijarseUnPrecio() {

        int precio = 200;
        Producto producto = new Producto(null, precio, null);

        assertEquals(precio, producto.getPrecio());
    }

    @Test
    public void debeFijarseUnEstablecimiento() {

        Establecimiento establecimiento = new Establecimiento(null);
        Producto kgHelado = new Producto(null, null, establecimiento);

        assertEquals(establecimiento, kgHelado.getEstablecimiento());
    }

    @Test
    public void debeCompararseConOtro() {

        String a = "A";
        String b = "B";
        Producto productoA = new Producto(a, null,  null);
        Producto productoB = new Producto(b, null,  null);

        int resultado = -1;
        assertEquals(resultado, productoA.compareTo(productoB));
    }
}
