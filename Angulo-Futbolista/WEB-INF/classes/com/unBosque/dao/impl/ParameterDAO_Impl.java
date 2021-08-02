package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.ParameterDAO;
import com.unBosque.entities.Parameter;
import com.unBosque.util.Connection;

public class ParameterDAO_Impl implements ParameterDAO {

	private EntityManager em;

	public ParameterDAO_Impl (){
		
	}
	
	@Override
	public void save(Parameter parameter) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(parameter);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public Parameter getParameter(String idParameter) {

		String statement;
		Parameter parameter = null;

		em = Connection.getEntityManager();

		statement = "FROM Parameter p WHERE p.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, idParameter);

		@SuppressWarnings("unchecked")
		List<Parameter> lista = query.getResultList();

		if (!lista.isEmpty())
			parameter = lista.get(0);

		em.close();

		return parameter;
		
	}

	@Override
	public List<Parameter> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM Parameter";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<Parameter> lista = query.getResultList();
		
		em.close();
		
		return lista;
	
	}

	@Override
	public void remove(Parameter parameter) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(parameter);
		em.remove(parameter);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(Parameter parameter) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(parameter);
		em.refresh(parameter);
		em.getTransaction().commit();

		em.close();

	}

}
