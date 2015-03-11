package es.jab.persistence.model.dao.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.ValoracionDao;
import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;
import es.jab.persistence.model.utils.NivelEstudios;

public class ValoracionDaoJpaTest {
	
	private ValoracionDao valoracionDao;
	
	private Valoracion valoracion;
	
	@BeforeClass
    public static void beforeClass() {
		DaoFactoryJpa.setDaoFactory(new DaoFactoryJpa());
		DaoFactoryJpa.dropAndCreateTables();
	}
	
	@Before
    public void before() {
        this.valoracion = new Valoracion(new Tema("Pregunta 1", "¿Pregunta 1?"), NivelEstudios.UNIVERSITARIA);
        valoracionDao = DaoFactory.getInstance().getValoracionDao();
        valoracionDao.create(valoracion);
    }
	
	@After
	public void after() {
		DaoFactoryJpa.dropAndCreateTables();
	}

}
