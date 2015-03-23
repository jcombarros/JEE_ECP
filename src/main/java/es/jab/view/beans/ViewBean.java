package es.jab.view.beans;

import javax.faces.bean.ManagedProperty;

import es.jab.controller.ControllerFactory;


public abstract class ViewBean {
	
	@ManagedProperty(value = "#{controllerEjbFactory}")
    private ControllerFactory controllerFactory;

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

}
