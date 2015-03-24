package es.jab.controller.ejb;

import java.util.List;

import es.jab.controller.VerTemasController;
import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.jpa.DaoFactoryJpa;
import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;

public class VerTemasControllerEjb implements VerTemasController {

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
	public void guardaValoracion(Valoracion valoracion) {
		DaoFactory.setDaoFactory(new DaoFactoryJpa());
		Valoracion valoracionBD = DaoFactory.getInstance().getValoracionDao().read(valoracion.getId());
		if(valoracionBD == null){
			DaoFactory.getInstance().getValoracionDao().create(valoracionBD);
		}
	}

}
