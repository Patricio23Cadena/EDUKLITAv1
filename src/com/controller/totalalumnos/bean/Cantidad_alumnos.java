package com.controller.totalalumnos.bean;

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

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.optionconfig.title.Title;

import com.controller.validacionesprimefaces.Datos;
import com.daos.personas.ProvinciaDao;
import com.daos.personas.Total_alumnosDao;
import com.entities.docentes_provincia.Docentes_provincia;
import com.entities.personas.Total;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;

@Named("consultatotalalumnos")
@SessionScoped
public class Cantidad_alumnos implements Serializable {
private static final long serialVersionUID = 1L;
	
	@EJB
	private Total_alumnosDao tolDao;
	
	@EJB
	private ProvinciaDao proDao;
	private List<Total> listadoTotalAlumnos;
	
	private int anio=2009;
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	private HorizontalBarChartModel barModel;
	private Datos dt = new Datos();
	
	public List<Total> getConsulta() {
		this.listadoTotalAlumnos = tolDao.totalalumons(anio);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aniototalalumno", anio);
		crear();
		return listadoTotalAlumnos;
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
	     
	    pdf.add(new Paragraph(dt.totallumnosanio()+"\n\n"));	
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    pdf.add(new Paragraph("Fecha y hora de descarga:  "+dtf.format(LocalDateTime.now())));
	    pdf.add(new Paragraph ("\n\n"));
	    
	}
	
	private HorizontalBarChartModel init() {
		HorizontalBarChartModel barModel2 = new HorizontalBarChartModel();
		 HorizontalBarChartDataSet barralol = new  HorizontalBarChartDataSet();
		 List <Number>  aux=  new ArrayList<Number>();
		 List <String>  auxLabel=  new ArrayList<String>();
		 ChartData data = new ChartData();
		for (Total total : listadoTotalAlumnos) {
			
				aux.add(total.getTotal());
				auxLabel.add(total.getProvincia().getProvincia());
			}
		barralol.setData(aux);
		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgb(165, 42, 42)");
        bgColor.add("rgb(127, 255, 0)");
        bgColor.add("rgb(139, 0, 139)");
        bgColor.add("rgb(255, 140, 0)");
        bgColor.add("rgb(233, 150, 122)");
        bgColor.add("rgb(255, 20, 147)");
        bgColor.add("rgb(143, 188, 143)");
        
        bgColor.add("rgb(255, 0, 255)");
        bgColor.add("rgb(255, 215, 0)");
        bgColor.add("rgb(240, 230, 140)");
        bgColor.add("rgb(255, 160, 122)");
        bgColor.add("rgb(144, 238, 144)");
        bgColor.add("rgb(255, 182, 193)");
        bgColor.add("rgb(255, 160, 122)");
        
        bgColor.add("rgb(32, 178, 170)");
        bgColor.add("rgb(199, 21, 133");
        bgColor.add("rgb(128, 128, 0)");
        bgColor.add("rgb(255, 69, 0)");
        bgColor.add("rgb(221, 160, 221)");
        bgColor.add("rgb(160, 82, 45)");
        
        bgColor.add("rgb(70, 130, 180");
        bgColor.add("rgb(154, 205, 50)");
        bgColor.add("rgb(128, 0, 128)");
        bgColor.add("rgb(255, 99, 71)");
        
        barralol.setBackgroundColor(bgColor);
        
        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(165, 42, 42)");
        borderColor.add("rgb(127, 255, 0)");
        borderColor.add("rgb(139, 0, 139)");
        borderColor.add("rgb(255, 140, 0)");
        borderColor.add("rgb(233, 150, 122)");
        borderColor.add("rgb(255, 20, 147)");
        borderColor.add("rgb(143, 188, 143)");
        
        borderColor.add("rgb(255, 0, 255)");
        borderColor.add("rgb(255, 215, 0)");
        borderColor.add("rgb(240, 230, 140)");
        borderColor.add("rgb(255, 160, 122)");
        borderColor.add("rgb(144, 238, 144)");
        borderColor.add("rgb(255, 182, 193)");
        borderColor.add("rgb(255, 160, 122)");
        
        borderColor.add("rgb(32, 178, 170)");
        borderColor.add("rgb(199, 21, 133");
        borderColor.add("rgb(128, 128, 0)");
        borderColor.add("rgb(255, 69, 0)");
        borderColor.add("rgb(221, 160, 221)");
        borderColor.add("rgb(160, 82, 45)");
        
        borderColor.add("rgb(70, 130, 180");
        borderColor.add("rgb(154, 205, 50)");
        borderColor.add("rgb(128, 0, 128)");
        borderColor.add("rgb(255, 99, 71)");
        
        barralol.setBorderColor(borderColor);
        barralol.setBorderWidth(1);
        
        barralol.setLabel(dt.totallumnosanio());
        
		data.setLabels(auxLabel);
		data.addChartDataSet(barralol);
		barModel2.setData(data);
		return barModel2;
	}
	public void crear() {
		BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		barModel = init();
		
		linearAxes.setOffset(true);
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addXAxesData(linearAxes);
		options.setScales(cScales);
		Title title = new Title();
		title.setDisplay(true);
		title.setText(dt.totallumnosanio());
		options.setTitle(title);
		barModel.setOptions(options);	
	}
	public Total_alumnosDao getTolDao() {
		return tolDao;
	}
	public void setTolDao(Total_alumnosDao tolDao) {
		this.tolDao = tolDao;
	}
	public ProvinciaDao getProDao() {
		return proDao;
	}
	public void setProDao(ProvinciaDao proDao) {
		this.proDao = proDao;
	}
	public List<Total> getListadoTotalAlumnos() {
		return listadoTotalAlumnos;
	}
	public void setListadoTotalAlumnos(List<Total> listadoTotalAlumnos) {
		this.listadoTotalAlumnos = listadoTotalAlumnos;
	}
	public HorizontalBarChartModel getBarModel() {
		return barModel;
	}
	public void setBarModel(HorizontalBarChartModel barModel) {
		this.barModel = barModel;
	}
	public Datos getDt() {
		return dt;
	}
	public void setDt(Datos dt) {
		this.dt = dt;
	}
}
