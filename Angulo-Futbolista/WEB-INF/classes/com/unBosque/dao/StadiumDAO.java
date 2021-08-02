package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.Stadium;

public interface StadiumDAO {

	public void save(Stadium stadium);

	public Stadium getStadium(String idStadium);

	public List<Stadium> list();

	public void remove(Stadium stadium);

	public void update(Stadium stadium);
	
}
