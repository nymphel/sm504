package tr.metu.edu.sm.cookbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.IngredientDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Ingredient;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "ingredientService")
public class IngredientServiceImpl extends
		GenericServiceImpl<Ingredient, Integer> implements
		IngredientService<Ingredient, Integer> {

	@Autowired
	private IngredientDao dao;

	@Override
	public GenericDao<Ingredient, Integer> getDao() {
		return this.dao;
	}

	@Override
	public boolean findIngredientWithName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ingredient> searchIngredients(String keyword) {
		return dao.searchIngredients(keyword);
	}

}
