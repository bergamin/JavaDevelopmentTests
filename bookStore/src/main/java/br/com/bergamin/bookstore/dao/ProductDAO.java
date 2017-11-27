package br.com.bergamin.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bergamin.bookstore.model.Product;

@Repository
@Transactional
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Product product) {
		manager.persist(product);
	}

	public List<Product> list() {
		return manager.createQuery("SELECT P FROM Product P", Product.class).getResultList();
	}

	public Product find(Integer id) {
		return manager.createQuery(
				"SELECT DISTINCT p"
				+ " FROM Product P "
				+ "JOIN FETCH P.prices prices"
				+ "WHERE P.id = :id", Product.class)
				.setParameter("id",id)
				.getSingleResult();
	}

}
