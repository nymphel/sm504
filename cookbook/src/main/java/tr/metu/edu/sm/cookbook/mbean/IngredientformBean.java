package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Ingredientform;

@Component
@Qualifier("ingredientformBean")
@Scope("session")
public class IngredientformBean {

	private Ingredientform ingredientform;

	public void create() {

	}

	public void update() {

	}

	public void delete() {

	}
	
	public Ingredientform getById(Integer id) {
		return null;
	}

	public List<Ingredientform> getAll() {
		return null;
	}

	public Ingredientform getIngredientform() {
		return ingredientform;
	}

	public void setIngredientform(Ingredientform ingredientform) {
		this.ingredientform = ingredientform;
	}
}
