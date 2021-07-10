package com.daos.nivelesEducacion;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entities.nivelesEducacion.Nivel;


@Stateless
public class NivelDao {
	
	@PersistenceContext
	private EntityManager em;
	public void crear(Nivel alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public Nivel actualizar(Nivel alumnos) {
		return em.merge(alumnos);
	}

	public void borrar(Nivel codigo) {
		Nivel alumnos = em.find(Nivel.class, codigo);
		em.remove(alumnos);
	}

	public Nivel buscar(Integer codigo) {
		return em.find(Nivel.class, codigo);
	}

	public ArrayList<Nivel> listar() {
		return (ArrayList<Nivel>) em.createQuery("SELECT p FROM Nivel p").getResultList();
	}
}
