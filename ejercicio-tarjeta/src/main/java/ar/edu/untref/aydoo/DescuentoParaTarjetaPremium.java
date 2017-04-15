package ar.edu.untref.aydoo;

public class DescuentoParaTarjetaPremium {

    private int porcentajeDescuento;

    public DescuentoParaTarjetaPremium(int porcentajeDescuento,
                                       Establecimiento establecimiento) {

        this.porcentajeDescuento = porcentajeDescuento;
        establecimiento.setDescuentoPremium(this);
    }

    public int aplicar(int valorBruto) {

        return (int) valorBruto - valorBruto * porcentajeDescuento / 100;
    }
}
