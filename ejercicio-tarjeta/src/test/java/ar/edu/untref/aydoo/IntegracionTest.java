package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegracionTest {

    @Test
    public void EjemploUnoTest() throws PorcentajeInvalidoException {
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

        Compra compraUno = new Compra(s1, tarjetaCarlos);
        Compra compraDos = new Compra(s2, tarjetaJuan);
        compraDos.agregar(helado, 1);
        Compra compraTres = new Compra(s1, tarjetaCarlos);
        Compra compraCuatro = new Compra(s2, tarjetaJuan);
        compraCuatro.agregar(helado, 2);
        Compra compraCinco = new Compra(s1, tarjetaCarlos);
        Compra compraSeis = new Compra(s2, tarjetaJuan);
        compraSeis.agregar(helado, 3);
        Compra compraSiete = new Compra(s1, tarjetaCarlos);
        Compra compraOcho = new Compra(s3, tarjetaCarlos);
        Compra compraNueve = new Compra(s3, tarjetaCarlos);
        Compra compraDiez = new Compra(s3, tarjetaCarlos);
        Compra compraOnce = new Compra(s3, tarjetaCarlos);
        Compra compraDoce = new Compra(s3, tarjetaCarlos);
        Compra compraTrece = new Compra(s3, tarjetaCarlos);

        assertEquals(s3, club.buscarSucursalConMasBeneficios());
        assertEquals(heladeriaA, club.buscarEstablecimientoConMasBeneficios());

        List<String> comprasJuan = club.buscarBeneficiosObtenidos(juan);
        String beneficioUno = "Heladeria A | Helado x 1 | 200 | 40";
        assertEquals(beneficioUno, comprasJuan.get(0));
        String beneficioDos = "Heladeria A | Helado x 2 | 400 | 80";
        assertEquals(beneficioDos, comprasJuan.get(1));
        String beneficioTres = "Heladeria A | Helado x 3 | 600 | 120";
        assertEquals(beneficioTres, comprasJuan.get(2));
    }
}
