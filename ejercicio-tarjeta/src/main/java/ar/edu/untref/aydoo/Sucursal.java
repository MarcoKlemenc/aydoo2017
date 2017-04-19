package ar.edu.untref.aydoo;

public class Sucursal {

    private final String nombre;
    private int cantidadBeneficiosOtorgados;
    private Establecimiento establecimiento;

    public Sucursal(final String nombreNuevo,
                    final Establecimiento establecimientoNuevo) {

        this.establecimiento = establecimientoNuevo;
        this.nombre = nombreNuevo;
        establecimientoNuevo.agregarSucursal(this);
    }

    public String getNombre() {

        return nombre;
    }

    public int getCantidadBeneficiosOtorgados() {

        return cantidadBeneficiosOtorgados;
    }

    public int aplicarDescuento(final Compra compra, final Tarjeta tarjeta) {

        if (establecimiento.getBeneficioClassic() != null
                && tarjeta instanceof TarjetaClassic) {
            return establecimiento.getBeneficioClassic().aplicar(compra);
        }
        if (establecimiento.getBeneficioPremium() != null
                && tarjeta instanceof TarjetaPremium) {
            return establecimiento.getBeneficioPremium().aplicar(compra);
        }
        return compra.calcularMontoBruto();
    }

    public void registrarCompra() {

        cantidadBeneficiosOtorgados++;
    }

    public Establecimiento getEstablecimiento() {

        return establecimiento;
    }
}
