package ar.edu.untref.aydoo;

public class Establecimiento {

    private final String nombre;
    private DescuentoPremium descuentoPremium;

    public Establecimiento(String nombre) {

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
}
