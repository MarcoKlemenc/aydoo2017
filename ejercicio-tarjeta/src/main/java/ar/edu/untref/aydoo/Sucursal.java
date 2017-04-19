package ar.edu.untref.aydoo;

public class Sucursal {

    private final String nombre;
    private int cantidadBeneficiosOtorgados;
    private Establecimiento establecimiento;

    public Sucursal(String nombre, Establecimiento establecimiento) {

        this.establecimiento = establecimiento;
        this.nombre = nombre;
        establecimiento.agregarSucursal(this);
    }

    public String getNombre() {

        return nombre;
    }

    public int getCantidadBeneficiosOtorgados() {

        return cantidadBeneficiosOtorgados;
    }

    public int aplicarDescuento(Compra compra, Tarjeta tarjeta) {

        if (establecimiento.getBeneficioClassic() != null && tarjeta instanceof TarjetaClassic) {
            return establecimiento.getBeneficioClassic().aplicar(compra);
        }
        if (establecimiento.getBeneficioPremium() != null && tarjeta instanceof TarjetaPremium) {
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
