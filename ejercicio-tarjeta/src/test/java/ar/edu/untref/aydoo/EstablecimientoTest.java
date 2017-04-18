package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EstablecimientoTest {

    @Test
    public void debeCrearseConNombre() {

        String nombre = "Nike";
        Establecimiento nike = new Establecimiento(nombre);

        assertEquals(nombre, nike.getNombre());
    }

    @Test
    public void debeRegistrarUnaSucursal() {

        String nombre = "Nike";
        Establecimiento nike = new Establecimiento(nombre);

        String nombreSucursal = "Caseros";
        Sucursal caseros = new Sucursal(nombreSucursal, nike);

        assertEquals(1, nike.getSucursales().size());
    }
}
