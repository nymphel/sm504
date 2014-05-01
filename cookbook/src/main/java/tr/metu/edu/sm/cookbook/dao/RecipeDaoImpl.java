package tr.metu.edu.sm.cookbook.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Recipe;

@Repository
public class RecipeDaoImpl extends GenericDaoImpl<Recipe, Integer> implements
		RecipeDao {

	@Override
	public List<Recipe> searchRecipes(Recipe recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipe getRecipeByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
