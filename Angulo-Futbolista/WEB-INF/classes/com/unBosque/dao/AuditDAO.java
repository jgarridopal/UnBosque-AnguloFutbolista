package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.Audit;

public interface AuditDAO {

	public void save(Audit audit);

	public Audit getEntrie(String id);

	public List<Audit> list();

	public void remove(Audit audit);

	public void update(Audit audit);
	
}
