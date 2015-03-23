package es.jab.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.jab.persistence.model.entities.dto.TemaDTO;
import es.jab.persistence.model.utils.NivelEstudios;

public class ValoracionesView implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String mensaje;
	
	private List<TemaDTO> temas;
	
	private List<NivelEstudios> nivelesEstudios; 
	
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
	
	public List<NivelEstudios> getNivelesEstudios() {
		return nivelesEstudios;
	}

	public void setNivelesEstudios(List<NivelEstudios> nivelesEstudios) {
		this.nivelesEstudios = nivelesEstudios;
	}

	public void update(){
		//INICIO Mock
		List<TemaDTO> temasDTOMock = new ArrayList<TemaDTO>();
		List<Double> mediaPorNivel = new ArrayList<Double>();
		mediaPorNivel.add(new Double (2.5));
		mediaPorNivel.add(new Double (3.7));
		mediaPorNivel.add(new Double (6));
		mediaPorNivel.add(new Double (9));
		temasDTOMock.add(new TemaDTO("pregunta 1", "¿Qué?", 4, mediaPorNivel));
		temasDTOMock.add(new TemaDTO("pregunta 2", "¿Cómo?", 7, mediaPorNivel));
		temasDTOMock.add(new TemaDTO("pregunta 3", "¿Quién?", 3, mediaPorNivel));
		temasDTOMock.add(new TemaDTO("pregunta 4", "¿Cuando?", 8, mediaPorNivel));
		temasDTOMock.add(new TemaDTO("pregunta 5", "¿Dónde?", 6, mediaPorNivel));
		//FIN    Mock
		if (temasDTOMock.isEmpty()){
			this.mensaje = "Aún no se ha añadido ningún tema.";
		}
		this.nivelesEstudios = new ArrayList<NivelEstudios>(Arrays.asList(NivelEstudios.values()));
		this.temas = temasDTOMock;
	}
	
	public String process(){
		return null;
	}

}
