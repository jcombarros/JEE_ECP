package es.jab.controller.ws;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.jab.controller.BorraTemaController;
import es.jab.controller.ControllerFactory;
import es.jab.controller.NuevoTemaController;
import es.jab.controller.VerTemasController;
import es.jab.controller.VerVotacionesController;
import es.jab.controller.ws.BorraTemaControllerWs;
import es.jab.controller.ws.NuevoTemaControllerWs;
import es.jab.controller.ws.VerTemasControllerWs;
import es.jab.controller.ws.VerVotacionesControllerWs;

@ManagedBean(name = "controllerWsFactory")
@ApplicationScoped
public class ControllerWsFactory extends ControllerFactory {
	
	private VerTemasController verTemasController;
	
	private NuevoTemaController nuevoTemaController;
	
	private BorraTemaController borraTemaController;
	
	private VerVotacionesController verVotacionesController;
	
	public ControllerWsFactory() {
	}

	@Override
	public VerTemasController getVerTemasController() {
		if (verTemasController == null) {
			verTemasController = new VerTemasControllerWs();
        }
        return verTemasController;
	}

	@Override
	public NuevoTemaController getNuevoTemaController() {
		if (nuevoTemaController == null) {
			nuevoTemaController = new NuevoTemaControllerWs();
        }
        return nuevoTemaController;
	}

	@Override
	public BorraTemaController getBorraTemaController() {
		if (borraTemaController == null) {
			borraTemaController = new BorraTemaControllerWs();
        }
        return borraTemaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerWs();
        }
        return verVotacionesController;
	}

}
