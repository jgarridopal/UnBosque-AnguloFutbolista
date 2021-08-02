package com.unBosque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.unBosque.dao.NewsDAO;
import com.unBosque.entities.News;
import com.unBosque.util.Connection;

public class NewsDAO_Impl implements NewsDAO {

	private EntityManager em;

	public NewsDAO_Impl (){
		
	}
	
	@Override
	public void save(News news) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.persist(news);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public News getNews(String idNews) {

		String statement;
		News news = null;

		em = Connection.getEntityManager();

		statement = "FROM News n WHERE n.id = ?1";
		Query query = em.createQuery(statement);

		query.setParameter(1, idNews);

		@SuppressWarnings("unchecked")
		List<News> lista = query.getResultList();

		if (!lista.isEmpty())
			news = lista.get(0);

		em.close();

		return news;
		
	}

	@Override
	public List<News> list() {

		String statement;
		
		em = Connection.getEntityManager();
		
		statement = "FROM News";
		Query query = em.createQuery(statement);

		@SuppressWarnings("unchecked")
		List<News> lista = query.getResultList();
		
		em.close();
		
		return lista;
		
	}

	@Override
	public void remove(News news) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(news);
		em.remove(news);
		em.getTransaction().commit();

		em.close();
		
	}

	@Override
	public void update(News news) {

		em = Connection.getEntityManager();

		em.getTransaction().begin();
		em.merge(news);
		em.refresh(news);
		em.getTransaction().commit();

		em.close();

	}

}
