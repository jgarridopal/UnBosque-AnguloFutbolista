package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.RefereeDAO;
import com.unBosque.entities.Referee;
import com.unBosque.util.Connection;

public class RefereeDAO_Impl implements RefereeDAO {

	private EntityManager em;

	public RefereeDAO_Impl (){
		
	}
	
	@Override
	public void save(Referee referee) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(referee);
		em.getTransaction().commit();

		em.close();

	}

	@Override
	public Referee getReferee(String idReferee) {

		String statement;
		Referee referee = null;

		em = Connection.getEntityManager();

		statement = "FROM Referee r WHERE r.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, idReferee);

		@SuppressWarnings("unchecked")
		List<Referee> lista = query.getResultList();

		if (!lista.isEmpty())
			referee = lista.get(0);

		em.close();

		return referee;
		
	}

	@Override
	public List<Referee> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM Referee";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<Referee> lista = query.getResultList();
		
		em.close();
		
		return lista;
	
	}

	@Override
	public void remove(Referee referee) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(referee);
		em.remove(referee);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(Referee referee) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(referee);
		em.refresh(referee);
		em.getTransaction().commit();

		em.close();
		
	}

}
