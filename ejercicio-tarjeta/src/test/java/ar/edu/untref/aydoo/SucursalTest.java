package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SucursalTest {

    @Test
    public void debeCrearseConNombreYEstablecimiento() {

        String nombreEstablecimiento = "Nike";
        String nombreSucursal = "Caseros";
        Establecimiento nike = new Establecimiento(nombreEstablecimiento);

        Sucursal caseros = new Sucursal(nombreSucursal, nike);

        assertEquals(nombreSucursal, caseros.getNombre());
        assertEquals(nike, caseros.getEstablecimiento());
    }
}
