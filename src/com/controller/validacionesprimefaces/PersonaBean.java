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
		nuevaPersona.setTipo(1);
		nuevaPersona.setFlag(0);
		pdao.crear(nuevaPersona);
		addMessage(FacesMessage.SEVERITY_INFO, "Registrado correctamente", "HOLA");
		return "admin";
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

	protected boolean cedula(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validacion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
		return cedulaCorrecta;
	}

}
