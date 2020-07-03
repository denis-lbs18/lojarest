package br.com.brasilprev.lojarest.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.brasilprev.lojarest.models.Client;
import br.com.brasilprev.lojarest.util.JPAUtil;

public class ClientDAO extends AbstractDAO<Client> {
	public Client findClientById(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.id = :pId", Client.class);
		query.setParameter("pId", id);

		return query.getSingleResult();
	}
}
