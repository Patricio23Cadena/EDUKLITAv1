package com.entities_gastoConsumoTipo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.entities.tipo_educacion.Tipo;

@Entity
@Table(name="gasto_consumo_tipo",catalog="Eduklita_Relacional",schema="public")
public class GastoTipo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo;
	@ManyToOne
	@JoinColumn(name="id_tipo",referencedColumnName = "id_tipo",insertable = false,updatable = false)
	private Tipo tipo;
	@Column(name="valor")
	private double valor;
	@Column(name="pib")
	private double pib;
	@Column(name="anio")
	private int anio;
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getPib() {
		return pib;
	}
	public void setPib(double pib) {
		this.pib = pib;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	


	

}
