package ar.edu.untref.aydoo;

public class CreadorFormato {

    public Formato crear(String tipo, int numero) {

        if (tipo.equals("pretty")) {
            return new FormatoPretty(numero);
        }
        if (tipo.equals("quiet")) {
            return new FormatoQuiet();
        }
        throw new IllegalArgumentException("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
    }
}
