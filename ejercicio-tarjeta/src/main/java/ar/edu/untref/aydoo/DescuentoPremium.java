package ar.edu.untref.aydoo;

public class DescuentoPremium {

    private int porcentaje;

    public DescuentoPremium(int porcentaje, Establecimiento establecimiento)
            throws PorcentajeInvalidoException {

        if (porcentaje >= 5) {
            this.porcentaje = porcentaje;
            establecimiento.setDescuentoPremium(this);
        } else {
            throw new PorcentajeInvalidoException();
        }
    }

    public int aplicar(int valorBruto) {

        return (int) valorBruto - valorBruto * porcentaje / 100;
    }
}
