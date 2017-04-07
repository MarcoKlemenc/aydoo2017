package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Votacion {

	public Set<Provincia> provincias = new HashSet<Provincia>();
	public Set<Candidato> candidatos = new HashSet<Candidato>();
	public Set<Elector> electores = new HashSet<Elector>();

	public void emitirVoto(Elector votante, Candidato elegido) {
		if (electores.contains(votante) && candidatos.contains(elegido)) {
			votante.votar(elegido);
		} else {
			throw new Error("El votante o candidato no existe");
		}
	}

	public void agregar(Provincia provincia) {
		provincias.add(provincia);
	}

	public void agregar(Candidato candidato) {
		candidatos.add(candidato);
	}

	public void agregar(Elector elector) {
		electores.add(elector);
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
		for (Provincia p : this.provincias) {
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

	public String calcularPartidoMasVotadoEnProvincia(Provincia provincia) {
		if (provincias.contains(provincia)) {
			HashMap<String, Integer> votosPorPartido = new HashMap<String, Integer>();
			HashMap<Candidato, Integer> votos = provincia.getVotos();
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
