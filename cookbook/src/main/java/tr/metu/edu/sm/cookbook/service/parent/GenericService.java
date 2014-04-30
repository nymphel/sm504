package tr.metu.edu.sm.cookbook.service.parent;

import java.util.List;

public interface GenericService<E, K> {
	
	void create(E e);
	void update(E e);
	void delete(E e);
	E getById(K k);
	List<E> getAll();
}
