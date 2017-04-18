package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private final String nombre;
    private List<Sucursal> sucursales;
    private DescuentoClassic descuentoClassic;
    private DescuentoPremium descuentoPremium;

    public Establecimiento(String nombre) {

        this.sucursales = new ArrayList<Sucursal>();
        this.nombre = nombre;
    }

    public DescuentoClassic getDescuentoClassic() {

        return descuentoClassic;
    }

    public void setDescuentoClassic(DescuentoClassic descuento) {

        this.descuentoClassic = descuento;
    }

    public DescuentoPremium getDescuentoPremium() {

        return descuentoPremium;
    }

    public void setDescuentoPremium(DescuentoPremium descuento) {

        this.descuentoPremium = descuento;
    }

    public String getNombre() {

        return nombre;
    }

    public List<Sucursal> getSucursales() {

        return sucursales;
    }

    public void agregarSucursal(Sucursal sucursal) {

        sucursales.add(sucursal);
    }

    public int calcularTotalBeneficios() {

        int total = 0;
        for (Sucursal s : sucursales){
            total += s.getCantidadBeneficiosOtorgados();
        }
        return total;
    }
}
