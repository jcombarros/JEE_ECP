package es.jab.persistence.model.dao;

import java.util.List;

import es.jab.persistence.model.entities.Valoracion;

public interface ValoracionDao extends GenericDao<Valoracion, Integer> {
	
	public void deleteByTema(int id);
	
	public List<Valoracion> getByTema(int id);

}
