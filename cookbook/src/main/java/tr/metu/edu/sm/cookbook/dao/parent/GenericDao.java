package tr.metu.edu.sm.cookbook.dao.parent;

import java.util.List;

public interface GenericDao<E,K>{
    public void persist(E entity);
    public void remove(K id);
    public void merge(E entity);
    public E findById(K id);
    public List<E> findAll();
}
