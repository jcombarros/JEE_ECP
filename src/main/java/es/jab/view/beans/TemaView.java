package es.jab.view.beans;

import java.io.Serializable;
import java.util.List;

import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;

public class TemaView implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Tema> temas;
	
	private Tema tema;
	
	private Valoracion valoracion;
	
	private TemaView(){
		
	}
	
	private TemaView(List<Tema> temas, Tema tema, Valoracion valoracion){
		this.temas = temas;
		this.tema = tema;
		this.valoracion = valoracion;
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

	public Valoracion getValoracion() {
		return valoracion;
	}

	public void setValoracion(Valoracion valoracion) {
		this.valoracion = valoracion;
	}

}
