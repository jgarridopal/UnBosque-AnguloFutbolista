package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.StadiumDAO;
import com.unBosque.entities.Stadium;
import com.unBosque.util.Connection;

public class StadiumDAO_Impl implements StadiumDAO {

	private EntityManager em;

	public StadiumDAO_Impl (){
		
	}
	
	@Override
	public void save(Stadium stadium) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(stadium);
		em.getTransaction().commit();

		em.close();

	}

	@Override
	public Stadium getStadium(String idStadium) {

		String statement;
		Stadium stadium = null;

		em = Connection.getEntityManager();

		statement = "FROM Stadium s WHERE s.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, idStadium);

		@SuppressWarnings("unchecked")
		List<Stadium> lista = query.getResultList();

		if (!lista.isEmpty())
			stadium = lista.get(0);

		em.close();

		return stadium;
		
	}

	@Override
	public List<Stadium> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM Stadium";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<Stadium> lista = query.getResultList();
		
		em.close();
		
		return lista;
	
	}

	@Override
	public void remove(Stadium stadium) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(stadium);
		em.remove(stadium);
		em.getTransaction().commit();

		em.close();

	}

	@Override
	public void update(Stadium stadium) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(stadium);
		em.refresh(stadium);
		em.getTransaction().commit();

		em.close();
		
	}

}
