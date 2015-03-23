package es.jab.controller.ejb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.jab.controller.BorraTemaController;
import es.jab.controller.ControllerFactory;
import es.jab.controller.NuevoTemaController;
import es.jab.controller.VerTemasController;
import es.jab.controller.VerVotacionesController;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {
	
	private VerTemasController verTemasController;
	
	private NuevoTemaController nuevoTemaController;
	
	private BorraTemaController borraTemaController;
	
	private VerVotacionesController verVotacionesController;
	
	public ControllerEjbFactory() {
	}

	@Override
	public VerTemasController getVerTemasController() {
		if (verTemasController == null) {
			verTemasController = new VerTemasControllerEjb();
        }
        return verTemasController;
	}

	@Override
	public NuevoTemaController getNuevoTemaController() {
		if (nuevoTemaController == null) {
			nuevoTemaController = new NuevoTemaControllerEjb();
        }
        return nuevoTemaController;
	}

	@Override
	public BorraTemaController getBorraTemaController() {
		if (borraTemaController == null) {
			borraTemaController = new BorraTemaControllerEjb();
        }
        return borraTemaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerEjb();
        }
        return verVotacionesController;
	}

}
