package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Ingredient;
import tr.metu.edu.sm.cookbook.service.IngredientService;

@Component
@Qualifier("ingredientBean")
@Scope("session")
public class IngredientBean {
	
	@Autowired
	private IngredientService<Ingredient, Integer> service;

	private Ingredient ingredient;

	public void create() {

	}

	public void update() {

	}

	public void delete() {

	}
	
	public Ingredient getById(Integer id) {
		return null;
	}

	public List<Ingredient> getAll() {
		return null;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
}
