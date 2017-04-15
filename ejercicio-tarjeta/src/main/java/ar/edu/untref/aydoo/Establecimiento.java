package ar.edu.untref.aydoo;

public class Establecimiento {
    private final String nombre;
    private DescuentoParaTarjetaPremium descuentoPremium;

    public Establecimiento(String nombre) {
        this.nombre = nombre;
    }

    public void setDescuentoPremium(DescuentoParaTarjetaPremium descuento){
        this.descuentoPremium = descuento;
    }

    public DescuentoParaTarjetaPremium getDescuentoPremium(){
        return descuentoPremium;
    }

    public String getNombre() {
        return nombre;
    }

}
