package com.controller.financiamiento;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.controller.validacionesprimefaces.Datos;
import com.daos.gastoConsumoNivel.GastoConsumoNivelDao;
import com.daos.tipo.TipoDao;
import com.entities.gastoConsumoNivel.GastoConsumoNivel;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;

@Named("gastonivel")
@SessionScoped
public class gastoNivelBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private TipoDao tpDao;
	@EJB
	private GastoConsumoNivelDao fnDao;
	private List<GastoConsumoNivel> listado;
	private int tipo =1;
	
	private Datos dt = new Datos();
	BarChartModel barmodel ;
	
	public List<GastoConsumoNivel> getConsultaint () {
		listado = new ArrayList<GastoConsumoNivel>();
		if(tipo == 1) {
			listado.add(fnDao.listar2007().get(0));
			listado.add(fnDao.listar2008().get(0));
			listado.add(fnDao.listar2009().get(0));
			listado.add(fnDao.listar2010().get(0));
			listado.add(fnDao.listar2011().get(0));
			listado.add(fnDao.listar2012().get(0));
			listado.add(fnDao.listar2013().get(0));
			listado.add(fnDao.listar2014().get(0));
			listado.add(fnDao.listar2015().get(0));
			listado.add(fnDao.listar2016().get(0));
			listado.add(fnDao.listar2017().get(0));
			
			listado.add(fnDao.listar2007().get(1));
			listado.add(fnDao.listar2008().get(1));
			listado.add(fnDao.listar2009().get(1));
			listado.add(fnDao.listar2010().get(1));
			listado.add(fnDao.listar2011().get(1));
			listado.add(fnDao.listar2012().get(1));
			listado.add(fnDao.listar2013().get(1));
			listado.add(fnDao.listar2014().get(1));
			listado.add(fnDao.listar2015().get(1));
			listado.add(fnDao.listar2016().get(1));
			listado.add(fnDao.listar2017().get(1));
			
			listado.add(fnDao.listar2007().get(2));
			listado.add(fnDao.listar2008().get(2));
			listado.add(fnDao.listar2009().get(2));
			listado.add(fnDao.listar2010().get(2));
			listado.add(fnDao.listar2011().get(2));
			listado.add(fnDao.listar2012().get(2));
			listado.add(fnDao.listar2013().get(2));
			listado.add(fnDao.listar2014().get(2));
			listado.add(fnDao.listar2015().get(2));
			listado.add(fnDao.listar2016().get(2));
			listado.add(fnDao.listar2017().get(2));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("gasto", "Público");

		}
		else {
			listado.add(fnDao.listar2007pr().get(0));
			listado.add(fnDao.listar2008pr().get(0));
			listado.add(fnDao.listar2009pr().get(0));
			listado.add(fnDao.listar2010pr().get(0));
			listado.add(fnDao.listar2011pr().get(0));
			listado.add(fnDao.listar2012pr().get(0));
			listado.add(fnDao.listar2013pr().get(0));
			listado.add(fnDao.listar2014pr().get(0));
			listado.add(fnDao.listar2015pr().get(0));
			listado.add(fnDao.listar2016pr().get(0));
			listado.add(fnDao.listar2017pr().get(0));
			
			listado.add(fnDao.listar2007pr().get(1));
			listado.add(fnDao.listar2008pr().get(1));
			listado.add(fnDao.listar2009pr().get(1));
			listado.add(fnDao.listar2010pr().get(1));
			listado.add(fnDao.listar2011pr().get(1));
			listado.add(fnDao.listar2012pr().get(1));
			listado.add(fnDao.listar2013pr().get(1));
			listado.add(fnDao.listar2014pr().get(1));
			listado.add(fnDao.listar2015pr().get(1));
			listado.add(fnDao.listar2016pr().get(1));
			listado.add(fnDao.listar2017pr().get(1));
			
			listado.add(fnDao.listar2007pr().get(2));
			listado.add(fnDao.listar2008pr().get(2));
			listado.add(fnDao.listar2009pr().get(2));
			listado.add(fnDao.listar2010pr().get(2));
			listado.add(fnDao.listar2011pr().get(2));
			listado.add(fnDao.listar2012pr().get(2));
			listado.add(fnDao.listar2013pr().get(2));
			listado.add(fnDao.listar2014pr().get(2));
			listado.add(fnDao.listar2015pr().get(2));
			listado.add(fnDao.listar2016pr().get(2));
			listado.add(fnDao.listar2017pr().get(2));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("gasto", "Privado");

		}
		crear();
		return listado;
	}
	private BarChartModel init() {
		 BarChartModel model = new BarChartModel();
		 ChartSeries primer = new ChartSeries();
		 ChartSeries segundo = new ChartSeries();
		 ChartSeries tercero = new ChartSeries();
		 primer.setLabel("Primaria");
		 segundo.setLabel("Secundaria");
		 tercero.setLabel("Superior");
		 for (GastoConsumoNivel lista : listado) {
			 if( lista.getId_nivel() == 1) {
				primer.set(lista.getAnio(),lista.getValor_consumo() );
				
			}
			 else if (lista.getId_nivel() == 2) {
				 segundo.set(lista.getAnio(),lista.getValor_consumo());
			 }
			 else if (lista.getId_nivel() == 3) {
				tercero.set(lista.getAnio(),lista.getValor_consumo() );
			 }
			 
		 }
	
		 model.addSeries(primer);
		 model.addSeries(segundo);
		 model.addSeries(tercero);
		 return model;
	}
	
	public void crear() {
		barmodel = init();
		barmodel.setTitle(dt.nivel());
		barmodel.setLegendPosition("nw");
		Axis xAxis = barmodel.getAxis(AxisType.X);
		xAxis.setLabel("Años");
		Axis yAxis = barmodel.getAxis(AxisType.Y);
		yAxis.setLabel("Total");
		yAxis.setMin(0);
		
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
	    pdf.add(new Paragraph(dt.nivel()+"\n\n"));
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
	public GastoConsumoNivelDao getFnDao() {
		return fnDao;
	}
	public void setFnDao(GastoConsumoNivelDao fnDao) {
		this.fnDao = fnDao;
	}
	public List<GastoConsumoNivel> getListado() {
		return listado;
	}
	public void setListado(List<GastoConsumoNivel> listado) {
		this.listado = listado;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Datos getDt() {
		return dt;
	}
	public void setDt(Datos dt) {
		this.dt = dt;
	}
	public BarChartModel getBarmodel() {
		return barmodel;
	}
	public void setBarmodel(BarChartModel barmodel) {
		this.barmodel = barmodel;
	}
	
	
}
