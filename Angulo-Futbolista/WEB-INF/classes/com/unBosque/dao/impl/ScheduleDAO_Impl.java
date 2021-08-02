package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.ScheduleDAO;
import com.unBosque.entities.Schedule;
import com.unBosque.util.Connection;

public class ScheduleDAO_Impl implements ScheduleDAO {

	private EntityManager em;

	public ScheduleDAO_Impl (){
		
	}
	
	@Override
	public void save(Schedule schedule) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(schedule);
		em.getTransaction().commit();

		em.close();

	}

	@Override
	public Schedule getSchedule(String idSchedule) {

		String statement;
		Schedule schedule = null;

		em = Connection.getEntityManager();

		statement = "FROM Schedule s WHERE s.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, idSchedule);

		@SuppressWarnings("unchecked")
		List<Schedule> lista = query.getResultList();

		if (!lista.isEmpty())
			schedule = lista.get(0);

		em.close();

		return schedule;
		
	}

	@Override
	public List<Schedule> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM Schedule";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<Schedule> lista = query.getResultList();
		
		em.close();
		
		return lista;
		
	}

	@Override
	public void remove(Schedule schedule) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(schedule);
		em.remove(schedule);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(Schedule schedule) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(schedule);
		em.refresh(schedule);
		em.getTransaction().commit();

		em.close();

	}

}
