package com.encurtadorURLJSF.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("encurtadorURLJSF");
		}
		
		return entityManagerFactory.createEntityManager();
	}
	
}
