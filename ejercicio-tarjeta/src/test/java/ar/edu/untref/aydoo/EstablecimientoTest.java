package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

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

        Establecimiento establecimiento = new Establecimiento(null);
        Sucursal sucursal = new Sucursal(null, establecimiento);

        assertEquals(sucursal, establecimiento.getSucursales().get(0));
    }

    @Test
    public void debeRegistrarBeneficioClassic() {

        Establecimiento establecimiento = new Establecimiento(null);
        Beneficio dosPorUno = new Beneficio2x1(establecimiento);

        assertEquals(dosPorUno, establecimiento.getBeneficioClassic());
    }

    @Test
    public void debeRegistrarBeneficioPremium() {

        Establecimiento establecimiento = new Establecimiento(null);
        Beneficio dosPorUno = new Beneficio2x1(establecimiento);

        assertEquals(dosPorUno, establecimiento.getBeneficioPremium());
    }

    @Test
    public void debeCalcularElTotalDeBeneficios() {

        Establecimiento establecimiento = new Establecimiento(null);
        Sucursal sucursalUno = new Sucursal(null, establecimiento);
        Sucursal sucursalDos = new Sucursal(null, establecimiento);
        Beneficio dosPorUno = new Beneficio2x1(establecimiento);
        Cliente cliente = new Cliente(null, null);
        Tarjeta tarjeta = new TarjetaClassic(cliente);

        String nombreHelado = "Helado";
        int precio = 10;
        Producto helado = new Producto(nombreHelado, precio, establecimiento);
        SortedMap<Producto, Integer> productos = new TreeMap<>();
        int cantidad = 2;
        productos.put(helado, cantidad);
        Compra compraUno = new Compra(sucursalUno, tarjeta, productos);
        Compra compraDos = new Compra(sucursalDos, tarjeta, productos);

        int total = 2;
        assertEquals(total, establecimiento.calcularTotalBeneficios());
    }
}
