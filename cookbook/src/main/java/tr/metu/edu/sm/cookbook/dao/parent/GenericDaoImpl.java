package tr.metu.edu.sm.cookbook.dao.parent;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDaoImpl<E,K> implements GenericDao<E, K> {

	protected Class<?> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<?>) genericSuperclass.getActualTypeArguments()[0];
	}

	public void persist(E entity) {
		entityManager.persist(entity);
	}

	public void remove(E entity) {
		entityManager.remove(entity);
	}
	
	public void merge(E entity) {
		entityManager.merge(entity);
	}

	@SuppressWarnings("unchecked")
	public E findById(K id) {
		return (E) entityManager.find(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		Query q = entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e");
		return (List<E>) q.getResultList();
	}

}