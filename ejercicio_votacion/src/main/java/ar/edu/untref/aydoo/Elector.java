package ar.edu.untref.aydoo;

public class Elector {

	private String nombre;
	private Provincia provincia;
	private boolean votoEmitido;

	public Elector(String nombre, Provincia provincia) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.votoEmitido = false;
	}

	public void votar(Candidato elegido) {
		if (!votoEmitido) {
			provincia.registrarVoto(elegido);
			votoEmitido = true;
		} else
			throw new Error("El elector ya voto");
	}

	public String getNombre() {
		return nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public boolean isVotoEmitido() {
		return votoEmitido;
	}

}
