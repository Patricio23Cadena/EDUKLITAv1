package com.controller.financiamiento;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.charts.ChartData;

import org.primefaces.model.charts.donut.DonutChartDataSet;

import org.primefaces.model.charts.donut.DonutChartOptions;

import org.primefaces.model.charts.optionconfig.title.Title;

import com.controller.validacionesprimefaces.Datos;
import com.daos.financiamiento.FinanciamientoDao;
import com.daos.tipo.TipoDao;

import com.entities.finaciamiento.Financiamiento;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;

@Named("totalfinanciamientoxanio")
@SessionScoped
public class FinanciamientoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int anio=2007;
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	@EJB
	private TipoDao tpDao;
	@EJB
	private FinanciamientoDao fnDao;
	
	private List<Financiamiento> listadoFinanciamientoxanio;
	private Datos dt = new Datos();
	private DonutChartModel donutModel;
	
	public List<Financiamiento> getConsultaint () {
		this.listadoFinanciamientoxanio = fnDao.financimientoxaño(anio);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("anioFinanciamiento", anio);
		crear();
		return listadoFinanciamientoxanio;
		
	}
	private DonutChartModel init() {
		DonutChartModel donutModelaux = new DonutChartModel();
		/*ChartData data = new ChartData();
		DonutChartDataSet dataSet = new DonutChartDataSet();*/
		Map<String,Number> values = new LinkedHashMap<>();
		List<String> labels = new ArrayList<>();
		for (Financiamiento lista : listadoFinanciamientoxanio) {
			System.out.println("----- k "+ lista.getAnio());
			System.out.println("----- k "+ lista.getTotal());
			System.out.println("----- k "+ lista.getTipo().getDescripcion());
			values.put(lista.getTipo().getDescripcion(),lista.getTotal());
			//labels.add();
		}
		donutModelaux.addCircle(values);
		/*List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
        data.addChartDataSet(dataSet);
        data.setLabels(labels);
        donutModelaux.setData(data);*/
		return donutModelaux;
	}
	public void crear() {
        donutModel = init();
        donutModel.setTitle(dt.finanTotalxanio());
        donutModel.setFill(true);
        donutModel.setShowDataLabels(true);
        donutModel.setLegendPosition("e");
        donutModel.setSliceMargin(5);
       // donutModel.setSeriesColors("rgb(51, 181, 255),rgb(255, 247, 72)");
       
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
	    pdf.add(new Paragraph(dt.finanTotalxanio()+"\n\n"));
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    pdf.add(new Paragraph("Fecha y hora de descarga:  "+dtf.format(LocalDateTime.now())));
	    pdf.add(new Paragraph ("\n\n"));
	}
	public TipoDao getTpDao() {
		return tpDao;
	}
	public void setTpDao(TipoDao tpDao) {
		this.tpDao = tpDao;
	}
	public FinanciamientoDao getFnDao() {
		return fnDao;
	}
	public void setFnDao(FinanciamientoDao fnDao) {
		this.fnDao = fnDao;
	}
	public List<Financiamiento> getListadoFinanciamientoxanio() {
		return listadoFinanciamientoxanio;
	}
	public void setListadoFinanciamientoxanio(List<Financiamiento> listadoFinanciamientoxanio) {
		this.listadoFinanciamientoxanio = listadoFinanciamientoxanio;
	}
	public Datos getDt() {
		return dt;
	}
	public void setDt(Datos dt) {
		this.dt = dt;
	}
	public DonutChartModel getDonutModel() {
		return donutModel;
	}
	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}
}
