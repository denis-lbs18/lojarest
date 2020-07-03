package br.com.brasilprev.lojarest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasilprev.lojarest.models.AbstractEntity;
import br.com.brasilprev.lojarest.util.JPAUtil;

/**
 * Abstract DAO, reffered on all other DAOs.
 * 
 * @author denis
 *
 * @param <T> Class extends AbstractEntity
 */
public abstract class AbstractDAO<T extends AbstractEntity> {

	protected AbstractDAO() {
	}

	protected AbstractDAO(Class<T> persistedClass) {
		this();
	}

	/**
	 * List all objects from a <T> class.
	 * 
	 * @return {@link List} list of all <T> objects.
	 */
	public abstract List<T> listAll();

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
