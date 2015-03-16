package es.jab.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;

public class TemaView implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Tema> temas;
	
	private Tema tema;
	
	private Valoracion valoracion;
	
	public TemaView(){
		
	}
	
	public TemaView(Tema tema){
		this.temas = null;
		this.tema = tema;
		this.valoracion = null;
	}
	
	public TemaView(List<Tema> temas, Tema tema, Valoracion valoracion){
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
	
	public void update(){
		LogManager.getLogger(TemaView.class).debug(
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

	public void addTema(Integer temaId) {
		LogManager.getLogger(TemaView.class).debug(
                "Se accede a la capa de negocio para recuperar temaPorId");
		//INICIO Mock
		Tema temaMock = new Tema("pregunta x", "¿Por qué?");
		//FIN    Mock
		if(temaMock != null){
			Valoracion valoracion = new Valoracion();
			valoracion.setTema(temaMock);
			this.valoracion = valoracion;
			this.tema = temaMock;
		}
	}

}
