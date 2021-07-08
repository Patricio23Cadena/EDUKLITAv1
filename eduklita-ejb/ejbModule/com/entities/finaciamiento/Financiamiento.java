package com.entities.finaciamiento;

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
@Table(name="finaciamiento",catalog="Eduklita_Relacional",schema="public")
public class Financiamiento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo;
	@ManyToOne
	@JoinColumn(name="id_tipo", referencedColumnName="id_tipo", insertable =false,updatable=false)
	private Tipo tipo;
	@Column(name="remuneracion_empleados")
	private double remuneracion_empleados;
	@Column(name="renta_propiedad")
	private double renta_propiedad;
	@Column(name="contribuciones_sociales")
	private double contribuciones_sociales;
	@Column(name="prestaciones_asistencias")
	private double prestaciones_asistencias;
	@Column(name="otras_tranferencias")
	private double otras_tranferencias;
	@Column(name="transferencias_capital")
	private double transferencias_capital;
	@Column(name="produccion_mercado")
	private double produccion_mercado;
	@Column(name="total")
	private double total;
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
	public double getRemuneracion_empleados() {
		return remuneracion_empleados;
	}
	public void setRemuneracion_empleados(double remuneracion_empleados) {
		this.remuneracion_empleados = remuneracion_empleados;
	}
	public double getRenta_propiedad() {
		return renta_propiedad;
	}
	public void setRenta_propiedad(double renta_propiedad) {
		this.renta_propiedad = renta_propiedad;
	}
	public double getContribuciones_sociales() {
		return contribuciones_sociales;
	}
	public void setContribuciones_sociales(double contribuciones_sociales) {
		this.contribuciones_sociales = contribuciones_sociales;
	}
	public double getPrestaciones_asistencias() {
		return prestaciones_asistencias;
	}
	public void setPrestaciones_asistencias(double prestaciones_asistencias) {
		this.prestaciones_asistencias = prestaciones_asistencias;
	}
	public double getOtras_tranferencias() {
		return otras_tranferencias;
	}
	public void setOtras_tranferencias(double otras_tranferencias) {
		this.otras_tranferencias = otras_tranferencias;
	}
	public double getTransferencias_capital() {
		return transferencias_capital;
	}
	public void setTransferencias_capital(double transferencias_capital) {
		this.transferencias_capital = transferencias_capital;
	}
	public double getProduccion_mercado() {
		return produccion_mercado;
	}
	public void setProduccion_mercado(double produccion_mercado) {
		this.produccion_mercado = produccion_mercado;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	
}
