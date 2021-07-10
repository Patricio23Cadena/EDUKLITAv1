package com.entities.errogaciones;

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
@Table(name="errogaciones",catalog="Eduklita_Relacional",schema="public")
public class Errogacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo;
	@ManyToOne
	@JoinColumn(name="id_tipo", referencedColumnName="id_tipo", insertable =false,updatable=false)
	private Tipo tipo;
	
	@Column(name="remuneracion_empleados")
	private double remuneracion_empleados;
	@Column(name="otros_impuestos")
	private double otros_impuestos;
	@Column(name="renta")
	private double renta;
	@Column(name="impuestos_corrientes")
	private double impuestos_corrientes;
	@Column(name="contribuciones_sociales")
	private double contribuciones_sociales;
	@Column(name="prestaciones_asistencias")
	private double prestaciones_asistencias;
	@Column(name="otras_transferencias")
	private double otras_transferencias;
	@Column(name="transferencia_capital")
	private double trasnferencia_capital;
	@Column(name="adquisicion_activos")
	private double adquisicion_activos;
	@Column(name="consumo_intermedio")
	private double consumo_intermedio;
	@Column(name="gastos_hogares")
	private double gastos_hogares;
	@Column(name="formacion_capital")
	private double formacion_capital;
	@Column(name="variaciones_existencias")
	private double variaciones_existencias;
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
	public double getOtros_impuestos() {
		return otros_impuestos;
	}
	public void setOtros_impuestos(double otros_impuestos) {
		this.otros_impuestos = otros_impuestos;
	}
	public double getRenta() {
		return renta;
	}
	public void setRenta(double renta) {
		this.renta = renta;
	}
	public double getImpuestos_corrientes() {
		return impuestos_corrientes;
	}
	public void setImpuestos_corrientes(double impuestos_corrientes) {
		this.impuestos_corrientes = impuestos_corrientes;
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
	public double getOtras_transferencias() {
		return otras_transferencias;
	}
	public void setOtras_transferencias(double otras_transferencias) {
		this.otras_transferencias = otras_transferencias;
	}
	public double getTrasnferencia_capital() {
		return trasnferencia_capital;
	}
	public void setTrasnferencia_capital(double trasnferencia_capital) {
		this.trasnferencia_capital = trasnferencia_capital;
	}
	public double getAdquisicion_activos() {
		return adquisicion_activos;
	}
	public void setAdquisicion_activos(double adquisicion_activos) {
		this.adquisicion_activos = adquisicion_activos;
	}
	public double getConsumo_intermedio() {
		return consumo_intermedio;
	}
	public void setConsumo_intermedio(double consumo_intermedio) {
		this.consumo_intermedio = consumo_intermedio;
	}
	public double getGastos_hogares() {
		return gastos_hogares;
	}
	public void setGastos_hogares(double gastos_hogares) {
		this.gastos_hogares = gastos_hogares;
	}
	public double getFormacion_capital() {
		return formacion_capital;
	}
	public void setFormacion_capital(double formacion_capital) {
		this.formacion_capital = formacion_capital;
	}
	public double getVariaciones_existencias() {
		return variaciones_existencias;
	}
	public void setVariaciones_existencias(double variaciones_existencias) {
		this.variaciones_existencias = variaciones_existencias;
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
