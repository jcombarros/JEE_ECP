package es.jab.persistence.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import es.jab.persistence.model.utils.NivelEstudios;

@Entity
public class Valoracion {
	
	@Id
	@ GeneratedValue
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Tema tema;
	
	private NivelEstudios nivelEstudios;
	
	private int respuesta;
	
	public Valoracion (){
		
	}
	
	public Valoracion (Tema tema, NivelEstudios nivelEstudios, int respuesta){
		this.tema = tema;
		this.setNivelEstudios(nivelEstudios);
		this.setRespuesta(respuesta);
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

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		assert respuesta>= 0 && respuesta <= 10;
		this.respuesta = respuesta;
	}

}
