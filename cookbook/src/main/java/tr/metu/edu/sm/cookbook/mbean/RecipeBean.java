package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Recipe;

@Component
@Qualifier("recipeBean")
@Scope("session")
public class RecipeBean {

	private Recipe recipe;

	public List<Recipe> getRecipeRequests() {
		return null;
	}

	public void approve() {

	}

	public void reject() {

	}

	public void create() {

	}

	public void update() {

	}

	public void delete() {

	}

	public Recipe getById(Integer id) {
		return null;
	}

	public List<Recipe> getAll() {
		return null;
	}

	public void rate(int rating) {

	}

	public void comment(String comment) {

	}

	public void share(int rating) {

	}
	
	public List<Recipe> search(Recipe recipe) {
		return null;
	}
	
	public List<Recipe> advancedSearch(Recipe recipe) {
		return null;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
