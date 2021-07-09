package com.daos.gastoConsumoTipo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.finaciamiento.Financiamiento;
import com.entities_gastoConsumoTipo.GastoTipo;

@Stateless
public class GastoTipoDao {
	@PersistenceContext
	private EntityManager em;
	public void crear(GastoTipo alumnos) {
		em.persist(alumnos);
		em.refresh(alumnos);
	}
	public GastoTipo actualizar(GastoTipo alumnos) {
		return em.merge(alumnos);
	}
	public void borrar(Integer codigo) {
		GastoTipo alumnos = em.find(GastoTipo.class, codigo);
		em.remove(alumnos);
	}
	public GastoTipo buscar(Integer codigo) {
		return em.find(GastoTipo.class, codigo);
	}

	public ArrayList<GastoTipo> listar() {
		return (ArrayList<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p").getResultList();
	}
	
	public List<GastoTipo> listar2007() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2007").getResultList();
	}

	public List<GastoTipo> listar2008() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2008").getResultList();
	}
	
	public List<GastoTipo> listar2009() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2009").getResultList();
	}
	
	public List<GastoTipo> listar2010() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2010").getResultList();
	}
	
	public List<GastoTipo> listar2011() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2011").getResultList();
	}
	
	public List<GastoTipo> listar2012() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2012").getResultList();
	}
	
	public List<GastoTipo> listar2013() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2013").getResultList();
	}
	
	public List<GastoTipo> listar2014() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2014").getResultList();
	}
	
	public List<GastoTipo> listar2015() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2015").getResultList();
	}
	
	public List<GastoTipo> listar2016() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2016").getResultList();
	}
	
	public List<GastoTipo> listar2017() {
		return (List<GastoTipo>) em.createQuery("SELECT p FROM GastoTipo p WHERE p.anio = 2017").getResultList();
	}
	
	// PIB por año comparado entre educación pública y privada
	
	public List<GastoTipo> pibpu(int anio){
		List<GastoTipo> listapib = null;
		String consulta;
		try {
			consulta =" SELECT p FROM GastoTipo p , Tipo t WHERE p.id_tipo = 1 AND p.id_tipo = t.id_tipo AND p.anio = "+ anio;
			Query query = em.createQuery(consulta);
			List<GastoTipo> lista = query.getResultList();
			if (!lista.isEmpty()) {
				listapib = lista;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listapib;
	}
	
	public List<GastoTipo> pibpr(int anio){
		List<GastoTipo> listapib = null;
		String consulta;
		try {
			consulta =" SELECT p FROM GastoTipo p , Tipo t WHERE p.id_tipo = 2 AND p.id_tipo = t.id_tipo AND p.anio = "+ anio;
			Query query = em.createQuery(consulta);
			List<GastoTipo> lista = query.getResultList();
			if (!lista.isEmpty()) {
				listapib = lista;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listapib;
	}
}
