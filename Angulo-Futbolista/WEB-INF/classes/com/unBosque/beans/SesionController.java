package com.unBosque.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.unBosque.entities.User;

@ManagedBean(eager = true)
@SessionScoped
public class SesionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3121125522526437485L;
	private String seccion;

	public SesionController() {

	}

	@PostConstruct
	public void init() {

	}

	public void verificarSesion() {

		try {

			User temp = (User) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("user");

			if (temp != null)
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("index.xhtml");

		} catch (Exception e) {
			enviarAlerta(e.getMessage());
		}

	}

	public void manejarSesion() {

		User temp = (User) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");

		try {
			if (temp != null) {
				FacesContext.getCurrentInstance().getExternalContext()
						.invalidateSession();
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("index.xhtml");
			} else
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("sesion.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String cambiarSeccionLogin() {

		if (seccion == null)
			seccion = "opciones.xhtml";

		String path = "../resources/templates/secciones/login/" + seccion;
		
		System.out.println("Redireccionado");
		
		return path;

	}

	public void invalidarSeccion() {
		seccion = null;
	}

	public void establecerSeccion(String seccion) {
		
		System.out.println("Seccion: " + seccion);
		this.seccion = seccion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	private void enviarAlerta(String alerta) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, alerta, alerta));
	}

}
