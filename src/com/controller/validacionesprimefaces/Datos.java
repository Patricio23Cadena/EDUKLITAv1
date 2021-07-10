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
		
		return "Total de docentes por provincia en el a�o: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("anioTotalDocenPean").toString();
	}
	
     public String finanTotalxanio() {
		
		return "Total de financiamiento por tipo de educaci�n en el a�o: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("anioFinanciamiento").toString();
	}
     
     public String totallumnosanio() {
 		
 		return "Total de alumnos por provincia en el a�o: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aniototalalumno").toString();
 	}
     
     public String aniPib() {
  		
  		return "Comparaci�n del PIB p�blico vs privado en el a�o " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("anioPib").toString();
  	}
     public String nivel() {
   		
   		return "Total de consumo por nivel de estudio en el sector " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("gasto").toString();
   	}
     public String produccion() {
    		
    		return "Comparaci�n de la producci�n del sector p�blico vs privado en el a�o:  " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("produccion").toString();
    	}
     
     public String contribucion() {
 		
 		return "Comparaci�n de la contribuci�n del sector p�blico vs privado en el a�o:  " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("contribucion").toString();
 	}
     public String renta() {
  		
  		return "Comparaci�n de la renta del sector p�blico vs privado en el a�o:  " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("renta").toString();
  	}
	
}
