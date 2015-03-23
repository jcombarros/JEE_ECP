package es.jab.view.beans;

import java.io.Serializable;
import java.util.List;

import es.jab.persistence.model.entities.dto.TemaDTO;

public class ValoracionesView implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String mensaje;
	
	private List<TemaDTO> temas;
	
	public ValoracionesView(){
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<TemaDTO> getTemas() {
		return temas;
	}

	public void setTemas(List<TemaDTO> temas) {
		this.temas = temas;
	}
	
	public void Update(){
		
	}
	
	public String process(){
		return null;
	}

}
