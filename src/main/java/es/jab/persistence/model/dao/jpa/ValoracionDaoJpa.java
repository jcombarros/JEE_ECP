package es.jab.persistence.model.dao.jpa;

import es.jab.persistence.model.dao.ValoracionDao;
import es.jab.persistence.model.entities.Valoracion;

public class ValoracionDaoJpa extends GenericDaoJpa<Valoracion, Integer> implements ValoracionDao {

	public ValoracionDaoJpa() {
        super(Valoracion.class);
    }

}
