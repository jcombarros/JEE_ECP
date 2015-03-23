package es.jab.controller;

import java.util.List;

import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;

public interface VerTemasController {

	List<Tema> recuperarTemas();
	
	Tema recuperarTemaPorId(int id);
	
	void guardaValoracion(Valoracion valoracion);
	
}
