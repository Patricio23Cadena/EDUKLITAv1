package com.daos.personas;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
