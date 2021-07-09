/*package com.controllers.personas;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.daos.personas.MenuDao;
import com.entities.personas.Menu;
import com.entities.personas.Usuario;

@Named("model")
public class menuController {

	
	@EJB
	private MenuDao menu;
	private List<Menu> lista;
	private MenuModel model;
	@PostConstruct
	public void init()
	{
	this.listarMenus();
	model=new DefaultMenuModel();
	this.establecerPermisos();
	}
	public void listarMenus()
	{
	try
	{
	lista=menu.listar();
	}
	catch(Exception e)
	{
	}
	}
	
	
	
	public void establecerPermisos()
	{
	Usuario us=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
	for(Menu m: lista)
	{
	if(m.getTipo().equals("S")&& m.getRol().equals(us.getRol()))
	{
	@SuppressWarnings("deprecation")
	DefaultSubMenu firstSubmenu=new DefaultSubMenu(m.getMenu());
	for(Menu i:lista)
	{
	Menu submenu =i.getSubmenu();
	if(submenu !=null)
	{
	if(submenu.getCodigo()==m.getCodigo())
	{
	DefaultMenuItem item=new DefaultMenuItem(i.getMenu());
	((MenuModel) firstSubmenu).addElement(item);
	}
	}
	}
	model.addElement(firstSubmenu);
	}else
	{
	if(m.getSubmenu()==null &&m.getRol().equals(us.getRol()))
	{
	DefaultMenuItem item=new DefaultMenuItem(m.getMenu());
	model.addElement(item);
	}
	}
	} 
} 
	}
*/