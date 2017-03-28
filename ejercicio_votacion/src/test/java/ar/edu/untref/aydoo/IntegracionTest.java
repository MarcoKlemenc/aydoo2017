package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {

	Votacion p;

	@Before
	public void setUp() {
		p = new Votacion();

		p.agregarProvincia("Buenos Aires");
		p.agregarProvincia("Cordoba");
		p.agregarProvincia("Santa Fe");
		p.agregarProvincia("Mendoza");

		p.agregarCandidato("Fulano", "Partido A");
		p.agregarCandidato("Mengano", "Partido B");
		p.agregarCandidato("Fulanito", "Partido A");
		p.agregarCandidato("Menganito", "Partido B");
		p.agregarCandidato("Zutano", "Partido A");

		p.agregarElector("Juan Perez", "Buenos Aires");
		p.agregarElector("Jose Gonzalez", "Buenos Aires");
		p.agregarElector("Maria Rodriguez", "Cordoba");
		p.agregarElector("Diego Fernandez", "Santa Fe");
		p.agregarElector("Sofia Perez", "Mendoza");
		p.agregarElector("Andres Fernandez", "Buenos Aires");
		p.agregarElector("Andrea Gonzalez", "Santa Fe");
		p.agregarElector("Esteban Rodriguez", "Cordoba");
		p.agregarElector("Julia Perez", "Buenos Aires");
	}

	@Test
	public void testUnVoto() {
		p.emitirVoto("Juan Perez", "Fulano");
		Assert.assertEquals("Fulano", p.calcularCandidatoMasVotado());
		Assert.assertEquals("Partido A", p.calcularPartidoMasVotadoEnProvincia("Buenos Aires"));
	}

	@Test
	public void testUnVotoPorPersona() {
		p.emitirVoto("Juan Perez", "Fulano");
		p.emitirVoto("Jose Gonzalez", "Zutano");
		p.emitirVoto("Maria Rodriguez", "Mengano");
		p.emitirVoto("Diego Fernandez", "Menganito");
		p.emitirVoto("Sofia Perez", "Fulanito");
		p.emitirVoto("Andres Fernandez", "Mengano");
		p.emitirVoto("Andrea Gonzalez", "Menganito");
		p.emitirVoto("Esteban Rodriguez", "Mengano");
		p.emitirVoto("Julia Perez", "Fulano");
		Assert.assertEquals("Mengano", p.calcularCandidatoMasVotado());
		Assert.assertEquals("Partido A", p.calcularPartidoMasVotadoEnProvincia("Buenos Aires"));
		Assert.assertEquals("Partido B", p.calcularPartidoMasVotadoEnProvincia("Cordoba"));
		Assert.assertEquals("Partido B", p.calcularPartidoMasVotadoEnProvincia("Santa Fe"));
		Assert.assertEquals("Partido A", p.calcularPartidoMasVotadoEnProvincia("Mendoza"));
	}

	@Test(expected = Error.class)
	public void testVotoVotanteInexistente() {
		p.emitirVoto("Inexistente", "Fulano");
	}

	@Test(expected = Error.class)
	public void testVotoCandidatoInexistente() {
		p.emitirVoto("Juan Perez", "Inexistente");
	}

	@Test(expected = Error.class)
	public void testMasDeUnVotoPorPersona() {
		p.emitirVoto("Juan Perez", "Fulano");
		p.emitirVoto("Juan Perez", "Mengano");
	}

	@Test(expected = Error.class)
	public void testAgregarElectorProvinciaInexistente() {
		p.agregarElector("Ariel Juarez", "Santa Catarina");
	}

	@Test(expected = Error.class)
	public void testPartidoMasVotadoProvinciaInexistente() {
		p.emitirVoto("Juan Perez", "Fulano");
		p.calcularPartidoMasVotadoEnProvincia("Santa Catarina");
	}

	@Test(expected = Error.class)
	public void testCandidatoMasVotadoSinVotos() {
		p.calcularCandidatoMasVotado();
	}

	@Test(expected = Error.class)
	public void testPartidoMasVotadoSinVotos() {
		p.calcularPartidoMasVotadoEnProvincia("Buenos Aires");
	}

}
