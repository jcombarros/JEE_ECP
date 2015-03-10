package es.jab.persistence.model.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.TemaDao;
import es.jab.persistence.model.dao.ValoracionDao;

public class DaoFactoryJpa extends DaoFactory {
	
	private static final String PERSISTENCE_UNIT = "JEE_ECP";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoFactoryJpa() {
        LogManager.getLogger(DaoFactoryJpa.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

	@Override
	public TemaDao getTemaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValoracionDao getValoracionDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
