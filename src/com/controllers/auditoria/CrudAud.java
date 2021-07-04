package com.controllers.auditoria;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.daos.auditoria.AuditoriaDao;

import com.entities.auditoria.Auditoria;

@Named("crudAud")
@ViewScoped
public class CrudAud implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Auditoria> products;

    private Auditoria selectedProduct;

    private List<Auditoria> selectedProducts;

    @EJB
    private AuditoriaDao pdap = new AuditoriaDao();

    @PostConstruct
    public void init() {
        this.products = pdap.listar();
    }

    public List<Auditoria> getProducts() {
        return products;
    }

    public Auditoria getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Auditoria selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Auditoria> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Auditoria> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void openNew() {
        this.selectedProduct = new Auditoria();
    }

}
