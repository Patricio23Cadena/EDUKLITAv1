package com.daos.financiamiento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.finaciamiento.Financiamiento;

@Stateless
public class FinanciamientoDao {
	@PersistenceContext
	private EntityManager em;
	public void crear(Financiamiento alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public Financiamiento actualizar(Financiamiento alumnos) {
		return em.merge(alumnos);
	}

	public void borrar(Integer codigo) {
		Financiamiento alumnos = em.find(Financiamiento.class, codigo);
		em.remove(alumnos);
	}

	public Financiamiento buscar(Integer codigo) {
		return em.find(Financiamiento.class, codigo);
	}

	public List<Financiamiento> listar2007() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2007").getResultList();
	}

	public List<Financiamiento> listar2008() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2008").getResultList();
	}
	
	public List<Financiamiento> listar2009() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2009").getResultList();
	}
	
	public List<Financiamiento> listar2010() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2010").getResultList();
	}
	
	public List<Financiamiento> listar2011() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2011").getResultList();
	}
	
	public List<Financiamiento> listar2012() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2012").getResultList();
	}
	
	public List<Financiamiento> listar2013() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2013").getResultList();
	}
	
	public List<Financiamiento> listar2014() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2014").getResultList();
	}
	
	public List<Financiamiento> listar2015() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2015").getResultList();
	}
	
	public List<Financiamiento> listar2016() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2016").getResultList();
	}
	
	public List<Financiamiento> listar2017() {
		return (List<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p WHERE p.anio = 2017").getResultList();
	}
	
	
	
	public ArrayList<Financiamiento> listarvs() {
		return (ArrayList<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p,Tipo t WHERE t.id_tipo = p.id_tipo").getResultList();
	}
	//Total de financiamiento, año por parametro
	public List<Financiamiento> financimientoxaño(int anio){
		List<Financiamiento>  total_docentes = null;
		String consulta;
		try {
			consulta = "SELECT p FROM Financiamiento p,Tipo t WHERE p.anio = "+ anio+ " AND t.id_tipo = p.id_tipo";
			Query query = em.createQuery(consulta);
			List<Financiamiento> lista = query.getResultList();
			if (!lista.isEmpty()) {
				total_docentes = lista;
			}
		} catch (Exception e) {
			throw e;
		}
		return total_docentes;
	}
	

	
}
