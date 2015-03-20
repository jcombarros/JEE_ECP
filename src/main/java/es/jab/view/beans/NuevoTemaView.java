package es.jab.view.beans;

import java.io.Serializable;

import es.jab.persistence.model.entities.Tema;

public class NuevoTemaView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	private Tema tema;
	
	public NuevoTemaView(){
		
	}
	
	public NuevoTemaView(Tema tema){
		this.tema = tema;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void update(){
	}
	
}
