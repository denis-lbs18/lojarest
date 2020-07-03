package br.com.brasilprev.lojarest.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.brasilprev.lojarest.models.Product;
import br.com.brasilprev.lojarest.util.JPAUtil;

/**
 * {@link Product} Data Access Object.
 * 
 * @author denis
 *
 */
public class ProductDAO extends AbstractDAO<Product> {
	/**
	 * Find a single product by id.
	 * 
	 * @param id id from a product.
	 * @return {@link Product} object type.
	 */
	public Product findProductById(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Product> query = em.createQuery("select p from Product p where p.id = :pId", Product.class);
		query.setParameter("pId", id);

		return query.getSingleResult();
	}
}