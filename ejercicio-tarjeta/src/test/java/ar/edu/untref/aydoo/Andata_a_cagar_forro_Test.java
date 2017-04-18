package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Andata_a_cagar_forro_Test {

    @Test
    public void elefante() throws PorcentajeInvalidoException {
        // En enero, Juan compra 2 kg de helado en la sucursal Caseros de la heladeria "Frio" con la tarjeta Premium.
        // La heladeria Frio vende el helado a $100 por kg y ofrece un descuento del 10% para compras con tarjetas premium.

        String email = "juan@gmail.com";
        Cliente juan = new Cliente("juan", email);

        Tarjeta tarjeta = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("Heladeria Frio");

        int porcentajeDescuento = 10;
        DescuentoPremium descuento10 = new DescuentoPremium(porcentajeDescuento, heladeriaFrio);

        Sucursal caseros = new Sucursal("Caseros", heladeriaFrio);
        int precioUnitario = 100;
        Producto helado = new Producto("Helado", precioUnitario, heladeriaFrio);

        int cantidadDeCompra = 2;
        Compra compraDe2kgDeHelado = new Compra(caseros, tarjeta);

        compraDe2kgDeHelado.agregar(helado, cantidadDeCompra);

        assertEquals(1, caseros.getCantidadBeneficiosOtorgados());
    }
}
