package com.daos.tipo;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.entities.tipo_educacion.Tipo;

@Stateless
public class TipoDao {
	@PersistenceContext
	private EntityManager em;
	public void crear(Tipo alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public Tipo actualizar(Tipo alumnos) {
		return em.merge(alumnos);
	}

	public void borrar(Integer codigo) {
		Tipo alumnos = em.find(Tipo.class, codigo);
		em.remove(alumnos);
	}

	public Tipo buscar(Integer codigo) {
		return em.find(Tipo.class, codigo);
	}

	public ArrayList<Tipo> listar() {
		return (ArrayList<Tipo>) em.createQuery("SELECT p FROM Tipo p").getResultList();
	}
}
