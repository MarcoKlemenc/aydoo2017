package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

/*
 * Separé el formato del main y la generación de la lista para poder testearlo por separado.
 * Además no estaba seguro de si iba a poder testear la salida a consola del main.
 */

public class CalculadoraFactoresPrimos3 {

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

    public static final void main(String arg[]) {

        List<Integer> primos = calcularFactoresPrimos(Integer.parseInt(arg[0]));
        if (arg.length > 1 && arg[1].substring(0, 9).equals("--format=")) {
            switch (arg[1].substring(9).toLowerCase()) {
                case "pretty":
                    FormatoPretty p = new FormatoPretty();
                    System.out.println(p.aplicar(primos, arg[0]));
                    break;
                case "quiet":
                    FormatoQuiet q = new FormatoQuiet();
                    System.out.println(q.aplicar(primos, arg[0]));
                    break;
                default:
                    System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
                    break;
            }
        } else {
            FormatoPretty p = new FormatoPretty();
            System.out.println(p.aplicar(primos, arg[0]));
        }
    }
}
