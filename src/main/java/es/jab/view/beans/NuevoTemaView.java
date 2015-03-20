package es.jab.view.beans;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;

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

	public String process() {
		if(this.tema.getNombre() != "" && this.tema.getPregunta() != ""){
			LogManager.getLogger(NuevoTemaView.class).debug(
	                "Se accede a la capa de negocio para guardar el nuevo Tema");
			//INICIO Mock
			Tema temaGuardado = this.tema;
			//FIN    Mock
			return "home";
		}
		else{
			this.mensaje = "Debe rellenar todos los campos";
			return "nuevoTema";
		}
	}
	
}
