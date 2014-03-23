package com.laboratorio.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/** Provides access to the entity manager. */
public class EntityManagerUtil {
	private static final ThreadLocal<EntityManager> ENTITY_MANAGERS = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory emf = null;

	/** Returns a fresh EntityManager */
	public static EntityManager getEntityManager() {
		return ENTITY_MANAGERS.get();
	}

	public static ThreadLocal<EntityManager> getEntityManagers() {
		return ENTITY_MANAGERS;
	}

	public static EntityManager getNewEM() throws Exception {
		if (emf == null) {
			emf = getEntityManagerMFactory();
		}
		return emf.createEntityManager();
	}

	public static EntityManager getRunningEM() throws Exception {
		if (emf == null) {
			emf = getEntityManagerMFactory();
		}
		return getEntityManager();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static EntityManagerFactory getEntityManagerMFactory() throws Exception {

		Map configOverrides = new HashMap();
		configOverrides.put("hibernate.connection.username",
				"javi");
		configOverrides.put("hibernate.connection.password",
				"123456");
		configOverrides.put("hibernate.show_sql",
				"true");
		configOverrides.put("hibernate.connection.url",
				"jdbc:mysql://localhost:3306/myhibernate?createDatabaseIfNotExist=true");
		configOverrides.put("hibernate.hbm2ddl.auto", "create");

		return Persistence.createEntityManagerFactory("PU", configOverrides);
	}

}
