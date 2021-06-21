package com.controller.validacionesprimefaces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named("userView")
@RequestScoped
public class PersonaBean {
	
	 private String firstname;
	 private String password;
	 private boolean logeado = false;
	 public boolean estaLogeado() {
	 return logeado;}
	 public String getFirstname() {
		 return firstname;
	 }
	 public void setFirstname(String firstname) {
	 this.firstname = firstname;
	 }
	 public String getLastname() {
	 return password;
	 }
	 public void setLastname(String lastname) {
	 this.password = lastname;
	 }
	 
	 public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
	        FacesContext.getCurrentInstance().
	                addMessage(null, new FacesMessage(severity, summary, detail));
	    }

	    public String showInfo() {
	        addMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", firstname);
	        return "bienvenida";
	    }

	    public void showWarn() {
	        addMessage(FacesMessage.SEVERITY_WARN, "Warn Message", "Message Content");
	    }

	    public void showError() {
	        addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales Incorrectas");
	    }
	 
	 
	 
	 public String save() {
	 FacesContext.getCurrentInstance().addMessage(null,
	 new FacesMessage("Welcome " + firstname + " " + password));
	 return "bienvenida";
	 
	 }
	
	public PersonaBean() {
		 firstname="";
		 password="";
	 }
	
}

