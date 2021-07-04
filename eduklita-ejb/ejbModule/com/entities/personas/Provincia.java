package com.entities.personas;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="provincia",catalog="Eduklita_Relacional",schema="public")
@NamedQueries({ @NamedQuery(name="Provincia.provincia", query = "SELECT t FROM Total t")})
public class Provincia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_provincia")
	private int id_provincia;
	@Column(name="provincia")
	private String provincia;
	@Column(name="capital")
	private String capital;
	public int getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="provincia")
	private List<Total> total;
	public List<Total> getTotal() {
		return total;
	}
	public void setTotal(List<Total> total) {
		this.total = total;
	}
	
}
