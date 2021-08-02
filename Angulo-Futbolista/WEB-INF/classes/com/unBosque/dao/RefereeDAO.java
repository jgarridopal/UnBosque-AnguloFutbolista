package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.Referee;

public interface RefereeDAO {

	public void save(Referee referee);

	public Referee getReferee(String idReferee);

	public List<Referee> list();

	public void remove(Referee referee);

	public void update(Referee referee);
	
}
