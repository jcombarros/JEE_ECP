package es.jab.persistence.model.dao.jpa;

import es.jab.persistence.model.dao.TemaDao;
import es.jab.persistence.model.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
        super(Tema.class);
    }

}
