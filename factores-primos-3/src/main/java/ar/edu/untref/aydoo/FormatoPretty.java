package ar.edu.untref.aydoo;

import java.util.List;

public class FormatoPretty implements Formato {

    public String aplicar(List<Integer> numeros, String argumento) {

        String texto = "Factores primos " + argumento + ": ";
        for (Integer numero : numeros) {
            texto += numero + " ";
        }
        return texto;
    }
}
