package com.controller.docentes_provincia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.optionconfig.title.Title;

import com.daos.docentes_provincia.Docentes_provinciaDao;
import com.daos.personas.ProvinciaDao;
import com.entities.docentes_provincia.Docentes_provincia;
@Named("totaldocentesxanio")
@SessionScoped
public class TotalDocentesProvinciaBean implements Serializable{
	
	
	
	private int anio=2009;
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	private static final long serialVersionUID = 1L;
	@EJB
	private ProvinciaDao proDao;
	@EJB
	private Docentes_provinciaDao donproDao;
	private List<Docentes_provincia> listadoDocentesxanio;
	
	private HorizontalBarChartModel barModel;
	
	
	public List<Docentes_provincia> getConsultaint () {
		this.listadoDocentesxanio = donproDao.docentesxaño(anio);
		crear();
		return listadoDocentesxanio;
		
	}

	private HorizontalBarChartModel init() {
		HorizontalBarChartModel barModel2 = new HorizontalBarChartModel();
		 HorizontalBarChartDataSet barralol = new  HorizontalBarChartDataSet();
		 List <Number>  aux=  new ArrayList<Number>();
		 List <String>  auxLabel=  new ArrayList<String>();
		 ChartData data = new ChartData();
		for (Docentes_provincia total : listadoDocentesxanio) {
			
				aux.add(total.getTotal());
				auxLabel.add(total.getProv().getProvincia());
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
        bgColor.add("rgb(245, 222, 179)");
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
        borderColor.add("rgb(245, 222, 179)");
        borderColor.add("rgb(255, 99, 71)");
        
        barralol.setBorderColor(borderColor);
        barralol.setBorderWidth(1);
        
        barralol.setLabel("Total de docentes por provincia");
        
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
		title.setText("Total de docentes por provincia");
		options.setTitle(title);
		barModel.setOptions(options);	
	}
	public List<Docentes_provincia> getListadoDocentesxanio() {
		return listadoDocentesxanio;
	}
	public void setListadoDocentesxanio(List<Docentes_provincia> listadoDocentesxanio) {
		this.listadoDocentesxanio = listadoDocentesxanio;
	}
	public HorizontalBarChartModel getBarModel() {
		return barModel;
	}
	public void setBarModel(HorizontalBarChartModel barModel) {
		this.barModel = barModel;
	}
	
}
