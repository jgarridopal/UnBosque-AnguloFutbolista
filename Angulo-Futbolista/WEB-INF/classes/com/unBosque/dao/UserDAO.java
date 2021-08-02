package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.User;

public interface UserDAO {
	
	public void save(User usuario);

	public User getUser(String atr, String param);

	public List<User> list();

	public void remove(User usuario);

	public void update(User usuario);
	
}
