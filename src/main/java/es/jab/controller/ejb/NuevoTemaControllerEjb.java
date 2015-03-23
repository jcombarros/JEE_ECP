package es.jab.controller.ejb;

import es.jab.controller.NuevoTemaController;
import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.jpa.DaoFactoryJpa;
import es.jab.persistence.model.entities.Tema;


public class NuevoTemaControllerEjb implements NuevoTemaController {

	@Override
	public void guardaTema(Tema tema) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
		Tema temaBD = DaoFactory.getInstance().getTemaDao().read(tema.getId());
		if(temaBD == null){
			DaoFactory.getInstance().getTemaDao().create(tema);
		}
	}

}
