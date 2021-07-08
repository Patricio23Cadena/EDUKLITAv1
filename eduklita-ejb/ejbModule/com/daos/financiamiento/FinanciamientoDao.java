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

	public ArrayList<Financiamiento> listar() {
		return (ArrayList<Financiamiento>) em.createQuery("SELECT p FROM Financiamiento p").getResultList();
	}
	//Total docentes por provincia, año por parametro
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
