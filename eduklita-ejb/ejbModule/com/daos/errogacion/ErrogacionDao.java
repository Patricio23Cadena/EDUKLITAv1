package com.daos.errogacion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entities.errogaciones.Errogacion;


@Stateless
public class ErrogacionDao {
	@PersistenceContext
	private EntityManager em;
	public void crear(Errogacion alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public Errogacion actualizar(Errogacion alumnos) {
		return em.merge(alumnos);
	}

	public void borrar(Integer codigo) {
		Errogacion alumnos = em.find(Errogacion.class, codigo);
		em.remove(alumnos);
	}

	public Errogacion buscar(Integer codigo) {
		return em.find(Errogacion.class, codigo);
	}

	public List<Errogacion> listar2007() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2007").getResultList();
	}

	public List<Errogacion> listar2008() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2008").getResultList();
	}
	
	public List<Errogacion> listar2009() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2009").getResultList();
	}
	
	public List<Errogacion> listar2010() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2010").getResultList();
	}
	
	public List<Errogacion> listar2011() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2011").getResultList();
	}
	
	public List<Errogacion> listar2012() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2012").getResultList();
	}
	
	public List<Errogacion> listar2013() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2013").getResultList();
	}
	
	public List<Errogacion> listar2014() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2014").getResultList();
	}
	
	public List<Errogacion> listar2015() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2015").getResultList();
	}
	
	public List<Errogacion> listar2016() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2016").getResultList();
	}
	
	public List<Errogacion> listar2017() {
		return (List<Errogacion>) em.createQuery("SELECT p FROM Errogacion p WHERE p.anio = 2017").getResultList();
	}
}
