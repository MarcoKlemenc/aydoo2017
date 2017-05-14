package ar.edu.untref.aydoo;

public class TarjetaClassic extends Tarjeta {

    public TarjetaClassic(final Cliente cliente) {

        super(cliente);
    }

    public int aplicarDescuento(Compra compra) {

        Beneficio beneficio = compra.getSucursal().getEstablecimiento().getBeneficioClassic();
        return beneficio != null ? beneficio.aplicar(compra) : compra.calcularMontoBruto();
    }
}
