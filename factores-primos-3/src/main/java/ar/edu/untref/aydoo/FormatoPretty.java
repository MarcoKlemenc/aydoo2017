package ar.edu.untref.aydoo;

import java.util.List;

public class FormatoPretty implements Formato {

    private int numero;

    public FormatoPretty (int valor){

        numero = valor;
    }

    public String aplicar(List<Integer> numeros) {

        String texto = "Factores primos " + numero + ": ";
        for (Integer numero : numeros) {
            texto += numero + " ";
        }
        return texto;
    }
}
