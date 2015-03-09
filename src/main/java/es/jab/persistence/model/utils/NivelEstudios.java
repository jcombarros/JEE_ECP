package es.jab.persistence.model.utils;

public enum NivelEstudios {
	
	PRIMARIA(1,"Educación Primaria"),
	SECUNDARIA(2, "Educación Secundaria"),
	FP(2, "Formación Profesional"),
	UNIVERSITARIA(4,"Educación Universitaria");
		
	private int id;
	
	private String descripcion;
	
	private NivelEstudios (int id, String descripcion){
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
