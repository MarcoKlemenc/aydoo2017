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

    public int aplicarDescuento(int valorBruto, Tarjeta tarjeta) {

        return establecimiento.getDescuentoPremium().aplicar(valorBruto);
    }

    public void registrarCompra(Compra compra) {

        cantidadBeneficiosOtorgados++;
    }

    public Establecimiento getEstablecimiento() {

        return establecimiento;
    }
}
