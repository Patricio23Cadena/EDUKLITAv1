package com.entities.nivelesEducacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="niveles_educacion",catalog="Eduklita_Relacional",schema="public")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_nivel")
	private int id_nivel;
	@Column(name="descripcion")
	private String descriocion;
	public int getId_nivel() {
		return id_nivel;
	}
	public void setId_nivel(int id_nivel) {
		this.id_nivel = id_nivel;
	}
	public String getDescriocion() {
		return descriocion;
	}
	public void setDescriocion(String descriocion) {
		this.descriocion = descriocion;
	}
	
}
