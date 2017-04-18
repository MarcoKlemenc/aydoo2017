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

    public int aplicarDescuento(Compra compra, Tarjeta tarjeta) throws UnSoloProductoException {

        if (establecimiento.getBeneficio2x1() != null) {
            return establecimiento.getBeneficio2x1().aplicar(compra.getProductos());
        }
        if (establecimiento.getDescuentoClassic() != null && tarjeta instanceof TarjetaClassic) {
            return establecimiento.getDescuentoClassic().aplicar(compra.calcularMontoBruto());
        }
        if (establecimiento.getDescuentoPremium() != null && tarjeta instanceof TarjetaPremium) {
            return establecimiento.getDescuentoPremium().aplicar(compra.calcularMontoBruto());
        }
        return compra.calcularMontoBruto();
    }

    public void registrarCompra(Compra compra) {

        cantidadBeneficiosOtorgados++;
    }

    public Establecimiento getEstablecimiento() {

        return establecimiento;
    }
}
