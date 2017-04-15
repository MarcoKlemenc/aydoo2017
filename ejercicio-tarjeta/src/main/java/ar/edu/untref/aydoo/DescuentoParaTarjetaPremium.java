package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class DescuentoParaTarjetaPremium {
    private int porcentajeDescuento;

    public DescuentoParaTarjetaPremium(int porcentajeDescuento, Establecimiento establecimiento) {
        this.porcentajeDescuento = porcentajeDescuento;
        establecimiento.setDescuentoPremium(this);
    }

    public int aplicar(int valorBruto) {
        return (int) valorBruto - valorBruto * porcentajeDescuento / 100;
    }
}
