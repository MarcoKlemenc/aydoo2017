package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private final String nombre;
    private List<Sucursal> sucursales;
    private DescuentoPremium descuentoPremium;

    public Establecimiento(String nombre) {

        this.sucursales = new ArrayList<Sucursal>();
        this.nombre = nombre;
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
}
