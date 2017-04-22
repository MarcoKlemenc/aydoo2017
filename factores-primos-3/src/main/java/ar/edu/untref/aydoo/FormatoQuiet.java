package ar.edu.untref.aydoo;

import java.util.List;

public class FormatoQuiet implements Formato {

    public String aplicar(List<Integer> numeros, String argumento) {
        String texto = "";
        for (Integer numero : numeros) {
            texto += numero + "\n";
        }
        return texto;
    }
}
