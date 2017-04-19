package ar.edu.untref.aydoo;

public class DescuentoClassic extends Descuento {

    public DescuentoClassic(final int porcentaje,
                            final Establecimiento establecimiento)
            throws PorcentajeInvalidoException {

        super(porcentaje);
        establecimiento.setBeneficioClassic(this);
    }
}
