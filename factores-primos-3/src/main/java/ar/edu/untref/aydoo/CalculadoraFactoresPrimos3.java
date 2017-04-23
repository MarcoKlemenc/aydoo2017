package ar.edu.untref.aydoo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Collections;

public final class CalculadoraFactoresPrimos3 {

    private CalculadoraFactoresPrimos3() {

    }

    public static List<Integer> calcular(final int numero) {

        int valor = numero;
        List<Integer> factoresPrimos = new ArrayList<Integer>();
        while (valor > 1) {
            for (int i = 2; i <= valor; i++) {
                if (valor % i == 0) {
                    factoresPrimos.add(i);
                    valor /= i;
                    break;
                }
            }
        }
        return factoresPrimos;
    }

    public static void main(final String[] args) {

        CalculadoraFactoresPrimos3 c = new CalculadoraFactoresPrimos3();
        int numero = Integer.parseInt(args[0]);
        List<Integer> primos = c.calcular(numero);
        CreadorFormato cf = new CreadorFormato();
        Formato f = new FormatoPretty(numero);
        Salida s = new SalidaConsola();
        Map<String, String> mapArgs = c.leerArgumentos(args);
        if (mapArgs.containsKey("--format")) {
            try {
                f = cf.crear(mapArgs.get("--format"), numero);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (mapArgs.containsKey("--output-file")) {
            s = new SalidaArchivo(mapArgs.get("--output-file"));
        }
        if (mapArgs.containsKey("--sort")) {
            try {
                primos = c.ordenar(mapArgs.get("--sort"), primos);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        s.escribirLinea(f.aplicar(primos));
    }

    private List<Integer> ordenar(final String criterio,
                                  final List<Integer> original) {

        List<Integer> ordenada = original;
        if (criterio.equals("asc")) {
            return ordenada;
        }
        if (criterio.equals("des")) {
            Collections.reverse(ordenada);
            return ordenada;
        }
        throw new IllegalArgumentException("Orden no aceptado. Las opciones "
                + "posibles son: asc o des.");
    }

    private Map<String, String> leerArgumentos(final String[] args) {

        Map<String, String> argumentos = new HashMap<String, String>();
        for (int i = 1; i < args.length; i++) {
            String arg = args[i];
            StringTokenizer s = new StringTokenizer(arg, "=");
            argumentos.put(s.nextToken(), s.nextToken().toLowerCase());
        }
        return argumentos;
    }
}
