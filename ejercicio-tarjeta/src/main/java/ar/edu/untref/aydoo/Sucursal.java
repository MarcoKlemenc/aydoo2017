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

        return tarjeta.aplicarBeneficio(compra);
    }

    public void registrarCompra() {

        cantidadBeneficiosOtorgados++;
    }

    public Establecimiento getEstablecimiento() {

        return establecimiento;
    }
}
