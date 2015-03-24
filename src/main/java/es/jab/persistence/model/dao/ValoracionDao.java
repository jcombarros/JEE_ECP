package es.jab.persistence.model.dao;

import es.jab.persistence.model.entities.Valoracion;

public interface ValoracionDao extends GenericDao<Valoracion, Integer> {
	
	public void deleteByTema(int id);

}
