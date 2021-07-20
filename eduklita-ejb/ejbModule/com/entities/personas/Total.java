package com.entities.personas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name="Total.totalumnos", query = "SELECT t FROM Total t WHERE t.anio = 2017 ")})
@Table(name="totalalumnos",catalog="BD_eduklita",schema="public")
public class Total implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int provincia;
	@Column(name="anio")
	private int anio;
	@ManyToOne
	@JoinColumn(name="provincia", referencedColumnName = "id_provincia",insertable = false,updatable = false)
	private Provincia prov;
	@Column(name="total")
	private double total;
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Provincia getProvincia() {
		return prov;
	}
	public void setProvincia(Provincia prov) {
		this.prov = prov;
	}
	
	public int getId_provincia() {
		return provincia;
	}
	public void setId_provincia(int id_provincia) {
		this.provincia = id_provincia;
	}
	
}
