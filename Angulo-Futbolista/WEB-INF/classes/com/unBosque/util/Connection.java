package com.unBosque.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
	
	public Connection() {
		
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}
