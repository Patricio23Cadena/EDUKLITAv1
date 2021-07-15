package com.controllers.auditoria;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import com.daos.auditoria.AuditoriaDao;
import com.entities.auditoria.Auditoria;
import com.entities.personas.Persona;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;

import jdk.jfr.Name;

@Named("audService")
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
	    
	    
	    
	    
	    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
		    Document pdf = (Document) document;
		    ServletContext servletContext = (ServletContext)
		    FacesContext.getCurrentInstance().getExternalContext().getContext();
		    pdf.open();
		    String logo = servletContext.getRealPath("") + File.separator + "images" +
		    	    File.separator + "logo.png";
		        
		    pdf.add(Image.getInstance(logo));
		    pdf.add(new Paragraph ("\n\n")); 
		     
		    pdf.add(new Paragraph("Auditoría\n\n"));	
		    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		    pdf.add(new Paragraph("Fecha y hora de descarga:  "+dtf.format(LocalDateTime.now())));
		    pdf.add(new Paragraph ("\n\n"));
		    
		}
	    
	
}
