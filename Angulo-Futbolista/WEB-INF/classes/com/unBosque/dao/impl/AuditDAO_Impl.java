package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.AuditDAO;
import com.unBosque.entities.Audit;
import com.unBosque.util.Connection;

public class AuditDAO_Impl implements AuditDAO {

	private EntityManager em;
	
	public AuditDAO_Impl () {
		
	}
	
	@Override
	public void save(Audit audit) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(audit);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public Audit getEntrie(String id) {

		String statement;
		Audit audit = null;

		em = Connection.getEntityManager();

		statement = "FROM Audit a WHERE a.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, id);

		@SuppressWarnings("unchecked")
		List<Audit> lista = query.getResultList();

		if (!lista.isEmpty())
			audit = lista.get(0);

		em.close();

		return audit;
		
	}

	@Override
	public List<Audit> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM Audit";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<Audit> lista = query.getResultList();
		
		em.close();
		
		return lista;
			
	}

	@Override
	public void remove(Audit audit) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(audit);
		em.remove(audit);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(Audit audit) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(audit);
		em.refresh(audit);
		em.getTransaction().commit();

		em.close();
		
	}



}
