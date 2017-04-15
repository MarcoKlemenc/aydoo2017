package ar.edu.untref.aydoo;

public class Sucursal {

    private final String nombre;
    private int cantidadBeneficiosOtorgados;
    private Establecimiento establecimiento;

    public Sucursal(String nombre, Establecimiento establecimiento) {

        this.establecimiento = establecimiento;
        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
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