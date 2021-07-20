package com.entities.tipo_educacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_educacion",catalog="BD_eduklita",schema="public")
public class Tipo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo")
	private int id_tipo;
	@Column(name="descripcion")
	private String descripcion;
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
