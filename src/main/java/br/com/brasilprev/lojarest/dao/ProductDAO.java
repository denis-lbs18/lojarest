package br.com.brasilprev.lojarest.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.brasilprev.lojarest.models.Product;
import br.com.brasilprev.lojarest.util.JPAUtil;

public class ProductDAO extends AbstractDAO<Product> {

	public Product findProductById(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Product> query = em.createQuery("select p from Product p where p.id = :pId", Product.class);
		query.setParameter("pId", id);

		return query.getSingleResult();
	}
}