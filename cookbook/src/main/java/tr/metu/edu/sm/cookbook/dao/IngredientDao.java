package tr.metu.edu.sm.cookbook.dao;

import java.util.List;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Ingredient;

public interface IngredientDao extends GenericDao<Ingredient, Integer> {
	
	boolean findIngredientWithName(String name);
	List<Ingredient> searchIngredients(String keyword);
	
}
