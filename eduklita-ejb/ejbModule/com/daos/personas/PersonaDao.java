package com.daos.personas;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entities.personas.Persona;


@Stateless
public class PersonaDao {
	@PersistenceContext
	private EntityManager em;
	
	public void crear(Persona persona) {
		em.persist(persona);
		em.refresh(persona);
	}

	public Persona actualizar(Persona persona) {
		return em.merge(persona);
	}

	public void borrar(Integer codigo) {
		Persona persona = em.find(Persona.class, codigo);
		em.remove(persona);
	}

	public Persona buscar(Integer codigo) {
		return em.find(Persona.class, codigo);
	}

	public List<Persona> listar() {
		return em.createQuery("SELECT p FROM Persona p").getResultList();
	}
	
	public Persona iniciarSesion(Persona us) {
		Persona usuario = null;
		String consulta;
		try {
			consulta = "SELECT u FROM Persona u WHERE u.correo = ?1 AND u.clave= ?2 AND u.flag= 0";
			Query query = em.createQuery(consulta);
			query.setParameter(1, us.getCorreo());
			query.setParameter(2, us.getClave());
			List<Persona> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}
	
	public Persona bloqCorreo(Persona us) {
		Persona usuario = null;
		String consulta;
		try {
			consulta = "SELECT u FROM Persona u WHERE u.correo = ?1";
			Query query = em.createQuery(consulta);
			query.setParameter(1, us.getCorreo());
			List<Persona> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}
	
	
	
	
	public Persona login(String us) {
		Persona usuario = null;
		String consulta;
		try {
			consulta = "SELECT u FROM Persona u WHERE u.correo ='"+us+"'";
			Query query = em.createQuery(consulta);
			List<Persona> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista.get(0);
				
				
				
				
				
			}
		} catch (Exception e) {
			throw e;
		}
		return usuario;
		}
	
	public Persona nombres(String us) {
		Persona usuario = null;
		String consulta;
		try {
			consulta = "SELECT u FROM Persona u WHERE u.correo ='"+us+"'";
			Query query = em.createQuery(consulta);
			List<Persona> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return usuario;
		}
}
