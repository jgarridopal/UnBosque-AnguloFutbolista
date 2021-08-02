package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.Team;

public interface TeamDAO {

	public void save(Team team);

	public Team getTeam(String idTeam);

	public List<Team> list();

	public void remove(Team team);

	public void update(Team team);
	
}
