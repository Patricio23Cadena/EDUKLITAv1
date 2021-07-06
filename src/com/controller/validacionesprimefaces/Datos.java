package com.controller.validacionesprimefaces;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("userioDato")
@RequestScoped
public class Datos {


	public String get() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario").toString();
	}
	public String getA() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("apellido").toString();
	}
	
	public int getId() {
		return (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id");
	}

	
}
