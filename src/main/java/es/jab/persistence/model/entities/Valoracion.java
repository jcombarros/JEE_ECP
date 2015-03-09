package es.jab.persistence.model.entities;

public class Valoracion {
	
	private int id;
	
	private Tema tema;
	
	public Valoracion (Tema tema){
		this.tema = tema;
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

}
