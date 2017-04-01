package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

	@Test
	public void testEspecificandoFormatoIncorrecto() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		String esperado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		String[] argumentos = { "2", "--format=nada" };

		CalculadoraFactoresPrimos.main(argumentos);
		String salida = new String(baos.toByteArray());

		Assert.assertTrue(salida.contains(esperado));
	}

	@Test
	public void testDosSinEspecificarFormato() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		String esperado = "Factores primos 2: 2 ";
		String[] argumentos = { "2" };

		CalculadoraFactoresPrimos.main(argumentos);
		String salida = new String(baos.toByteArray());

		Assert.assertTrue(salida.contains(esperado));
	}

	@Test
	public void testDosEspecificandoFormatoPretty() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		String esperado = "Factores primos 2: 2 ";
		String[] argumentos = { "2", "--format=pretty" };

		CalculadoraFactoresPrimos.main(argumentos);
		String salida = new String(baos.toByteArray());

		Assert.assertTrue(salida.contains(esperado));
	}

	@Test
	public void testDosEspecificandoFormatoQuiet() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		String esperado = "2";
		String[] argumentos = { "2", "--format=quiet" };

		CalculadoraFactoresPrimos.main(argumentos);
		String salida = new String(baos.toByteArray());

		Assert.assertTrue(salida.contains(esperado));
	}
}
