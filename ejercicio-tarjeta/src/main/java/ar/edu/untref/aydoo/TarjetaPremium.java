package ar.edu.untref.aydoo;

public class TarjetaPremium extends Tarjeta {

    public TarjetaPremium(final Cliente cliente) {

        super(cliente);
    }

    public int aplicarDescuento(final Compra compra) {

        Beneficio beneficio = compra.getSucursal().getEstablecimiento()
                .getBeneficioPremium();
        if (beneficio != null) {
            return beneficio.aplicar(compra);
        }
        return compra.calcularMontoBruto();
    }
}
