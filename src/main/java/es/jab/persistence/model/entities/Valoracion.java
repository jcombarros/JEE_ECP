package es.jab.persistence.model.entities;

import es.jab.persistence.model.utils.NivelEstudios;

public class Valoracion {
	
	private int id;
	
	private Tema tema;
	
	private NivelEstudios nivelEstudios;
	
	public Valoracion (Tema tema, NivelEstudios nivelEstudios){
		this.tema = tema;
		this.setNivelEstudios(nivelEstudios);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

}
