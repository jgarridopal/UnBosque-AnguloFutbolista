package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.News;

public interface NewsDAO {

	public void save(News news);

	public News getNews(String idNews);

	public List<News> list();

	public void remove(News news);

	public void update(News news);
	
}
