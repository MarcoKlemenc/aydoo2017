package ar.edu.untref.aydoo;

import java.util.*;

public class CalculadoraFactoresPrimos3 {

    private CalculadoraFactoresPrimos3() {

    }

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

        CalculadoraFactoresPrimos3 c = new CalculadoraFactoresPrimos3();
        int numero = Integer.parseInt(args[0]);
        List<Integer> primos = c.calcular(numero);
        Formato f = new FormatoPretty(numero);
        Salida s = new SalidaConsola();
        if (args.length > 1) {
            Map<String, String> mapArgs = c.leerArgumentos(args);
            if (mapArgs.containsKey("--format")) {
                switch (mapArgs.get("--format")) {
                    case "pretty":
                        break;
                    case "quiet":
                        f = new FormatoQuiet();
                        break;
                    default:
                        System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
                        return;
                }
            }
        }
        s.escribirLinea(f.aplicar(primos));
    }

    private Map<String, String> leerArgumentos(String[] args) {

        Map<String, String> argumentos = new HashMap<String, String>();
        for (int i = 1; i < args.length; i++) {
            String arg = args[i];
            StringTokenizer s = new StringTokenizer(arg, "=");
            argumentos.put(s.nextToken(), s.nextToken().toLowerCase());
        }
        return argumentos;
    }
}
