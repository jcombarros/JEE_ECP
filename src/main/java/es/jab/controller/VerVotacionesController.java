package es.jab.controller;

import java.util.List;

import es.jab.persistence.model.entities.dto.TemaDTO;

public interface VerVotacionesController {
	
	List<TemaDTO> recuperarVotaciones();
	
}
