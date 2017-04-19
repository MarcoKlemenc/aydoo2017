package ar.edu.untref.aydoo;

public class DescuentoPremium extends Descuento {

    public DescuentoPremium(int porcentaje, Establecimiento establecimiento)
            throws PorcentajeInvalidoException {

        super(porcentaje);
        establecimiento.setBeneficioPremium(this);
    }
}
