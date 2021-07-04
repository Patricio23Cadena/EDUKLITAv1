package com.controllers.auditoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

import com.daos.auditoria.AuditoriaDao;
import com.entities.auditoria.Auditoria;
import com.entities.personas.Persona;

import jdk.jfr.Name;

@Name("audService")
@ApplicationScoped
public class AudService {
	List<Auditoria> auditorias;
	@EJB
	private AuditoriaDao audDao = new AuditoriaDao();
	 @PostConstruct
	    public void init() {
		 auditorias = audDao.listar();
	    }
	 
	 public List<Auditoria> getProducts() {
	        return new ArrayList<>(auditorias);
	    }

	    public List<Auditoria> getProducts(int size) {

	        if (size > auditorias.size()) {
	            Random rand = new Random();

	            List<Auditoria> randomList = new ArrayList<>();
	            for (int i = 0; i < size; i++) {
	                int randomIndex = rand.nextInt(auditorias.size());
	                randomList.add(auditorias.get(randomIndex));
	            }

	            return randomList;
	        }

	        else {
	            return new ArrayList<>(auditorias.subList(0, size));
	        }

	    }
	
}
