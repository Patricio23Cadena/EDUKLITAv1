package com.controller.totalalumnos.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.daos.personas.ProvinciaDao;
import com.daos.personas.Total_alumnosDao;
import com.entities.personas.Provincia;
import com.entities.personas.Total;


//import org.primefaces.model.charts.pie.PieChartModel;
@Named("consultainvitado")
@SessionScoped
public class Total_alumnosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Total_alumnosDao tolDao;
	
	@EJB
	private ProvinciaDao proDao;
	
	/*
	 *    <h:form>
                    <p:commandButton value="Graficar" id="graficar" actionListener="#{consultainvitado.consulta()}" ></p:commandButton>
                   
                    </h:form>
                    <h:panelGrid id="grafico">
     <p:chart type="pie" model="#{consultainvitado.torta}" style="width: 50%; height: 50%" ></p:chart>
     
     </h:panelGrid>
	 * 
	 * 
	 * 
	 * */
	/* <h:panelGrid id="grafico">
     <p:chart type="pie" model="#{consultainvitado.torta}" style="width: 100%; height: 100%" rendered="#{consultainvitado.torta != null}"></p:chart>
     
     </h:panelGrid>*/
	
	/*@EJB
	private ProvinciaDao provdao = new ProvinciaDao();*/
	private List<Total> listadoTotalAlumnos;
	//private ArrayList<Provincia> provincias;
	private PieChartModel torta;

	
	public List<Total> getConsulta() {
		this.listadoTotalAlumnos = tolDao.iniciarSesion();
		crear();
		return listadoTotalAlumnos;
		
		
	}
	
	private PieChartModel init() {
		PieChartModel tortalol = new PieChartModel();
		for (Total total : listadoTotalAlumnos) {
			System.out.println(total.getProvincia().getProvincia());
			System.out.println(total.getTotal());
			System.out.println("--------------------------");
			tortalol.set(total.getProvincia().getProvincia(),total.getTotal() );
		}
		return tortalol;
	}
	
	private void crear() {
		torta = init(); 
		torta.setLegendPosition("7");
		torta.setShadow(false); 
		torta.setDiameter(500);  
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

	/*public ArrayList<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(ArrayList<Provincia> provincias) {
		this.provincias = provincias;
	}*/

	public PieChartModel getTorta() {
		return torta;
	}

	public void setTorta(PieChartModel torta) {
		this.torta = torta;
	}
	
	
	
	
	
	
}