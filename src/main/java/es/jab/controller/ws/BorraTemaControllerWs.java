package es.jab.controller.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import es.jab.controller.BorraTemaController;
import es.jab.persistence.model.entities.Tema;

public class BorraTemaControllerWs implements BorraTemaController {

	@Override
	public List<Tema> recuperarTemas() {
		GenericType <List<Tema>> genericType = new GenericType<List<Tema>>() {};
		return ControllerWs.buildWebServiceManager("/temas").entities(genericType);
	}

	@Override
	public Tema recuperarTemaPorId(int id) {
		return ControllerWs.buildWebServiceManager("/temas", String.valueOf(id)).entity(Tema.class);
	}

	@Override
	public void borrarTema(int id) {
		ControllerWs.buildWebServiceManager("/temas", String.valueOf(id)).delete();

	}

}
