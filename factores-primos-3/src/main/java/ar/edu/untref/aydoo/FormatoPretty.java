package ar.edu.untref.aydoo;

import java.util.List;

public class FormatoPretty implements Formato {

    private int numero;

    public FormatoPretty(final int valor) {

        numero = valor;
    }

    public String aplicar(final List<Integer> numeros) {

        String texto = "Factores primos " + numero + ": ";
        for (Integer n : numeros) {
            texto += n + " ";
        }
        return texto;
    }
}
