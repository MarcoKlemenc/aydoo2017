package ar.edu.untref.aydoo;

/**
 * Created by nicopaez on 4/12/17.
 */
public class Sucursal {
    public String getNombre() {
        return nombre;
    }

    private final String nombre;
    private int cantidadBeneficiosOtorgados;
    private Establecimiento establecimiento;

    public Sucursal(String nombre, Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
        this.nombre = nombre;
    }

    public int getCantidadBeneficiosOtorgados() {
        return cantidadBeneficiosOtorgados;
    }

    public int aplicarDescuento(int valorBruto, Tarjeta tarjeta) {
        DescuentoParaTarjetaPremium descuento = establecimiento.getDescuentoPremium();
        return descuento.aplicar(valorBruto);
    }

    public void registrarCompra(Compra compra) {
        cantidadBeneficiosOtorgados++;
    }
}
