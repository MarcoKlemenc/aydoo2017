package ar.edu.untref.aydoo;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

public class ProgramTest 
{
    @Test
	public void testUno()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(1);
		List<Integer> esperado = new ArrayList<Integer>();
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testDos()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(2);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2));
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testCuarenta()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(40);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 5));
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testNoventa()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(90);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 3, 3, 5));
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testTrescientosCincuentaYNueve()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(359);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(359));
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testTrescientosSesenta()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(360);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 3, 5));
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testOchocientosSesentaYCuatro()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(864);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 3, 3, 3));
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testNovecientosSesenta()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(960);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 2, 3, 5));
		Assert.assertEquals(esperado, factores);
	}
	@Test
	public void testMilOchocientos()
	{
		List<Integer> factores = Program.calcularFactoresPrimos(1800);
		List<Integer> esperado = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 3, 5, 5));
		Assert.assertEquals(esperado, factores);
	}
}
