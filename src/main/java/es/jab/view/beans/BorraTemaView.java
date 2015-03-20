package es.jab.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.utils.NivelEstudios;

public class BorraTemaView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static String IDENTIFICADOR_VALIDO = "666";

	private String mensaje;
	
	private String identificador;
	
	private boolean autorizado = false;
	
	private List<Tema> temas;
	
	private Tema tema;
	
	public BorraTemaView(){
		this.identificador = "";
	}
	
	public BorraTemaView(Tema tema, String identificador){
		this.tema = tema;
		this.identificador = identificador;
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

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
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
		if(autorizado){
			LogManager.getLogger(TemasView.class).debug(
	                "Se accede a la capa de negocio para recuperar la lista de temas");
	        //INICIO Mock
			List<Tema> temasMock = new ArrayList<Tema>();
			temasMock.add(new Tema("pregunta 1", "¿Qué?"));
			temasMock.add(new Tema("pregunta 2", "¿Cómo?"));
			temasMock.add(new Tema("pregunta 3", "¿Quién?"));
			temasMock.add(new Tema("pregunta 4", "¿Cuando?"));
			temasMock.add(new Tema("pregunta 5", "¿Dónde?"));
			//FIN    Mock
			this.temas = temasMock;
		}
		else{
			this.mensaje = "Introduzca un Identificador de Autorización para borrar";
		}
		
	}

	public boolean isAutorizado() {
		return IDENTIFICADOR_VALIDO.equals(this.identificador);
	}
	
	public String process(){
		//TODO
		return null;
	}

}
