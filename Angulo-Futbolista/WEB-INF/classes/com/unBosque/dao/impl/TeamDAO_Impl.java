package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.TeamDAO;
import com.unBosque.entities.Team;
import com.unBosque.util.Connection;

public class TeamDAO_Impl implements TeamDAO {

	private EntityManager em;

	public TeamDAO_Impl (){
		
	}
	
	@Override
	public void save(Team team) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(team);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public Team getTeam(String idTeam) {

		String statement;
		Team team = null;

		em = Connection.getEntityManager();

		statement = "FROM Team t WHERE t.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, idTeam);

		@SuppressWarnings("unchecked")
		List<Team> lista = query.getResultList();

		if (!lista.isEmpty())
			team = lista.get(0);

		em.close();

		return team;
		
		
	}

	@Override
	public List<Team> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM Team";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<Team> lista = query.getResultList();
		
		em.close();
		
		return lista;
			
	}

	@Override
	public void remove(Team team) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(team);
		em.remove(team);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(Team team) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(team);
		em.refresh(team);
		em.getTransaction().commit();

		em.close();
		
	}

}
