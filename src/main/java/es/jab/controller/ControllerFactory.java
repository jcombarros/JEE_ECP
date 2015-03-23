package es.jab.controller;

public abstract class ControllerFactory {
	
	public abstract VerTemasController getVerTemasController();
	
	public abstract NuevoTemaController getNuevoTemaController();
	
	public abstract BorraTemaController getBorraTemaController();
	
	public abstract VerVotacionesController getVerVotacionesController();
	
}
