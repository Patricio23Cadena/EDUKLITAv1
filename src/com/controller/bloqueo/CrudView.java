package com.controller.bloqueo;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.controller.validacionesprimefaces.Datos;
import com.daos.auditoria.AuditoriaDao;
import com.daos.personas.PersonaDao;
import com.entities.auditoria.Auditoria;
import com.entities.personas.Persona;

@Named("crudView")
@ViewScoped
public class CrudView implements Serializable {

    /**
	 * 
	 *
	 **/
	private static final long serialVersionUID = 1L;

	private List<Persona> products;
	private Auditoria auditoria;
    private Persona selectedProduct;
    private Datos dt = new Datos();

    private List<Persona> selectedProducts;

    @EJB
    private PersonaDao pdap = new PersonaDao();
    
    @EJB
    private AuditoriaDao audo = new AuditoriaDao();
    

    @PostConstruct
    public void init() {
        this.products = pdap.listar();
    }

    public List<Persona> getProducts() {
        return products;
    }

    public Persona getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Persona selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Persona> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Persona> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void openNew() {
        this.selectedProduct = new Persona();
    }

    public void saveProduct() {
    	 
    	    	Persona p = pdap.buscarCod(selectedProduct);
    	    	p.setFlag(0);
    	    	pdap.actualizar(p);
    	    	
    	    	auditoria = audo.buscarCod();
    	    	auditoria.setUsuario_aud(dt.get()+" "+dt.getA());
    	    	audo.actualizar(auditoria);
    	        /*this.products.remove(this.selectedProduct);*/
    	    	init();
    	        this.selectedProduct = null;
    	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Desbloqueado"));
    	        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    	    
    }

    public void deleteProduct() {
    	Persona p = pdap.buscarCod(selectedProduct);
    	p.setFlag(1);
    	pdap.actualizar(p);
    	auditoria = audo.buscarCod();
    	auditoria.setUsuario_aud(dt.get()+" "+dt.getA());
    	audo.actualizar(auditoria);
        /*this.products.remove(this.selectedProduct);*/
    	init();
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Bloqueado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedProducts.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }

    public boolean hasSelectedProducts() {
        return this.selectedProducts != null && !this.selectedProducts.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.products.removeAll(this.selectedProducts);
        this.selectedProducts = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuarios bloqueados"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}