package ar.edu.untref.aydoo;

import java.util.Arrays;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

public class CalculadoraFactoresPrimosTest {
	
	@Test
	public void testUno() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(1);
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		Assert.assertEquals(esperado, factores);
	}
    
	@Test
	public void testDos() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(2);
		ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2));
		Assert.assertEquals(esperado, factores);
	}
	
	@Test
	public void testCuarenta() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(40);
		ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 5));
		Assert.assertEquals(esperado, factores);
	}
	
	@Test
	public void testNoventa() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(90);
		ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 3, 3, 5));
		Assert.assertEquals(esperado, factores);
	}
	
	@Test
	public void testTrescientosCincuentaYNueve() {
		List<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(359);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(359));
		Assert.assertEquals(esperado, factores);
	}
	
	@Test
	public void testTrescientosSesenta() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(360);
		ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 3, 5));
		Assert.assertEquals(esperado, factores);
	}
	
	@Test
	public void testOchocientosSesentaYCuatro()	{
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(864);
		ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 3, 3, 3));
		Assert.assertEquals(esperado, factores);
	}
	
	@Test
	public void testNovecientosSesenta() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(960);
		ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 5));
		Assert.assertEquals(esperado, factores);
	}
	
	@Test
	public void testMilOchocientos() {
		ArrayList<Integer> factores = CalculadoraFactoresPrimos.calcularFactoresPrimos(1800);
		ArrayList<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 3, 5, 5));
		Assert.assertEquals(esperado, factores);
	}
}
