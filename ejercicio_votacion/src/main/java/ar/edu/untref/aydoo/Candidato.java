package ar.edu.untref.aydoo;

public class Candidato {

    private String nombre;
    private String partido;

    public Candidato(String nombre, String partido) {
        this.nombre = nombre;
        this.partido = partido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPartido() {
        return partido;
    }

}
