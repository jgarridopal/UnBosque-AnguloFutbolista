package com.unBosque.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.unBosque.dao.DAOFactory;
import com.unBosque.dao.UserDAO;
import com.unBosque.entities.User;
import com.unBosque.util.Hash;

@ManagedBean(eager = true)
@ViewScoped
public class LoginController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private User user;

	public LoginController() {

	}

	@PostConstruct
	public void init() {

		userDAO = DAOFactory.getUserDAO();
		user = new User();

	}

	public void iniciarSesion() {

		User us = userDAO.getUser(user.getEmailAddress(), "emailAddress");

		if (us != null) {

			String encrypted = Hash.getStringMessageDigest(user.getPassword(),
					Hash.MD5);

			if (!encrypted.equals(us.getPassword())) {
				enviarAlerta("Contraseña incorrecta");
				return;
			}
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", us);

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}

		}
		
		enviarAlerta("Usuario no encontrado");
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private void enviarAlerta(String alerta) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", alerta));
	}

}
