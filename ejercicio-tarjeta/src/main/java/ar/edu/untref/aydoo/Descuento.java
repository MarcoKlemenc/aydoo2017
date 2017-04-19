package ar.edu.untref.aydoo;

abstract class Descuento implements Beneficio {

    private int porcentaje;

    Descuento(int porcentaje) throws PorcentajeInvalidoException {

        if (porcentaje >= 5) {
            this.porcentaje = porcentaje;
        } else {
            throw new PorcentajeInvalidoException();
        }
    }

    public int getPorcentaje() {

        return porcentaje;
    }

    public int aplicar(Compra compra) {

        int valorBruto = compra.calcularMontoBruto();
        return (int) valorBruto - valorBruto * porcentaje / 100;
    }
}
