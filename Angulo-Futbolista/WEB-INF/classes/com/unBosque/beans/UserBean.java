package com.unBosque.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.unBosque.dao.DAOFactory;
import com.unBosque.dao.UserDAO;
import com.unBosque.entities.User;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8373118922443452371L;
	private User user;
	@SuppressWarnings("rawtypes")
	private DataModel listaUsuarios;
	private UserDAO userDAO;

	public UserBean () {
		
	}
	
	public String prepararAdicionarUsuario() {
		user = new User();
		return "/user/userRegisterNew.xhtml?faces-redirect=true";
	}

	public String prepararModificarUsuario() {
		user = (User) (listaUsuarios.getRowData());
		return "/user/userRegister.xhtml?faces-redirect=true";
	}

	public void inactivarUsuario() {
		
		User usuarioTemp = (User) (listaUsuarios.getRowData());
		
		userDAO = DAOFactory.getUserDAO();
		
		usuarioTemp.setActive('I');
		
		userDAO.update(usuarioTemp);

	}

	public void adicionarUsuario() {
		
		userDAO = DAOFactory.getUserDAO();
		
		userDAO.save(user);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarUsuario() {
		
		userDAO = DAOFactory.getUserDAO();
		
		userDAO.update(user);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User usuario) {
		this.user = usuario;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataModel getListarUsuarios() {
		
		UserDAO userDAO = DAOFactory.getUserDAO();
		List<User> lista = userDAO.list();
		listaUsuarios = new ListDataModel(lista);
		
		return listaUsuarios;
		
	}
	
}
