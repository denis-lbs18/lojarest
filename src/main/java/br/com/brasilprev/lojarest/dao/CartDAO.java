package br.com.brasilprev.lojarest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.brasilprev.lojarest.models.Cart;

public class CartDAO {
	public Cart findCartById(long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Cart> query = em.createQuery("select c from Cart c where c.id = :pId", Cart.class);
		query.setParameter("pId", id);

		return query.getSingleResult();
	}

	public List<Cart> listAllCarts() {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Cart> query = em.createQuery("select c from Cart c ", Cart.class);

		return query.getResultList();
	}
}
