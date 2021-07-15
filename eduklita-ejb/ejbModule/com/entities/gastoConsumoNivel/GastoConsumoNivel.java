package com.entities.gastoConsumoNivel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.entities.nivelesEducacion.Nivel;

@Entity
@Table(name="gasto_consumo_nivel",catalog="Eduklita_Relacional",schema="public")
public class GastoConsumoNivel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_nivel;
	@ManyToOne
	@JoinColumn(name="id_nivel", referencedColumnName="id_nivel", insertable =false,updatable=false)
	private Nivel nivel;
	@Column(name="id_tipo")
	private int id_tipo;
	@Column(name="valor_consumo")
	private double valor_consumo;
	@Column(name="numero_alumnos")
	private long numero_alumnos;
	@Column(name="anio")
	private int anio;
	public int getId_nivel() {
		return id_nivel;
	}
	public void setId_nivel(int id_nivel) {
		this.id_nivel = id_nivel;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public double getValor_consumo() {
		return valor_consumo;
	}
	public void setValor_consumo(double valor_consumo) {
		this.valor_consumo = valor_consumo;
	}
	public long getNumero_alumnos() {
		return numero_alumnos;
	}
	public void setNumero_alumnos(long numero_alumnos) {
		this.numero_alumnos = numero_alumnos;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
}
