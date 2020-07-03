package br.com.brasilprev.lojarest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.brasilprev.lojarest.models.AbstractEntity;
import br.com.brasilprev.lojarest.util.JPAUtil;

/**
 * Abstract DAO, reffered on all other DAOs.
 * 
 * @author denis
 *
 * @param <T> Class extends AbstractEntity
 */
public class AbstractDAO<T extends AbstractEntity> {
	private Class<T> persistedClass;

	protected AbstractDAO() {
	}

	protected AbstractDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	/**
	 * List all objects from a <T> class.
	 * 
	 * @return {@link List} list of all <T> objects.
	 */
	public List<T> listAll() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return em.createQuery(query).getResultList();
	}

	/**
	 * Save an item to database.
	 * 
	 * If it has no id, persist. Else, merge.
	 * 
	 * @param entity <T> object.
	 */
	public void saveItem(T entity) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		if (entity.getId() == null || entity.getId() == 0) {
			em.persist(entity);
		} else {
			em.merge(entity);
		}

		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Delete an item from database.
	 * 
	 * @param entity <T> object.
	 */
	public void removeItem(T entity) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.getTransaction().commit();
		em.close();
	}
}
