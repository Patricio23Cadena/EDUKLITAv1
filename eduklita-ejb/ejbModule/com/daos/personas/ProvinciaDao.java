package com.daos.personas;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entities.personas.Provincia;

@Stateless
public class ProvinciaDao {
	@PersistenceContext
	private EntityManager em;
	public void crear(Provincia provincia) {
		em.persist(provincia);
		em.refresh(provincia);
	}

	public Provincia actualizar(Provincia provincia) {
		return em.merge(provincia);
	}

	public void borrar(Integer codigo) {
		Provincia provincia = em.find(Provincia.class, codigo);
		em.remove(provincia);
	}

	public Provincia buscar(Integer codigo) {
		return em.find(Provincia.class, codigo);
	}

	public ArrayList<Provincia> listar() {
		return (ArrayList<Provincia>) em.createQuery("SELECT p FROM Provincia p").getResultList();
	}
}
