package ar.edu.untref.aydoo;

public class TarjetaClassic extends Tarjeta {

    public TarjetaClassic(final Cliente cliente) {

        super(cliente);
    }

    public int aplicarBeneficio(final Compra compra) {

        Beneficio beneficio = compra.getSucursal().getEstablecimiento()
                .getBeneficioClassic();
        if (beneficio != null) {
            return beneficio.aplicar(compra);
        }
        return compra.calcularMontoBruto();
    }
}
