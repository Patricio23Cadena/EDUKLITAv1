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
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import com.controller.validacionesprimefaces.Datos;
import com.daos.gastoConsumoTipo.GastoTipoDao;
import com.daos.tipo.TipoDao;
import com.entities_gastoConsumoTipo.GastoTipo;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;

@Named("pib")
@SessionScoped
public class PibBean implements Serializable{

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
	private GastoTipoDao gtiDao;
	
	public TipoDao getTpDao() {
		return tpDao;
	}
	public void setTpDao(TipoDao tpDao) {
		this.tpDao = tpDao;
	}
	public GastoTipoDao getGtiDao() {
		return gtiDao;
	}
	public void setGtiDao(GastoTipoDao gtiDao) {
		this.gtiDao = gtiDao;
	}
	public List<GastoTipo> getListadopibge() {
		return listadopibge;
	}
	public void setListadopibge(List<GastoTipo> listadopibge) {
		this.listadopibge = listadopibge;
	}
	public Datos getDt() {
		return dt;
	}
	public void setDt(Datos dt) {
		this.dt = dt;
	}
	public LineChartModel getLineModel() {
		return lineModel;
	}
	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}
	

	private List<GastoTipo> listadopibge;
	
	private Datos dt = new Datos();
	 private LineChartModel lineModel;
	

	public List<GastoTipo> getConsultaint () {
		/*List<GastoTipo> listadopib = gtiDao.pibpu(anio);
		List<GastoTipo> listadopibpr = gtiDao.pibpr(anio);*/
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("anioPib", anio);
		/*for (GastoTipo gastoTipo : listadopib) {
			listadopibge.add(gastoTipo);
		}
		for (GastoTipo gastoTipo : listadopibpr) {
			listadopibge.add(gastoTipo);
		}
		*/
		listadopibge = new ArrayList<GastoTipo>();
		listadopibge.add(gtiDao.listar2007().get(0));
		listadopibge.add(gtiDao.listar2008().get(0));
		listadopibge.add(gtiDao.listar2009().get(0));
		listadopibge.add(gtiDao.listar2010().get(0));
		listadopibge.add(gtiDao.listar2011().get(0));
		listadopibge.add(gtiDao.listar2012().get(0));
		listadopibge.add(gtiDao.listar2013().get(0));
		listadopibge.add(gtiDao.listar2014().get(0));
		listadopibge.add(gtiDao.listar2015().get(0));
		listadopibge.add(gtiDao.listar2016().get(0));
		listadopibge.add(gtiDao.listar2017().get(0));
		
		listadopibge.add(gtiDao.listar2007().get(1));
		listadopibge.add(gtiDao.listar2008().get(1));
		listadopibge.add(gtiDao.listar2009().get(1));
		listadopibge.add(gtiDao.listar2010().get(1));
		listadopibge.add(gtiDao.listar2011().get(1));
		listadopibge.add(gtiDao.listar2012().get(1));
		listadopibge.add(gtiDao.listar2013().get(1));
		listadopibge.add(gtiDao.listar2014().get(1));
		listadopibge.add(gtiDao.listar2015().get(1));
		listadopibge.add(gtiDao.listar2016().get(1));
		listadopibge.add(gtiDao.listar2017().get(1));
		crear();
		
		return listadopibge;
	}
	
	private LineChartModel  init() {
		LineChartModel model = new LineChartModel();
        ChartSeries publico = new ChartSeries();
        ChartSeries privado = new ChartSeries();
        publico.setLabel("Público");
        privado.setLabel("Privado");
        for (GastoTipo gastoTipo : listadopibge) {
        	if(gastoTipo.getId_tipo()==1) {
			publico.set(gastoTipo.getAnio(), gastoTipo.getValor());
        	}
        	else {
        		System.out.println(gastoTipo.getAnio()+" "+ gastoTipo.getValor());
        	privado.set(gastoTipo.getAnio(), gastoTipo.getValor());
        	}
		}
       model.addSeries(publico);
       model.addSeries(privado);
       return model;
     
	}
	
	public void crear() {
		this.lineModel = init();
		lineModel.setTitle("Comparación del valor total con el PIB público vs privado ");
		lineModel.setLegendPosition("e");
		lineModel.setShowPointLabels(true);
		lineModel.getAxes().put(AxisType.X, new CategoryAxis("Años"));
		Axis yAxis = lineModel.getAxis(AxisType.Y);
	    yAxis = lineModel.getAxis(AxisType.Y);
	    yAxis.setLabel("Dólares");
	    yAxis.setMin(0);
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
	    pdf.add(new Paragraph("Comparación del valor total con el PIB público vs privado" +"\n\n"));
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    pdf.add(new Paragraph("Fecha y hora de descarga:  "+dtf.format(LocalDateTime.now())));
	    pdf.add(new Paragraph ("\n\n"));
	}
}
