package br.com.brasilprev.lojarest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.brasilprev.lojarest.models.AbstractEntity;

public class AbstractDAO<T extends AbstractEntity> {
	private Class<T> persistedClass;

	protected AbstractDAO() {
	}

	protected AbstractDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public List<T> listAll() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return em.createQuery(query).getResultList();
	}

	public void saveItem(T entity) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		if (entity.getId() != null || entity.getId() != 0) {
			em.merge(entity);
		} else {
			em.persist(entity);
		}

		em.getTransaction().commit();
		em.close();
	}
}
