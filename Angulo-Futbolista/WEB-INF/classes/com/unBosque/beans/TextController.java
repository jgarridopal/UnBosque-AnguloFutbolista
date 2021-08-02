package com.unBosque.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(eager=true)
@SessionScoped
public class TextController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String section;

	public String estadoDeSesion() {
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user") != null) {
			return "Cerrar sesión";
		}
		
		return "Iniciar sesión";
		
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
