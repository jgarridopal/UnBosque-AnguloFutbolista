package com.unBosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import com.unBosque.dao.DAOFactory;
import com.unBosque.dao.MenuDAO;
import com.unBosque.entities.Menu;
import com.unBosque.entities.User;

@ManagedBean
@RequestScoped
public class MenuController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuDAO menuDAO;
	private MenuModel model;
	private List<Menu> lista;
	private ArrayList<String> secciones;

	public MenuController() {

	}

	@PostConstruct
	public void init() {

		menuDAO = DAOFactory.getMenuDAO();
		model = new DefaultMenuModel();
		this.listarMenus();
		establecerPermisos();

	}

	private void listarMenus() {
		try {

			lista = menuDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void establecerPermisos() {

		String tipoUsuario;
		
		User us = null;
		
		int indexItem = 0;
		
		secciones = null;
		secciones = new ArrayList<String>();
		
		try {
			us = (User) FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().get("user");

		} catch (Exception e) {
			return;
		}
				
		if (us == null)
			tipoUsuario = "NULL";
		else
			tipoUsuario = us.getUserType();
		
		if (lista != null) {
			
			for (Menu m : lista) {

				String tipoMenu = m.getUserType();
				
				if(tipoMenu == null)
					tipoMenu = "NULL";
				
				if (tipoMenu.equalsIgnoreCase(tipoUsuario)) {
					
					DefaultMenuItem item = new DefaultMenuItem(m.getName());
					
					String path = m.getUrl();
					
					secciones.add("../resources/templates/secciones/" + path);
					
					item.setParam("i", indexItem);
					item.setAjax(true);
					item.setUpdate("main_section");
					
					model.addElement(item);
					
					indexItem++;
				}

			}

		}

	}
	
	public String cambiarSeccion(int selected) {
	
		return secciones.get(selected);
		
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

}
