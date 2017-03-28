package ar.edu.untref.aydoo;

import java.util.HashMap;

public class Votacion {

	public HashMap<String, Provincia> provincias = new HashMap<String, Provincia>();
	public HashMap<String, Candidato> candidatos = new HashMap<String, Candidato>();
	public HashMap<String, Elector> electores = new HashMap<String, Elector>();

	public void emitirVoto(String votante, String elegido) {
		if (electores.containsKey(votante) && candidatos.containsKey(elegido)) {
			electores.get(votante).votar(candidatos.get(elegido));
		} else {
			throw new Error("El votante o candidato no existe");
		}
	}

	public void agregarProvincia(String nombre) {
		provincias.put(nombre, new Provincia(nombre));
	}

	public void agregarCandidato(String nombre, String partido) {
		candidatos.put(nombre, new Candidato(nombre, partido));
	}

	public void agregarElector(String nombre, String provincia) {
		if (provincias.containsKey(provincia)) {
			electores.put(nombre, new Elector(nombre, provincias.get(provincia)));
		} else {
			throw new Error("La provincia no existe");
		}
	}

	public String buscarMasVotadoEnMapa(HashMap<String, Integer> votos) {
		if (!votos.isEmpty()) {
			String masVotado = "";
			int mayorCantidadVotos = 0;
			for (String clave : votos.keySet()) {
				int cantidad = votos.get(clave);
				if (cantidad > mayorCantidadVotos) {
					masVotado = clave;
					mayorCantidadVotos = cantidad;
				}
			}
			return masVotado;
		} else {
			throw new Error("No hay votos registrados");
		}
	}

	public String calcularCandidatoMasVotado() {
		HashMap<String, Integer> votosTotales = new HashMap<String, Integer>();
		for (String provincia : this.provincias.keySet()) {
			Provincia p = this.provincias.get(provincia);
			HashMap<Candidato, Integer> votos = p.getVotos();
			for (Candidato candidato : votos.keySet()) {
				String nombre = candidato.getNombre();
				if (!votosTotales.containsKey(nombre)) {
					votosTotales.put(nombre, votos.get(candidato));
				} else {
					votosTotales.put(nombre, votosTotales.get(nombre) + votos.get(candidato));
				}
			}
		}
		return buscarMasVotadoEnMapa(votosTotales);
	}

	public String calcularPartidoMasVotadoEnProvincia(String provincia) {
		if (provincias.containsKey(provincia)) {
			HashMap<String, Integer> votosPorPartido = new HashMap<String, Integer>();
			HashMap<Candidato, Integer> votos = provincias.get(provincia).getVotos();
			for (Candidato c : votos.keySet()) {
				String partido = c.getPartido();
				if (!votosPorPartido.containsKey(partido)) {
					votosPorPartido.put(partido, votos.get(c));
				} else {
					votosPorPartido.put(partido, votosPorPartido.get(partido) + votos.get(c));
				}

			}
			return buscarMasVotadoEnMapa(votosPorPartido);
		} else {
			throw new Error("La provincia no existe");
		}
	}
}
