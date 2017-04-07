package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

public class Provincia {

    private String nombre;
    private Map<Candidato, Integer> votos;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.votos = new HashMap<Candidato, Integer>();
    }

    public void registrarVoto(Candidato elegido) {
        if (!votos.containsKey(elegido))
            votos.put(elegido, 1);
        else
            votos.put(elegido, votos.get(elegido) + 1);
    }

    public String getNombre() {
        return nombre;
    }

    public Map<Candidato, Integer> getVotos() {
        return votos;
    }

}
