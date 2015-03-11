package es.jab.persistence.model.dao.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.jab.persistence.model.dao.DaoFactory;
import es.jab.persistence.model.dao.TemaDao;
import es.jab.persistence.model.entities.Tema;
 
public class TemaDaoJpaTest {
	
	private TemaDao temaDao;
	
	private Tema tema;
	
	@BeforeClass
    public static void beforeClass() {
		DaoFactoryJpa.setDaoFactory(new DaoFactoryJpa());
		DaoFactoryJpa.dropAndCreateTables();
	}
	
	@Before
    public void before() {
        this.tema = new Tema("Pregunta 1", "¿Pregunta 1?");
        temaDao = DaoFactory.getInstance().getTemaDao();
        temaDao.create(tema);
    }
	
	@Test
    public void testRead() {
		Tema t = temaDao.read(tema.getId());
        assertEquals(tema, temaDao.read(tema.getId()));
    }
	
	@Test
    public void testUpdate() {
        tema.setNombre("Pregunta 1.1");
        tema.setPregunta("¿Pregunta 1.1?");
        temaDao.update(tema);
        assertEquals(tema, temaDao.read(tema.getId()));
    }
	
	@Test
    public void testDeleteByID() {
		temaDao.deleteById(tema.getId());
        assertNull(temaDao.read(tema.getId()));
    }
	
	@Test
    public void testFindAll() {
        this.tema = new Tema("Pregunta 2", "¿Pregunta 2?");
        temaDao = DaoFactory.getInstance().getTemaDao();
        temaDao.create(tema);
        assertEquals(2, temaDao.findAll().size());
    }
	
	@After
	public void after() {
		DaoFactoryJpa.dropAndCreateTables();
	}

}
