package com.daos.gastoConsumoNivel;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entities.finaciamiento.Financiamiento;
import com.entities.gastoConsumoNivel.GastoConsumoNivel;

@Stateless
public class GastoConsumoNivelDao {
	@PersistenceContext
	private EntityManager em;
	public void crear(GastoConsumoNivel alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public GastoConsumoNivel actualizar(GastoConsumoNivel alumnos) {
		return em.merge(alumnos);
	}

	public void borrar(Integer codigo) {
		GastoConsumoNivel alumnos = em.find(GastoConsumoNivel.class, codigo);
		em.remove(alumnos);
	}

	public GastoConsumoNivel buscar(Integer codigo) {
		return em.find(GastoConsumoNivel.class, codigo);
	}
	public List<GastoConsumoNivel> listar2007() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2007 AND p.id_tipo = 1").getResultList();
	}

	public List<GastoConsumoNivel> listar2008() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2008 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2009() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2009 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2010() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2010 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2011() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2011 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2012() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2012 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2013() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2013 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2014() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2014 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2015() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2015 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2016() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2016 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2017() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2017 AND p.id_tipo = 1").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2007pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2007 AND p.id_tipo = 2").getResultList();
	}

	public List<GastoConsumoNivel> listar2008pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2008 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2009pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2009 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2010pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2010 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2011pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2011 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2012pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2012 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2013pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2013 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2014pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2014 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2015pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2015 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2016pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2016 AND p.id_tipo = 2").getResultList();
	}
	
	public List<GastoConsumoNivel> listar2017pr() {
		return (List<GastoConsumoNivel>) em.createQuery("SELECT p FROM GastoConsumoNivel p WHERE p.anio = 2017 AND p.id_tipo = 2").getResultList();
	}
	
	
	
	
	
}
