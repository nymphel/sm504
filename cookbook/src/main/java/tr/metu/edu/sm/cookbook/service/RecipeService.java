package tr.metu.edu.sm.cookbook.service;

import java.util.List;

import tr.metu.edu.sm.cookbook.entity.Recipe;
import tr.metu.edu.sm.cookbook.entity.RecipeFilter;
import tr.metu.edu.sm.cookbook.service.parent.GenericService;

public interface RecipeService<E, K> extends GenericService<E, K> {

	List<Recipe> searchRecipes(RecipeFilter recipeFilter);
	List<Recipe> getRecipesByStatus(String status);

}
