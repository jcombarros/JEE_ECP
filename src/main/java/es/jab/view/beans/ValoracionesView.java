package es.jab.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.jab.controller.VerTemasController;
import es.jab.controller.VerVotacionesController;
import es.jab.persistence.model.entities.dto.TemaDTO;
import es.jab.persistence.model.utils.NivelEstudios;

public class ValoracionesView extends ViewBean implements Serializable{
	
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
		LogManager.getLogger(ValoracionesView.class).debug(
                "Se accede a la capa de negocio para recuperar la lista de temas");

		List<TemaDTO> temasDTO = new ArrayList<TemaDTO>();

		VerVotacionesController verVotacionesController = this.getControllerFactory().getVerVotacionesController();
		temasDTO = verVotacionesController.recuperarVotaciones();
		if (temasDTO.isEmpty()){
			this.mensaje = "Aún no se ha añadido ningún tema.";
		}
		this.nivelesEstudios = new ArrayList<NivelEstudios>(Arrays.asList(NivelEstudios.values()));
		this.temas = temasDTO;
	}
	
	public String process(){
		return null;
	}

}
