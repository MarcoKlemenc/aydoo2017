package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class IntegracionTest {

    @Test
    public void ejemploUnoTest() throws PorcentajeInvalidoException {
        String nombreCarlos = "Carlos";
        String mailCarlos = "carlos@gmail.com";
        Cliente carlos = new Cliente(nombreCarlos, mailCarlos);
        Tarjeta tarjetaCarlos = new TarjetaClassic(carlos);

        String nombreJuan = "Carlos";
        String mailJuan = "carlos@gmail.com";
        Cliente juan = new Cliente(nombreJuan, mailJuan);
        Tarjeta tarjetaJuan = new TarjetaPremium(juan);

        String nombreHeladeriaA = "Heladeria A";
        Establecimiento heladeriaA = new Establecimiento(nombreHeladeriaA);
        String nombreHelado = "Helado";
        int precioHelado = 200;
        Producto helado = new Producto(nombreHelado, precioHelado, heladeriaA);
        String nombreS1 = "S1";
        String nombreS2 = "S2";
        int diezPorciento = 10;
        int veintePorciento = 20;
        Descuento classicHeladeriaA = new DescuentoClassic(diezPorciento, heladeriaA);
        Descuento premiumHeladeriaA = new DescuentoPremium(veintePorciento, heladeriaA);
        Sucursal s1 = new Sucursal(nombreS1, heladeriaA);
        Sucursal s2 = new Sucursal(nombreS2, heladeriaA);

        String nombreRestaurantB = "Restaurant B";
        Establecimiento restaurantB = new Establecimiento(nombreRestaurantB);
        String nombreS3 = "S3";
        Descuento classicRestaurantB = new DescuentoClassic(veintePorciento, restaurantB);
        Descuento premiumRestaurantB = new DescuentoPremium(veintePorciento, restaurantB);
        Sucursal s3 = new Sucursal(nombreS3, restaurantB);

        ClubDeBeneficios club = new ClubDeBeneficios();
        club.agregar(carlos);
        club.agregar(juan);
        club.agregar(tarjetaCarlos);
        club.agregar(tarjetaJuan);
        club.agregar(heladeriaA);
        club.agregar(restaurantB);

        TreeMap<Producto, Integer> compraVacia = new TreeMap<Producto, Integer>();

        Compra compraUno = new Compra(s1, tarjetaCarlos, compraVacia);

        TreeMap<Producto, Integer> productosCompraDos = new TreeMap<Producto, Integer>();
        int cantidadCompraDos = 1;
        productosCompraDos.put(helado, cantidadCompraDos);
        Compra compraDos = new Compra(s2, tarjetaJuan, productosCompraDos);

        Compra compraTres = new Compra(s1, tarjetaCarlos, compraVacia);

        TreeMap<Producto, Integer> productosCompraCuatro = new TreeMap<Producto, Integer>();
        int cantidadCompraCuatro = 2;
        productosCompraCuatro.put(helado, cantidadCompraCuatro);
        Compra compraCuatro = new Compra(s2, tarjetaJuan, productosCompraCuatro);

        Compra compraCinco = new Compra(s1, tarjetaCarlos, compraVacia);

        TreeMap<Producto, Integer> productosCompraSeis = new TreeMap<Producto, Integer>();
        int cantidadCompraSeis = 3;
        productosCompraSeis.put(helado, cantidadCompraSeis);
        Compra compraSeis = new Compra(s2, tarjetaJuan, productosCompraSeis);

        Compra compraSiete = new Compra(s1, tarjetaCarlos, compraVacia);

        Compra compraOcho = new Compra(s3, tarjetaCarlos, compraVacia);

        Compra compraNueve = new Compra(s3, tarjetaCarlos, compraVacia);

        Compra compraDiez = new Compra(s3, tarjetaCarlos, compraVacia);

        Compra compraOnce = new Compra(s3, tarjetaCarlos, compraVacia);

        Compra compraDoce = new Compra(s3, tarjetaCarlos, compraVacia);

        Compra compraTrece = new Compra(s3, tarjetaCarlos, compraVacia);

        assertEquals(s3, club.buscarSucursalConMasBeneficios());
        assertEquals(heladeriaA, club.buscarEstablecimientoConMasBeneficios());

        Map<Cliente, List<String>> beneficios = club.buscarBeneficiosObtenidos();
        String beneficioUno = "Heladeria A | Helado x 1 | 200 | 40";
        assertEquals(beneficioUno, beneficios.get(juan).get(0));
        String beneficioDos = "Heladeria A | Helado x 2 | 400 | 80";
        assertEquals(beneficioDos, beneficios.get(juan).get(1));
        String beneficioTres = "Heladeria A | Helado x 3 | 600 | 120";
        assertEquals(beneficioTres, beneficios.get(juan).get(2));
    }

    @Test
    public void ejemploDosTest() {

        String nombreMateo = "Mateo";
        String mailMateo = "mateo@gmail.com";
        Cliente mateo = new Cliente(nombreMateo, mailMateo);
        Tarjeta tarjetaMateo = new TarjetaClassic(mateo);

        String nombreJose = "Jose";
        String mailJose = "jose@gmail.com";
        Cliente jose = new Cliente(nombreJose, mailJose);
        Tarjeta tarjetaJose = new TarjetaClassic(jose);

        String nombreElAltillo = "Libreria el altillo";
        Establecimiento elAltillo = new Establecimiento(nombreElAltillo);
        String nombreSucursal = "Sucursal";
        Sucursal sucursal = new Sucursal(nombreSucursal, elAltillo);
        Beneficio2x1 beneficio = new Beneficio2x1(elAltillo);

        String nombreMartinFierro = "Martin Fierro";
        int precioMartinFierro = 100;
        Producto martinFierro = new Producto(nombreMartinFierro, precioMartinFierro, elAltillo);
        String nombreElCantarDelCid = "El Cantar del Cid";
        int precioElCantarDelCid = 80;
        Producto elCantarDelCid = new Producto(nombreElCantarDelCid, precioElCantarDelCid, elAltillo);

        ClubDeBeneficios club = new ClubDeBeneficios();
        club.agregar(mateo);
        club.agregar(jose);
        club.agregar(tarjetaMateo);
        club.agregar(elAltillo);

        TreeMap<Producto, Integer> productosCompra = new TreeMap<Producto, Integer>();
        int cantidadMartinFierro = 1;
        int cantidadElCantarDelCid = 1;
        productosCompra.put(martinFierro, cantidadMartinFierro);
        productosCompra.put(elCantarDelCid, cantidadElCantarDelCid);
        Compra compra = new Compra(sucursal, tarjetaMateo, productosCompra);

        Map<Cliente, List<String>> beneficios = club.buscarBeneficiosObtenidos();
        String beneficioUno = "Libreria el altillo | El Cantar del Cid x 1 - Martin Fierro x 1 | 180 | 80";
        assertEquals(beneficioUno, beneficios.get(mateo).get(0));
    }
}
