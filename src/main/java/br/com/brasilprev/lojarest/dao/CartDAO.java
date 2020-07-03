package br.com.brasilprev.lojarest.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.brasilprev.lojarest.models.Cart;
import br.com.brasilprev.lojarest.util.JPAUtil;

public class CartDAO extends AbstractDAO<Cart> {
	public Cart findCartById(long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Cart> query = em.createQuery("select c from Cart c where c.id = :pId", Cart.class);
		query.setParameter("pId", id);

		return query.getSingleResult();
	}
}
