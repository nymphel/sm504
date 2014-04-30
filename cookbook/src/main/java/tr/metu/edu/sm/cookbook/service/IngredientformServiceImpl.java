package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.IngredientformDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Ingredientform;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "ingredientformService")
public class IngredientformServiceImpl extends
		GenericServiceImpl<Ingredientform, Integer> implements
		IngredientformService<Ingredientform, Integer> {

	@Autowired
	private IngredientformDao dao;

	@Override
	public GenericDao<Ingredientform, Integer> getDao() {
		return this.dao;
	}

}
