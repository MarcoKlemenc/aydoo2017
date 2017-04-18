package ar.edu.untref.aydoo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompraTest {

    @Test
    public void deberiaCalcularMontoBruto() {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        Compra unaCompra = new Compra(frioCaseros, visa);
        unaCompra.agregar(helado, 2);

        assertEquals(20, unaCompra.calcularMontoBruto());
    }

    @Test
    public void deberiaCalcularMontoNeto() throws PorcentajeInvalidoException {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        DescuentoPremium diezFrio = new DescuentoPremium(10, heladeriaFrio);
        Producto helado = new Producto("helado", 10, heladeriaFrio);

        Compra unaCompra = new Compra(frioCaseros, visa);
        unaCompra.agregar(helado, 2);

        assertEquals(18, unaCompra.calcularMontoNeto());
    }

    @Test
    public void deberiaCalcularMontoBrutoParaMasDeUnArticulo() throws PorcentajeInvalidoException {

        Cliente juan = new Cliente("juan", "juan@gmail.com");
        Tarjeta visa = new TarjetaPremium(juan);
        Establecimiento heladeriaFrio = new Establecimiento("frio");
        Sucursal frioCaseros = new Sucursal("Caseros", heladeriaFrio);
        DescuentoPremium diezFrio = new DescuentoPremium(10, heladeriaFrio);
        Producto unKilo = new Producto("1 kg", 200, heladeriaFrio);
        Producto medioKilo = new Producto("1/2 kg", 120, heladeriaFrio);

        Compra unaCompra = new Compra(frioCaseros, visa);
        unaCompra.agregar(unKilo, 2);
        unaCompra.agregar(medioKilo, 1);

        assertEquals(520, unaCompra.calcularMontoBruto());
    }
}
