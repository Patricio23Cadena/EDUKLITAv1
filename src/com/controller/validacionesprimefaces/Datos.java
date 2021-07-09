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
	public String anioTotalDocenPean() {
		
		return "Total de docentes por provincia en el año: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("anioTotalDocenPean").toString();
	}
	
     public String finanTotalxanio() {
		
		return "Total de financiamiento por tipo de educación en el año: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("anioFinanciamiento").toString();
	}
     
     public String totallumnosanio() {
 		
 		return "Total de alumnos por provincia en el año: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aniototalalumno").toString();
 	}
     
     public String aniPib() {
  		
  		return "Comparación del PIB público vs privado en el año " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("anioPib").toString();
  	}


	
}
