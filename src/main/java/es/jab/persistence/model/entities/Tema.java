package es.jab.persistence.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {
	
	@Id
	@ GeneratedValue
	private int id;
	
	private String nombre;
	
	private String pregunta;
	
	public Tema (){
		
	}
	
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
	
	@Override
	public boolean equals(Object temaObj){
		Tema tema = (Tema)temaObj;
		return this.getId() == tema.getId() && this.getNombre() == tema.getNombre() && this.getPregunta() == tema.getPregunta();
	}

}
