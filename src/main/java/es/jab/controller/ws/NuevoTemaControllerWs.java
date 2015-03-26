package es.jab.controller.ws;

import es.jab.controller.NuevoTemaController;
import es.jab.persistence.model.entities.Tema;

public class NuevoTemaControllerWs implements NuevoTemaController {

	@Override
	public void guardaTema(Tema tema) {
		ControllerWs.buildWebServiceManager("/temas").create(tema);
	}

}
