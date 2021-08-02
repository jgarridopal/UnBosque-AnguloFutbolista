package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.MenuDAO;
import com.unBosque.entities.Menu;
import com.unBosque.util.Connection;

public class MenuDAO_Impl implements MenuDAO {

	private EntityManager em;

	public MenuDAO_Impl() {
	}
	
	@Override
	public void save(Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public Menu getMenu(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> list() {
		
		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM Menu";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<Menu> lista = query.getResultList();
		
		em.close();
		
		return lista;
		
	}

	@Override
	public void remove(Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub

	}

}
