package ar.edu.untref.aydoo;

import java.util.HashMap;

public class Provincia {

	private String nombre;
	private HashMap<Candidato, Integer> votos;

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

	public HashMap<Candidato, Integer> getVotos() {
		return votos;
	}

}
