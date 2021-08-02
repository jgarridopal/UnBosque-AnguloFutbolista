package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.GoalScorerDAO;
import com.unBosque.entities.GoalScorer;
import com.unBosque.util.Connection;

public class GoalScorerDAO_Impl implements GoalScorerDAO {

	private EntityManager em;

	public GoalScorerDAO_Impl (){
		
	}
	
	@Override
	public void save(GoalScorer goalScorer) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(goalScorer);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public GoalScorer getGoalScorer(String idGoalScorer) {

		String statement;
		GoalScorer goalScorer = null;

		em = Connection.getEntityManager();

		statement = "FROM GoalScorer g WHERE g.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, idGoalScorer);

		@SuppressWarnings("unchecked")
		List<GoalScorer> lista = query.getResultList();

		if (!lista.isEmpty())
			goalScorer = lista.get(0);

		em.close();

		return goalScorer;
		
		
	}

	@Override
	public List<GoalScorer> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM GoalScorer";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<GoalScorer> lista = query.getResultList();
		
		em.close();
		
		return lista;
	
	}

	@Override
	public void remove(GoalScorer goalScorer) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(goalScorer);
		em.remove(goalScorer);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(GoalScorer goalScorer) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(goalScorer);
		em.refresh(goalScorer);
		em.getTransaction().commit();

		em.close();

	}

}
