package tr.metu.edu.sm.cookbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.RecipeDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Recipe;
import tr.metu.edu.sm.cookbook.entity.RecipeFilter;
import tr.metu.edu.sm.cookbook.entity.Recipeingredient;
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
	public List<Recipe> searchRecipes(RecipeFilter filter) {
		
		List<Recipe> searchResults = new ArrayList<>();
		
		List<String> ingredients = filter.getIngredients();
		List<String> excludedingredients = filter.getExcludedingredients();
		
		List<Recipe> all = dao.findAll();
		if(all != null && !all.isEmpty()) {
			for (Recipe recipe : all) {
				
				if(filter.getMaxcookingtime() != 0) {
					if(recipe.getCookingTime() > filter.getMaxcookingtime()) {
						continue;
					}
				} else if(filter.getCategoryid() != 0) {
					if(recipe.getCategory().getId() != filter.getCategoryid()) {
						continue;
					}
				} else if(filter.getCookingmethodid() != 0) {
					if(recipe.getCookingMethod().getId() != filter.getCookingmethodid()) {
						continue;
					}
				} else if(filter.getCuisinetypeid() != 0) {
					if(recipe.getCuisine().getId() != filter.getCuisinetypeid()) {
						continue;
					}
				} else if(filter.getName() != null && !filter.getName().isEmpty()) {
					String name = recipe.getName().toLowerCase();
					String filtername = filter.getName().toLowerCase();
					if(!name.contains(filtername)) {
						continue;
					}
				} else if(ingredients != null && !ingredients.isEmpty()) {
					int count = findIngredient(ingredients, recipe.getRecipeingredientList());
					if(count != ingredients.size()) {
						continue;
					}
				} else if(excludedingredients != null && !excludedingredients.isEmpty()) {
					int count = findIngredient(excludedingredients, recipe.getRecipeingredientList());
					if(count > 0) {
						continue;
					}
				}  
				
				searchResults.add(recipe);
			}
		}
		
		return searchResults;
	}
	
	private int findIngredient(List<String> find, List<Recipeingredient> pool) {
		
		int count = 0;
		
		try {
			for (String ingredient : find) {
				if(pool != null && !pool.isEmpty()) {
					for (Recipeingredient recipeingredient : pool) {
						if(ingredient.equals(recipeingredient.getIngredient().getName())) {
							count ++;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<Recipe> getRecipesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
