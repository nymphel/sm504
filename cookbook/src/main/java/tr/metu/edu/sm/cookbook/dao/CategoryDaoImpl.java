package tr.metu.edu.sm.cookbook.dao;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category, Integer> implements
		CategoryDao {

}
