package tr.metu.edu.sm.cookbook.service;

import java.util.List;

import tr.metu.edu.sm.cookbook.entity.Recipe;
import tr.metu.edu.sm.cookbook.entity.User;
import tr.metu.edu.sm.cookbook.service.parent.GenericService;

public interface RecipeService<E, K> extends GenericService<E, K> {

	void commentOnRecipe(E e, String comment, User user);

	void rateRecipe(E e, int rating, User user);

	List<Recipe> searchRecipes(E e);

}
