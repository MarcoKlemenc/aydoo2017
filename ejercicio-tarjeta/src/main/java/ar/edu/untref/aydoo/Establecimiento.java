package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private final String nombre;
    private List<Sucursal> sucursales;
    private Beneficio beneficioClassic;
    private Beneficio beneficioPremium;

    public Establecimiento(final String nombreNuevo) {

        this.sucursales = new ArrayList<Sucursal>();
        this.nombre = nombreNuevo;
    }

    public Beneficio getBeneficioClassic() {

        return beneficioClassic;
    }

    public void setBeneficioClassic(final Beneficio beneficio) {

        this.beneficioClassic = beneficio;
    }

    public Beneficio getBeneficioPremium() {

        return beneficioPremium;
    }

    public void setBeneficioPremium(final Beneficio beneficio) {

        this.beneficioPremium = beneficio;
    }

    public String getNombre() {

        return nombre;
    }

    public List<Sucursal> getSucursales() {

        return sucursales;
    }

    public void agregarSucursal(final Sucursal sucursal) {

        sucursales.add(sucursal);
    }

    public int calcularTotalBeneficios() {

        int total = 0;
        for (Sucursal s : sucursales) {
            total += s.getCantidadBeneficiosOtorgados();
        }
        return total;
    }
}
