package com.daos.auditoria;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.auditoria.Auditoria;


@Stateless
public class AuditoriaDao {
	@PersistenceContext
	private EntityManager em;
	
	public void crear(Auditoria persona) {
		em.persist(persona);
		em.refresh(persona);
	}

	public Auditoria actualizar(Auditoria persona) {
		return em.merge(persona);
	}

	public void borrar(Integer codigo) {
		Auditoria persona = em.find(Auditoria.class, codigo);
		em.remove(persona);
	}

	public Auditoria buscar(Integer codigo) {
		return em.find(Auditoria.class, codigo);
	}

	public List<Auditoria> listar() {
		return em.createQuery("SELECT p FROM Auditoria p").getResultList();
	}
	public Auditoria buscarCod(Auditoria us) {
		Auditoria usuario = null;
		String consulta;
		try {
			consulta = "SELECT u FROM Auditoria u ";
			Query query = em.createQuery(consulta);
			List<Auditoria> lista = query.getResultList();
			if (!lista.isEmpty()) {
				usuario = lista.get(lista.size());
			}
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}
	
}
