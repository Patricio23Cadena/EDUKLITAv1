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
import com.daos.errogacion.ErrogacionDao;
import com.daos.tipo.TipoDao;
import com.entities.errogaciones.Errogacion;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;

@Named("errogacions")
@SessionScoped
public class ErrogacionEban implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private TipoDao tpDao;
	@EJB
	private ErrogacionDao fnDao;
	private List<Errogacion> listadoFinanciamientoall;

	private Datos dt = new Datos();
	BarChartModel barmodel ;
	
	public List<Errogacion> getConsultaint () {
		this.listadoFinanciamientoall = new ArrayList<Errogacion>();
		listadoFinanciamientoall.add(fnDao.listar2007().get(0));
		listadoFinanciamientoall.add(fnDao.listar2008().get(0));
		listadoFinanciamientoall.add(fnDao.listar2009().get(0));
		listadoFinanciamientoall.add(fnDao.listar2010().get(0));
		listadoFinanciamientoall.add(fnDao.listar2011().get(0));
		listadoFinanciamientoall.add(fnDao.listar2012().get(0));
		listadoFinanciamientoall.add(fnDao.listar2013().get(0));
		listadoFinanciamientoall.add(fnDao.listar2014().get(0));
		listadoFinanciamientoall.add(fnDao.listar2015().get(0));
		listadoFinanciamientoall.add(fnDao.listar2016().get(0));
		listadoFinanciamientoall.add(fnDao.listar2017().get(0));
		
		listadoFinanciamientoall.add(fnDao.listar2007().get(1));
		listadoFinanciamientoall.add(fnDao.listar2008().get(1));
		listadoFinanciamientoall.add(fnDao.listar2009().get(1));
		listadoFinanciamientoall.add(fnDao.listar2010().get(1));
		listadoFinanciamientoall.add(fnDao.listar2011().get(1));
		listadoFinanciamientoall.add(fnDao.listar2012().get(1));
		listadoFinanciamientoall.add(fnDao.listar2013().get(1));
		listadoFinanciamientoall.add(fnDao.listar2014().get(1));
		listadoFinanciamientoall.add(fnDao.listar2015().get(1));
		listadoFinanciamientoall.add(fnDao.listar2016().get(1));
		listadoFinanciamientoall.add(fnDao.listar2017().get(1));
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("allFinanciamiento", tipo);
		
		crear();
		return listadoFinanciamientoall;
		
	}
	
	private BarChartModel init() {
		 BarChartModel model = new BarChartModel();
		 ChartSeries publica = new ChartSeries();
		 ChartSeries privada = new ChartSeries();
		 publica.setLabel("Pública");
		 privada.setLabel("Privada");
		 for (Errogacion lista : listadoFinanciamientoall) {
			 if(lista.getId_tipo()==1) {
				publica.set(lista.getAnio(), lista.getTotal());
			}else {
				privada.set(lista.getAnio(), lista.getTotal());
			}
		 }
	
		 model.addSeries(publica);
		 model.addSeries(privada);
		 return model;
	}
	
	public void crear() {
		barmodel = init();
		barmodel.setTitle("Erogaciones público vs privado");
		barmodel.setLegendPosition("nw");
		Axis xAxis = barmodel.getAxis(AxisType.X);
		xAxis.setLabel("Años");
		Axis yAxis = barmodel.getAxis(AxisType.Y);
		yAxis.setLabel("Erogaciones");
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
	    pdf.add(new Paragraph("Erogaciones público vs privado\n\n"));
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

	public ErrogacionDao getFnDao() {
		return fnDao;
	}

	public void setFnDao(ErrogacionDao fnDao) {
		this.fnDao = fnDao;
	}

	public List<Errogacion> getListadoFinanciamientoall() {
		return listadoFinanciamientoall;
	}

	public void setListadoFinanciamientoall(List<Errogacion> listadoFinanciamientoall) {
		this.listadoFinanciamientoall = listadoFinanciamientoall;
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
