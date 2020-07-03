package br.com.brasilprev.lojarest.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.brasilprev.lojarest.models.User;
import br.com.brasilprev.lojarest.util.JPAUtil;

public class UserDAO {
	public User findUser(String userName, String password) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<User> query = em.createQuery(
				"select u from User u where u.userName = :pUserName and u.password = :pPassword", User.class);
		query.setParameter("pUserName", userName);
		query.setParameter("pPassword", password);

		return query.getSingleResult();
	}
}
