package com.entities.auditoria;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auditoria",catalog="BD_eduklita",schema="auditoria")
public class Auditoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_aud")
	private int id_aud;
	@Column(name="tabla_aud")
	private String tabla_aud;
	@Column(name="operacion_aud")
	private String operacion_aud;
	@Column(name="valoranterior_aud")
	private String valoranterior_aud;
	@Column(name="valornuevo_aud")
	private String valornuevo_aud;
	@Column(name="fecha_aud")
	private Date fecha_aud;
	@Column(name="usuario_aud")
	private String usuario_aud;
	public int getId_aud() {
		return id_aud;
	}
	public void setId_aud(int id_aud) {
		this.id_aud = id_aud;
	}
	public String getTabla_aud() {
		return tabla_aud;
	}
	public void setTabla_aud(String tabla_aud) {
		this.tabla_aud = tabla_aud;
	}
	public String getOperacion_aud() {
		return operacion_aud;
	}
	public void setOperacion_aud(String operacion_aud) {
		this.operacion_aud = operacion_aud;
	}
	public String getValoranterior_aud() {
		return valoranterior_aud;
	}
	public void setValoranterior_aud(String valoranterior_aud) {
		this.valoranterior_aud = valoranterior_aud;
	}
	public String getValornuevo_aud() {
		return valornuevo_aud;
	}
	public void setValornuevo_aud(String valornuevo_aud) {
		this.valornuevo_aud = valornuevo_aud;
	}
	public Date getFecha_aud() {
		return fecha_aud;
	}
	public void setFecha_aud(Date fecha_aud) {
		this.fecha_aud = fecha_aud;
	}
	
	public String getUsuario_aud() {
		return usuario_aud;
	}
	public void setUsuario_aud(String usuario_aud) {
		this.usuario_aud = usuario_aud;
	}
	
	

}
