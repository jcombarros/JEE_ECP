package es.jab.persistence.model.dao.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.TemaDao;
import es.jab.persistence.model.dao.ValoracionDao;

public class DaoFactoryJpa extends DaoFactory {
	
	private static final String PERSISTENCE_UNIT = "miwjee";

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoFactoryJpa() {
        LogManager.getLogger(DaoFactoryJpa.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public TemaDao getTemaDao() {
        return new TemaDaoJpa();
    }
    
    @Override
    public ValoracionDao getValoracionDao() {
        return new ValoracionDaoJpa();
    }
    
    public static void dropAndCreateTables() {
	    Map<String, String> properties = new HashMap<>();
	    properties.put(PersistenceUnitProperties.DDL_GENERATION,
	            PersistenceUnitProperties.DROP_AND_CREATE);
	    Persistence.createEntityManagerFactory("miwjee", properties).createEntityManager();

    }
}
