package es.jab.persistence.model.entities;

public class Tema {
	
	private int id;
	
	private String nombre;
	
	private String pregunta;
	
	public Tema (String nombre, String pregunta){
		this.nombre = nombre;
		this.pregunta = pregunta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

}
