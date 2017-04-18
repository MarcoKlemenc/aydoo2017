package ar.edu.untref.aydoo;

public class UnSoloProductoException extends Exception {

    public UnSoloProductoException(){

        super("No se puede aplicar un 2x1 a un unico producto.");
    }
}
