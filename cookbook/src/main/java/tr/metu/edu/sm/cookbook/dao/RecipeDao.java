package tr.metu.edu.sm.cookbook.dao;

import java.util.List;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Recipe;

public interface RecipeDao extends GenericDao<Recipe, Integer> {
	
	List<Recipe> searchRecipes(Recipe recipe);
	Recipe getRecipeByStatus(String status);
	
}
