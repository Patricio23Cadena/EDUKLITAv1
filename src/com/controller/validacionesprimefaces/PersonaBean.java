package com.controller.validacionesprimefaces;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.PrimeRequestContext;

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

		p.setApellidos(apellidos);
		p.setCdi(cdi);
		p.setClave(clave);
		p.setCorreo(correo);
		String cor = p.getCorreo();
		setNombres(pdao.login(cor).getNombres());
		setTipo(pdao.login(cor).getTipo());
		p.setEdad(edad);
		p.setTipo(tipo);
		p.setFlag(flag);
		if (pdao.iniciarSesion(p) != null) {
			addMessage(FacesMessage.SEVERITY_INFO, "WELCOME",
					pdao.login(cor).getApellidos() + " " + pdao.login(cor).getNombres());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", nombres);
			FacesContext contextaux = FacesContext.getCurrentInstance();
			contextaux.getExternalContext().getFlash().setKeepMessages(true);
			contextaux.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "!!Bienbenido!!", nombres));

			if (tipo == 1) {
				return "admin";
			} else {
				return "user";
			}

		} else {
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

	public void save() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome " + nombres + " " + apellidos));

	}

	public String registrar() {
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombres(nombres);
		nuevaPersona.setApellidos(apellidos);
		nuevaPersona.setCdi(cdi);
		nuevaPersona.setEdad(edad);
		nuevaPersona.setCorreo(correo);
		nuevaPersona.setClave(clave);
		nuevaPersona.setTipo(tipo);
		nuevaPersona.setFlag(0);
		Long var1 = nuevaPersona.getCdi();
		String var =  var1.toString();
		if (pdao.bloqCorreo(nuevaPersona) == null) {
			if (cedula(var)) {
				pdao.crear(nuevaPersona);
				addMessage(FacesMessage.SEVERITY_INFO, "Registrado correctamente", "");
				return "admin";
			} else {
				addMessage(FacesMessage.SEVERITY_ERROR, "Error al registrarse", "");
				return "register";
			}
		} else {
			addMessage(FacesMessage.SEVERITY_ERROR, "Este correo ya esta registrado", "");
			return "register";

		}

	}

	public PersonaBean() {
		nombres = "";
		apellidos = "";
		correo = "";
		clave = "";
		cdi = 0;

		edad = 0;

		tipo = 0;
		flag = 0;

	}

	protected boolean cedula(String x) {
		int suma = 0;
		if (x.length() == 9) {
			System.out.println("Ingrese su cedula de 10 digitos");
			return false;
		} else {
			int a[] = new int[x.length() / 2];
			int b[] = new int[(x.length() / 2)];
			int c = 0;
			int d = 1;
			for (int i = 0; i < x.length() / 2; i++) {
				a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
				c = c + 2;
				if (i < (x.length() / 2) - 1) {
					b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
					d = d + 2;
				}
			}

			for (int i = 0; i < a.length; i++) {
				a[i] = a[i] * 2;
				if (a[i] > 9) {
					a[i] = a[i] - 9;
				}
				suma = suma + a[i] + b[i];
			}
			int aux = suma / 10;
			int dec = (aux + 1) * 10;
			if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1))))
				return true;
			else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
				return true;
			} else {
				return false;
			}

		}
	}

}
