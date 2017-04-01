package ar.edu.untref.aydoo;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

public class CalculadoraFactoresPrimosTest {

	@Test
	public void testUnoEnPretty() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(1);
		String texto = CalculadoraFactoresPrimos.formatearPretty(factores, "1");
		String esperado = "Factores primos 1: ";
		Assert.assertEquals(esperado, texto);
	}

	@Test
	public void testUnoEnQuiet() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(1);
		String texto = CalculadoraFactoresPrimos.formatearQuiet(factores);
		String esperado = "";
		Assert.assertEquals(esperado, texto);
	}

	@Test
	public void testDosEnPretty() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(2);
		String texto = CalculadoraFactoresPrimos.formatearPretty(factores, "2");
		String esperado = "Factores primos 2: 2 ";
		Assert.assertEquals(esperado, texto);
	}

	@Test
	public void testDosEnQuiet() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(2);
		String texto = CalculadoraFactoresPrimos.formatearQuiet(factores);
		String esperado = "2\n";
		Assert.assertEquals(esperado, texto);
	}
}
