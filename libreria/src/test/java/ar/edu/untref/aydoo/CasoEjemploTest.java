package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CasoEjemploTest {

    private Publicacion barcelona;
    private Publicacion elGrafico;
    private Articulo elHobbit;
    private ArticuloDeLibreria lapicera;
    private Publicacion pagina12;
    private Publicacion clarin;
    private Cliente juan;
    private Cliente maria;
    private Libreria libreria;

    @Before
    public void setUp() {
        barcelona = new Publicacion("Barcelona", 20, 15);
        elGrafico = new Publicacion("El Grafico", 30, 30);
        elHobbit = new Articulo("El Hobbit", 50);
        lapicera = new ArticuloDeLibreria("Lapicera", 5);
        pagina12 = new Publicacion("Pagina 12", 12, 1);
        clarin = new Publicacion("Clarin", 13, 1);
        juan = new Cliente("Juan", "Urquiza 1500", 11111111);
        maria = new Cliente("Maria", "Belgrano 1500", 22222222);
        libreria = new Libreria();
        libreria.registrar(barcelona);
        libreria.registrar(elGrafico);
        libreria.registrar(elHobbit);
        libreria.registrar(lapicera);
        libreria.registrar(pagina12);
        libreria.registrar(clarin);
        libreria.registrar(juan);
        libreria.registrar(maria);
    }

    @Test
    public void testCasoUno() {
        libreria.vender(juan, elHobbit, "agosto");
        libreria.vender(juan, lapicera, "agosto");
        libreria.vender(juan, lapicera, "agosto");
        libreria.vender(juan, elGrafico, "agosto");
        Double monto = libreria.calcularMontoACobrar("agosto", juan);
        Assert.assertEquals(92.1, monto, 0);
    }
}
