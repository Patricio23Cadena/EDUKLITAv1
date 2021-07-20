package com.daos.docentes_provincia;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.docentes_provincia.Docentes_provincia;



@Stateless
public class Docentes_provinciaDao {

	@PersistenceContext
	private EntityManager em;
	public void crear(Docentes_provincia alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public Docentes_provincia actualizar(Docentes_provincia alumnos) {
		return em.merge(alumnos);
	}

	public void borrar(Integer codigo) {
		Docentes_provincia alumnos = em.find(Docentes_provincia.class, codigo);
		em.remove(alumnos);
	}

	public Docentes_provincia buscar(Integer codigo) {
		return em.find(Docentes_provincia.class, codigo);
	}

	public ArrayList<Docentes_provincia> listar() {
		return (ArrayList<Docentes_provincia>) em.createQuery("SELECT p FROM Docentes_provincia p").getResultList();
	}
	
	//Total docentes por provincia, año por parametro
	public List<Docentes_provincia> docentesxaño(int anio){
		List<Docentes_provincia>  total_docentes = null;
		String consulta;
		try {
			consulta = "SELECT p FROM Docentes_provincia p,Provincia t WHERE p.anio = "+ anio+ " AND t.id_provincia = p.provincia_id_provincia";
			Query query = em.createQuery(consulta);
			List<Docentes_provincia> lista = query.getResultList();
			if (!lista.isEmpty()) {
				total_docentes = lista;
			}
		} catch (Exception e) {
			throw e;
		}
		return total_docentes;
	}

}
