package ar.edu.untref.aydoo;

abstract class Descuento {

    protected int porcentaje;

    public Descuento(int porcentaje) throws PorcentajeInvalidoException {

        if (porcentaje >= 5) {
            this.porcentaje = porcentaje;
        } else {
            throw new PorcentajeInvalidoException();
        }
    }

    public int getPorcentaje() {

        return porcentaje;
    }

    public int aplicar(int valorBruto) {

        return (int) valorBruto - valorBruto * porcentaje / 100;
    }
}