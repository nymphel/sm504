package tr.metu.edu.sm.cookbook.service.parent;

import java.util.List;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;

public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {

	public void create(E e) {
		getDao().persist(e);
	}

	public void update(E e) {
		getDao().merge(e);
	}

	public void delete(E e) {
		getDao().remove(e);
	}

	public E getById(K k) {
		return getDao().findById(k);
	}

	public List<E> getAll() {
		return getDao().findAll();
	}

	public abstract GenericDao<E, K> getDao();
}
