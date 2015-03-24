package es.jab.controller.ejb;

import java.util.List;

import es.jab.controller.BorraTemaController;
import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.jpa.DaoFactoryJpa;
import es.jab.persistence.model.entities.Tema;

public class BorraTemaControllerEjb implements BorraTemaController {

	@Override
	public List<Tema> recuperarTemas() {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
		return DaoFactory.getInstance().getTemaDao().findAll();
	}

	@Override
	public Tema recuperarTemaPorId(int id) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
		return DaoFactory.getInstance().getTemaDao().read(id);
	}

	@Override
	public void borrarTema(int id) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
		DaoFactory.getInstance().getValoracionDao().deleteByTema(id);
		DaoFactory.getInstance().getTemaDao().deleteById(id);
	}

}
