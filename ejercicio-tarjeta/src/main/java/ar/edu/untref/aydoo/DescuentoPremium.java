package ar.edu.untref.aydoo;

public class DescuentoPremium extends Descuento {

    public DescuentoPremium(final int porcentaje,
                            final Establecimiento establecimiento)
            throws PorcentajeInvalidoException {

        super(porcentaje);
        establecimiento.setBeneficioPremium(this);
    }
}
