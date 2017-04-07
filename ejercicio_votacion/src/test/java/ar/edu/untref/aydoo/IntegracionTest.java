package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {

	Votacion p;

	Provincia buenosAires;
	Provincia cordoba;
	Provincia santaFe;
	Provincia mendoza;

	Candidato fulano;
	Candidato mengano;
	Candidato fulanito;
	Candidato menganito;
	Candidato zutano;

	Elector juanPerez;
	Elector joseGonzalez;
	Elector mariaRodriguez;
	Elector diegoFernandez;
	Elector sofiaPerez;
	Elector andresFernandez;
	Elector andreaGonzalez;
	Elector estebanRodriguez;
	Elector juliaPerez;

	@Before
	public void setUp() {
		p = new Votacion();

		buenosAires = new Provincia("Buenos Aires");
		cordoba = new Provincia("Cordoba");
		santaFe = new Provincia("Santa Fe");
		mendoza = new Provincia("Mendoza");

		fulano = new Candidato("Fulano", "Partido A");
		mengano = new Candidato("Mengano", "Partido B");
		fulanito = new Candidato("Fulanito", "Partido A");
		menganito = new Candidato("Menganito", "Partido B");
		zutano = new Candidato("Zutano", "Partido A");

		juanPerez = new Elector("Juan Perez", buenosAires);
		joseGonzalez = new Elector("Jose Gonzalez", buenosAires);
		mariaRodriguez = new Elector("Maria Rodriguez", cordoba);
		diegoFernandez = new Elector("Diego Fernandez", santaFe);
		sofiaPerez = new Elector("Sofia Perez", mendoza);
		andresFernandez = new Elector("Andres Fernandez", buenosAires);
		andreaGonzalez = new Elector("Andrea Gonzalez", santaFe);
		estebanRodriguez = new Elector("Esteban Rodriguez", cordoba);
		juliaPerez = new Elector("Julia Perez", buenosAires);

		p.agregar(buenosAires);
		p.agregar(cordoba);
		p.agregar(santaFe);
		p.agregar(mendoza);

		p.agregar(fulano);
		p.agregar(mengano);
		p.agregar(fulanito);
		p.agregar(menganito);
		p.agregar(zutano);

		p.agregar(juanPerez);
		p.agregar(joseGonzalez);
		p.agregar(mariaRodriguez);
		p.agregar(diegoFernandez);
		p.agregar(sofiaPerez);
		p.agregar(andresFernandez);
		p.agregar(andreaGonzalez);
		p.agregar(estebanRodriguez);
		p.agregar(juliaPerez);

	}

	@Test
	public void testUnVoto() {
		p.emitirVoto(juanPerez, fulano);
		Assert.assertEquals("Fulano", p.calcularCandidatoMasVotado());
		Assert.assertEquals("Partido A", p.calcularPartidoMasVotadoEnProvincia(buenosAires));
	}

	@Test
	public void testUnVotoPorPersona() {
		p.emitirVoto(juanPerez, fulano);
		p.emitirVoto(joseGonzalez, zutano);
		p.emitirVoto(mariaRodriguez, mengano);
		p.emitirVoto(diegoFernandez, menganito);
		p.emitirVoto(sofiaPerez, fulanito);
		p.emitirVoto(andresFernandez, mengano);
		p.emitirVoto(andreaGonzalez, menganito);
		p.emitirVoto(estebanRodriguez, mengano);
		p.emitirVoto(juliaPerez, fulano);
		Assert.assertEquals("Mengano", p.calcularCandidatoMasVotado());
		Assert.assertEquals("Partido A", p.calcularPartidoMasVotadoEnProvincia(buenosAires));
		Assert.assertEquals("Partido B", p.calcularPartidoMasVotadoEnProvincia(cordoba));
		Assert.assertEquals("Partido B", p.calcularPartidoMasVotadoEnProvincia(santaFe));
		Assert.assertEquals("Partido A", p.calcularPartidoMasVotadoEnProvincia(mendoza));
	}

	@Test(expected = Error.class)
	public void testMasDeUnVotoPorPersona() {
		p.emitirVoto(juanPerez, fulano);
		p.emitirVoto(juanPerez, mengano);
	}

	@Test(expected = Error.class)
	public void testCandidatoMasVotadoSinVotos() {
		p.calcularCandidatoMasVotado();
	}

	@Test(expected = Error.class)
	public void testPartidoMasVotadoSinVotos() {
		p.calcularPartidoMasVotadoEnProvincia(buenosAires);
	}

}
