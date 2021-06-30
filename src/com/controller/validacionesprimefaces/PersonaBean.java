package com.controller.validacionesprimefaces;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.daos.personas.PersonaDao;
import com.entities.personas.Persona;

@Named("userView")
@RequestScoped
public class PersonaBean {
	private Persona p;
	@EJB
	private PersonaDao pdao;

	private long cdi;
	private String nombres;
	private String apellidos;
	private int edad;
	private String correo;
	private int tipo;
	private int flag;
	private String clave;
	
	public Persona getP() {
		return p;
	}

	public void setP(Persona p) {
		this.p = p;
	}

	public PersonaDao getPdao() {
		return pdao;
	}

	public void setPdao(PersonaDao pdao) {
		this.pdao = pdao;
	}

	public long getCdi() {
		return cdi;
	}

	public void setCdi(long cdi) {
		this.cdi = cdi;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public String showInfo() {
		p = new Persona();
		p.setNombres(nombres);
		p.setApellidos(apellidos);
		p.setCdi(cdi);
		p.setClave(clave);
		p.setCorreo(correo);
		String cor = p.getCorreo();
		p.setEdad(edad);
		p.setTipo(tipo);
		p.setFlag(flag);
		if (pdao.iniciarSesion(p) != null) {
			addMessage(FacesMessage.SEVERITY_INFO, "WELCOME", pdao.login(cor).getApellidos()+" "+ pdao.login(cor).getNombres());
			return "bienvenida";
		}
		else {
			showError();
			return "";
		}
		
	}

	public void showWarn() {
		addMessage(FacesMessage.SEVERITY_WARN, "Warn Message", "Message Content");
	}

	public void showError() {
		addMessage(FacesMessage.SEVERITY_ERROR, "WARNING", "Credenciales Incorrectas");
	}

	public String save() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome " + nombres + " " + apellidos));
		return "bienvenida";

	}

	public PersonaBean() {
		
		

	}

}
