package ar.edu.untref.aydoo;

import java.util.*;

/*
 * Separé el formato del main y la generación de la lista para poder testearlo por separado.
 * Además no estaba seguro de si iba a poder testear la salida a consola del main.
 */

public class CalculadoraFactoresPrimos3 {

    public static List<Integer> calcular(int numero) {

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

    public static void main(String[] args) {

        List<Integer> primos = calcular(Integer.parseInt(args[0]));
        Formato f;
        if (args.length > 1) {
            Map<String, String> mapArgs = leerArgumentos(args);
            if (mapArgs.containsKey("--format")) {
                switch (mapArgs.get("--format")) {
                    case "pretty":
                        f = new FormatoPretty();
                        System.out.println(f.aplicar(primos, args[0]));
                        break;
                    case "quiet":
                        f = new FormatoQuiet();
                        System.out.println(f.aplicar(primos, args[0]));
                        break;
                    default:
                        System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
                        break;
                }
            } else {
                f = new FormatoPretty();
                System.out.println(f.aplicar(primos, args[0]));
            }
        } else {
            f = new FormatoPretty();
            System.out.println(f.aplicar(primos, args[0]));
        }
    }

    private static Map<String, String> leerArgumentos(String[] args) {

        Map<String, String> argumentos = new HashMap<String, String>();
        for (int i = 1; i < args.length; i++) {
            String arg = args[i];
            StringTokenizer s = new StringTokenizer(arg, "=");
            argumentos.put(s.nextToken(), s.nextToken().toLowerCase());
        }
        return argumentos;
    }
}
