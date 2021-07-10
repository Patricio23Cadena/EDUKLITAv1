package com.daos.personas;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entities.personas.Persona;
import com.entities.personas.Total;

@Stateless
public class Total_alumnosDao {
	@PersistenceContext
	private EntityManager em;
	public void crear(Total alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public Total actualizar(Total alumnos) {
		return em.merge(alumnos);
	}

	public void borrar(Integer codigo) {
		Total alumnos = em.find(Total.class, codigo);
		em.remove(alumnos);
	}

	public Total buscar(Integer codigo) {
		return em.find(Total.class, codigo);
	}

	public ArrayList<Total> listar() {
		return (ArrayList<Total>) em.createQuery("SELECT p FROM Total p").getResultList();
	}
	
	public ArrayList<Total> listarDos() {
		return (ArrayList<Total>) em.createQuery("SELECT p FROM Total p WHERE p.anio = 2017").getResultList();
	}
	
	public ArrayList<Total> listarlumnosxprovincia2017(){
		TypedQuery<Total> consulta = em.createNamedQuery("Total.totalumnos", 
				Total.class);
				return (ArrayList<Total>) consulta.getResultList();
	}
	
	public List<Total> iniciarSesion() {
		List<Total>  usuario = null;
		String consulta;
		try {
			consulta = "SELECT p FROM Total p,Provincia t WHERE p.anio = 2017 AND t.id_provincia = p.provincia";
			Query query = em.createQuery(consulta);
			List<Total> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista;
			}
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}
	
	
	public List<Total> totalalumons(int anio) {
		List<Total>  usuario = null;
		String consulta;
		try {
			consulta = "SELECT p FROM Total p,Provincia t WHERE p.anio = "+anio+" AND t.id_provincia = p.provincia";
			Query query = em.createQuery(consulta);
			List<Total> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista;
			}
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}
	
}
