package br.com.bergamin.accounts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bergamin.accounts.model.Account;

public class JPATest {

	public static void main(String[] args) {

		Account account = new Account();
		account.setHolder("Test Holder");
		account.setBank("Test Bank");
		account.setOffice("123");
		account.setNumber("12345");

		/**
		 * Using HSQLDB
		 */

		// EntityManagerFactory emf = Persistence
		// 		.createEntityManagerFactory("accounts-hsqldb");

		/**
		 * Using PostgreSQL
		 */
		// EntityManagerFactory emf = Persistence
		// 		.createEntityManagerFactory("accounts-postgres");

		/**
		 * Using MySQL
		 */
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("accounts-mysql");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(account);

		em.getTransaction().commit();
		em.close();
	}
}
