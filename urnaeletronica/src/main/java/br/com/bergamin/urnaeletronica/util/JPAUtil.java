package br.com.bergamin.urnaeletronica.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("urnaeletronica-mysql");
	
	public EntityManager getEntityManager(){
		return EMF.createEntityManager();
	}
	
}
