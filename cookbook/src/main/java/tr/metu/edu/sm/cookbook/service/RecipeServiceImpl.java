package tr.metu.edu.sm.cookbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.RecipeDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Recipe;
import tr.metu.edu.sm.cookbook.entity.RecipeFilter;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "recipeService")
public class RecipeServiceImpl extends
		GenericServiceImpl<Recipe, Integer> implements
		RecipeService<Recipe, Integer> {

	@Autowired
	private RecipeDao dao;

	@Override
	public GenericDao<Recipe, Integer> getDao() {
		return this.dao;
	}


	@Override
	public List<Recipe> searchRecipes(RecipeFilter e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> getRecipesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
