package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class CalculadoraFactoresPrimos {

	public static ArrayList<Integer> calcularFactoresPrimos(int numero) {
		ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();
		while (numero > 1) {
			for (int i = 2; i <= numero; i++) {
				if (numero % i == 0) {
					factoresPrimos.add(i);
					numero /= i;
					break;
				}
			}
		}
		return factoresPrimos;
	}
    
	public static final void main(String arg[]) {
		ArrayList<Integer> primos = calcularFactoresPrimos(Integer.parseInt(arg[0]));
		String factores = "Factores primos " + arg[0] + ": ";
		for (Integer numero : primos) {
			factores += numero + " ";
		}
		System.out.println(factores);
	}
}
