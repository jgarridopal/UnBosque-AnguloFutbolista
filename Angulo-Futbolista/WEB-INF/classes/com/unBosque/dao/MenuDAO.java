package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.Menu;

public interface MenuDAO {

	public void save(Menu menu);

	public Menu getMenu(String name);

	public List<Menu> list();

	public void remove(Menu menu);

	public void update(Menu menu);
	
}
