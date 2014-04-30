package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.CategoryDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Category;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "categoryService")
public class CategoryServiceImpl extends
		GenericServiceImpl<Category, Integer> implements
		CategoryService<Category, Integer> {

	@Autowired
	private CategoryDao dao;

	@Override
	public GenericDao<Category, Integer> getDao() {
		return this.dao;
	}

}
