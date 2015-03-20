package es.jab.view.beans;

import java.io.Serializable;
import java.util.List;

import es.jab.persistence.model.entities.Tema;

public class BorraTemaView implements Serializable{

	private static final long serialVersionUID = 1L;

	private String mensaje;
	
	private String identificador;
	
	private List<Tema> temas;
	
	private Tema tema;
	
	public BorraTemaView(){
		
	}
	
	public BorraTemaView(Tema tema){
		this.tema = tema;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
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
