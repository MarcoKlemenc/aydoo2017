package ar.edu.untref.aydoo;

public class PorcentajeInvalidoException extends Exception {

    public PorcentajeInvalidoException(){
        super("El porcentaje utilizado no es valido.");
    }
}
