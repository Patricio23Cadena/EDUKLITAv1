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

	
}
