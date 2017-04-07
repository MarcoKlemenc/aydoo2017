package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Votacion {

    // utilizo sets para asegurarme de que no se repitan elementos
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

    private Object buscarMasVotadoEnMapa(Map<Object, Integer> votos) {
        if (!votos.isEmpty()) {
            Object masVotado = null;
            int mayorCantidadVotos = 0;
            for (Map.Entry<Object, Integer> e : votos.entrySet()) {
                int cantidad = e.getValue();
                if (cantidad > mayorCantidadVotos) {
                    masVotado = e.getKey();
                    mayorCantidadVotos = cantidad;
                }
            }
            return masVotado;
        } else {
            throw new Error("No hay votos registrados");
        }
    }

    public Candidato calcularCandidatoMasVotado() {
        Map<Object, Integer> votosTotales = new HashMap<Object, Integer>();
        for (Provincia p : this.provincias) {
            Map<Candidato, Integer> votos = p.getVotos();
            for (Candidato c : votos.keySet()) {
                if (!votosTotales.containsKey(c)) {
                    votosTotales.put(c, votos.get(c));
                } else {
                    votosTotales.put(c, votosTotales.get(c) + votos.get(c));
                }
            }
        }
        return (Candidato) buscarMasVotadoEnMapa(votosTotales);
    }

    public String calcularPartidoMasVotadoEnProvincia(Provincia provincia) {
        if (provincias.contains(provincia)) {
            Map<Object, Integer> votosPorPartido = new HashMap<Object, Integer>();
            Map<Candidato, Integer> votos = provincia.getVotos();
            for (Candidato c : votos.keySet()) {
                String partido = c.getPartido();
                if (!votosPorPartido.containsKey(partido)) {
                    votosPorPartido.put(partido, votos.get(c));
                } else {
                    votosPorPartido.put(partido, votosPorPartido.get(partido) + votos.get(c));
                }

            }
            return (String) buscarMasVotadoEnMapa(votosPorPartido);
        } else {
            throw new Error("La provincia no existe");
        }
    }
}
