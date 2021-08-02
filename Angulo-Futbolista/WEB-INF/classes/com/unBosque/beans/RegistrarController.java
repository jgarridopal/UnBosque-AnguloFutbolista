package com.unBosque.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unBosque.dao.DAOFactory;
import com.unBosque.dao.UserDAO;
import com.unBosque.entities.User;
import com.unBosque.util.Hash;
import com.unBosque.util.PasswordGenerator;

@ManagedBean(name = "registrarController")
@RequestScoped
public class RegistrarController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;
	private User user;

	private SmtpMailSender mailSender;

	public RegistrarController() {

	}

	@PostConstruct
	public void init() {

		userDAO = DAOFactory.getUserDAO();
		user = new User();

	}

	public void registrar() {

		try {

			String password = PasswordGenerator.generateRandomPassword();
			String email = user.getEmailAddress();

			if (userDAO.getUser(user.getUserName(), "userName") != null) {
				enviarAlerta("Usuario ya existe");
				return;
			}

			if (userDAO.getUser(email, "emailAddress") != null) {
				enviarAlerta("Correo ya existe");
				return;
			}

			String md5 = Hash.getStringMessageDigest(password, Hash.MD5);

			user.setPassword(md5);

			user.setDateLastPassword(new Timestamp(System.currentTimeMillis()));

			user.setUserType("N");

			user.setChangePassword(true);

			user.setActive('A');

			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "./spring/Spring-AutoScan.xml" });

			String subject = "Bienvenido a Ángulo Futbolista";
			String content = "El registro ha sido exitoso, su contraseña es \n\n                "
					+ password;

			mailSender = (SmtpMailSender) context.getBean("mailSender");

			mailSender.enviarCorreo(email, subject, content);

			userDAO.save(user);

		} catch (Exception e) {
			e.printStackTrace();
			enviarAlerta(e.getMessage());
			return;
		}
		
		SesionController sc = new SesionController();
		sc.establecerSeccion("registrado.xhtml");

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private void enviarAlerta(String alerta) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, alerta, alerta));
	}

}
