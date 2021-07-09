/*package com.controllers.personas;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.PrimeFacesContext;

import com.daos.personas.UsuarioDao;
import com.entities.personas.Usuario;

public class LoginController implements Serializable {

private static final long serialVersionUID = 1L;
	private Usuario usuario;
	@EJB
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void init() {
		usuario=new Usuario();
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public String iniciarSesion()
	{
	Usuario us;
	String redireccion=null;
	try
	{
	us=usuarioDao.iniciarSesion(usuario);
	if(us!=null)
	{
	PrimeFacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",
	us);
	redireccion="principal?faces-redirect=true";
	}
	else
	{
	FacesContext.getCurrentInstance().addMessage(null, new
	FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales Incorrectas"));
	}
	}catch(Exception e)
	{
	FacesContext.getCurrentInstance().addMessage(null, new
	FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Error"));
	}
	return redireccion;
	}

	
}
*/