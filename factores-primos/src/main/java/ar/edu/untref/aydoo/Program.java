package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Program 
{
    public static List<Integer> calcularFactoresPrimos(int numero) {
		List<Integer> factoresPrimos = new ArrayList<Integer>();
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
    public static final void main(String arg[])
    {
        List<Integer> primos = calcularFactoresPrimos(Integer.parseInt(arg[0]));
		String factores = "Factores primos " + arg[0] + ": ";
		for (int i = 0; i < primos.size(); i++)
			factores += primos.get(i) + " ";
		System.out.println(factores);
    }
}
