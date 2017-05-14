package ar.edu.untref.aydoo;

public class TarjetaPremium extends Tarjeta {

    public TarjetaPremium(final Cliente cliente) {

        super(cliente);
    }

    public int aplicarDescuento(Compra compra) {

        Beneficio beneficio = compra.getSucursal().getEstablecimiento().getBeneficioPremium();
        return beneficio != null ? beneficio.aplicar(compra) : compra.calcularMontoBruto();
    }
}
