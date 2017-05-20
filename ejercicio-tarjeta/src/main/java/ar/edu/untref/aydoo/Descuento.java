package ar.edu.untref.aydoo;

abstract class Descuento implements Beneficio {

    private static final int PORCENTAJE_MINIMO = 5;
    private static final int PORCIENTO = 100;

    private int porcentaje;

    Descuento(final int porcentajeNuevo) throws PorcentajeInvalidoException {

        if (porcentajeNuevo >= PORCENTAJE_MINIMO) {
            this.porcentaje = porcentajeNuevo;
        } else {
            throw new PorcentajeInvalidoException();
        }
    }

    public int getPorcentaje() {

        return porcentaje;
    }

    public int aplicar(final Compra compra) {

        int valorBruto = compra.calcularMontoBruto();
        return valorBruto - valorBruto * porcentaje / PORCIENTO;
    }
}
