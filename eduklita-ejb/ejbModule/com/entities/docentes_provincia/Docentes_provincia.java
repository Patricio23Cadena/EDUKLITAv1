package com.entities.docentes_provincia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.entities.personas.Provincia;

@Entity
@Table(name="docentes_provincia",catalog="Eduklita_Relacional",schema="public")
public class Docentes_provincia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int provincia_id_provincia;
	@ManyToOne
	@JoinColumn(name="provincia_id_provincia", referencedColumnName = "id_provincia",insertable = false,updatable = false)
	private Provincia prov;
	@Column(name="anio")
	private int anio;
	@Column(name="total")
	private double total;
	public int getProvincia() {
		return provincia_id_provincia;
	}
	public void setProvincia(int provincia) {
		this.provincia_id_provincia = provincia;
	}
	public Provincia getProv() {
		return prov;
	}
	public void setProv(Provincia prov) {
		this.prov = prov;
	}
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
	
	
}
