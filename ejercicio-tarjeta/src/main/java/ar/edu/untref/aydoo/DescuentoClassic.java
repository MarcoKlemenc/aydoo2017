package ar.edu.untref.aydoo;

public class DescuentoClassic extends Descuento {

    public DescuentoClassic(int porcentaje, Establecimiento establecimiento)
            throws PorcentajeInvalidoException {

        super(porcentaje);
        establecimiento.setBeneficioClassic(this);
    }
}
