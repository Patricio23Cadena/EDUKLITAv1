package com.controller.bloqueo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.daos.personas.PersonaDao;
import com.entities.personas.Persona;

@Named("productService")
@ApplicationScoped
public class ProductService {

    List<Persona> products;

    @EJB
    private PersonaDao pdap = new PersonaDao();
    @PostConstruct
    public void init() {
        products = pdap.listar();
        

    }

    public List<Persona> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Persona> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Persona> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(products.subList(0, size));
        }

    }

	/*public List<Persona> getClonedProducts(int size) {
		List<Persona> results = new ArrayList<>();
		List<Persona> originals = getProducts(size);
		for (Persona original : originals) {
			results.add(original.clone());
		}
		return results;
	}*/
}
