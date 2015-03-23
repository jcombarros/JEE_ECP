package es.jab.persistence.model.entities.dto;

import java.util.List;

public class TemaDTO {
	
	//Data Transfer Object
	
	private String nombre;
	
	private String pregunta;
	
	private int numValoraciones;
	
	private List<Double> mediaPorNivel;
	
	public TemaDTO(){
		
	}
	
	public TemaDTO(String nombre, String pregunta, int numValoraciones, List<Double> mediaPorNivel){
		this.nombre = nombre;
		this.pregunta = pregunta;
		this.numValoraciones = numValoraciones;
		this.mediaPorNivel = mediaPorNivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public int getNumValoraciones() {
		return numValoraciones;
	}

	public void setNumValoraciones(int numValoraciones) {
		this.numValoraciones = numValoraciones;
	}

	public List<Double> getMediaPorNivel() {
		return mediaPorNivel;
	}

	public void setMediaPorNivel(List<Double> mediaPorNivel) {
		this.mediaPorNivel = mediaPorNivel;
	}

}
