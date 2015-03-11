package es.jab.persistence.model.dao.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        this.valoracion = new Valoracion(new Tema("Pregunta 1", "¿Pregunta 1?"), NivelEstudios.UNIVERSITARIA, 8);
        valoracionDao = DaoFactory.getInstance().getValoracionDao();
        valoracionDao.create(valoracion);
    }
	
	@Test
    public void testRead() {
		Valoracion v = valoracionDao.read(valoracion.getId());
        assertEquals(valoracion, valoracionDao.read(valoracion.getId()));
    }
	
	@Test
    public void testUpdate() {
		valoracion.getTema().setNombre("Pregunta 2");
		valoracion.getTema().setPregunta("¿Pregunta 2?");
		valoracion.setRespuesta(4);
		valoracion.setNivelEstudios(NivelEstudios.PRIMARIA);
        valoracionDao.update(valoracion);
        assertEquals(valoracion, valoracionDao.read(valoracion.getId()));
    }
	
	@Test
    public void testDeleteByID() {
		valoracionDao.deleteById(valoracion.getId());
        assertNull(valoracionDao.read(valoracion.getId()));
    }
	
	@Test
    public void testFindAll() {
        this.valoracion = new Valoracion(new Tema("Pregunta 3", "¿Pregunta 3?"),NivelEstudios.SECUNDARIA, 10);
        valoracionDao = DaoFactory.getInstance().getValoracionDao();
        valoracionDao.create(valoracion);
        assertEquals(2, valoracionDao.findAll().size());
    }
	
	@After
	public void after() {
		DaoFactoryJpa.dropAndCreateTables();
	}

}
