package tr.metu.edu.sm.cookbook.service;

import java.util.List;

import tr.metu.edu.sm.cookbook.entity.Ingredient;
import tr.metu.edu.sm.cookbook.service.parent.GenericService;

public interface IngredientService<E, K> extends GenericService<E, K> {
	
	boolean findIngredientWithName(String name);
	List<Ingredient> searchIngredients(String keyword);

}
