package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Collections;

public class CalculadoraFactoresPrimos2 {

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

    public static String formatearPretty(ArrayList<Integer> primos, String argumento) {
        String factores = "Factores primos " + argumento + ": ";
        for (Integer numero : primos) {
            factores += numero + " ";
        }
        return factores;
    }

    public static String formatearQuiet(ArrayList<Integer> primos) {
        Collections.reverse(primos);
        String factores = "";
        for (Integer numero : primos) {
            factores += numero.toString() + "\n";
        }
        return factores;
    }

    public static final void main(String arg[]) {
        ArrayList<Integer> primos = calcularFactoresPrimos(Integer.parseInt(arg[0]));
        if (arg.length > 1 && arg[1].substring(0, 9).equals("--format=")) {
            String argumento = arg[1].substring(9);
            if (argumento.toLowerCase().equals("pretty")) {
                System.out.println(formatearPretty(primos, arg[0]));
            } else if (argumento.toLowerCase().equals("quiet")) {
                System.out.println(formatearQuiet(primos));
            } else {
                System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
            }
        } else {
            System.out.println(formatearPretty(primos, arg[0]));
        }
    }
}
