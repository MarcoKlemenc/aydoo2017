package ar.edu.untref.aydoo;

import java.util.List;

public class FormatoQuiet implements Formato {

    public String aplicar(final List<Integer> numeros) {

        String texto = "";
        for (Integer n : numeros) {
            texto += n + "\n";
        }
        return texto;
    }
}
