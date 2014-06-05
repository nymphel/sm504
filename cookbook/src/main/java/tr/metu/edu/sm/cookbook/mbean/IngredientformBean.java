package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Ingredientform;
import tr.metu.edu.sm.cookbook.service.IngredientformService;
import tr.metu.edu.sm.cookbook.util.MessagesUtil;

@Component
@Qualifier("ingredientformBean")
@Scope("session")
public class IngredientformBean {
	
	@Autowired
	private IngredientformService<Ingredientform, Integer> service;

	private Ingredientform ingredientform;
	
	@PostConstruct
	private void init() {
		ingredientform = new Ingredientform();
	}

	public void create() {
		service.create(ingredientform);
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("createIngredientFormSuccessful"));
		ingredientform = new Ingredientform();
	}

	public void update() {

	}

	public void delete() {

	}
	
	public Ingredientform getById(Integer id) {
		return null;
	}

	public List<Ingredientform> getAll() {
		return service.getAll();
	}

	public Ingredientform getIngredientform() {
		return ingredientform;
	}

	public void setIngredientform(Ingredientform ingredientform) {
		this.ingredientform = ingredientform;
	}
}
