package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.RecipeingredientDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Recipeingredient;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "recipeingredientService")
public class RecipeingredientServiceImpl extends
		GenericServiceImpl<Recipeingredient, Integer> implements
		RecipeingredientService<Recipeingredient, Integer> {

	@Autowired
	private RecipeingredientDao dao;

	@Override
	public GenericDao<Recipeingredient, Integer> getDao() {
		return this.dao;
	}

}
