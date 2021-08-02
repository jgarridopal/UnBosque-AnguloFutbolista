package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.UserDAO;
import com.unBosque.entities.User;
import com.unBosque.util.Connection;

public class UserDAO_Impl implements UserDAO {

	private EntityManager em;

	public UserDAO_Impl() {
	}

	@Override
	public void save(User user) {
		
		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public User getUser(String atr, String param) {

		String statement;
		User user = null;

		em = Connection.getEntityManager();

		statement = "FROM User u WHERE u." + param + " = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, atr);

		@SuppressWarnings("unchecked")
		List<User> lista = query.getResultList();

		if (!lista.isEmpty())
			user = lista.get(0);

		em.close();

		return user;
		
	}

	@Override
	public List<User> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM User";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<User> lista = query.getResultList();
		
		em.close();
		
		return lista;
		
	}

	@Override
	public void remove(User user) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(user);
		em.remove(user);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(User user) {
		
		User update;
		
		em = Connection.getEntityManager();

		em.getTransaction().begin();
		update = em.find(User.class, user.getId());
		update.setActive(user.getActive());;
		em.refresh(update);
		em.getTransaction().commit();

		em.close();
		
	}

}
