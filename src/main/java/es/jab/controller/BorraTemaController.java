package es.jab.controller;

import java.util.List;

import es.jab.persistence.model.entities.Tema;

public interface BorraTemaController {
	
	List<Tema> recuperarTemas();
	
	Tema recuperarTemaPorId(int id);
	
	void borrarTema(int id);

}
