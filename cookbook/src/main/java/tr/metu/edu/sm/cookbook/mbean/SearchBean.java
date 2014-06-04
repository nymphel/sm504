package tr.metu.edu.sm.cookbook.mbean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Recipe;
import tr.metu.edu.sm.cookbook.entity.RecipeFilter;
import tr.metu.edu.sm.cookbook.service.RecipeService;

@Component
@Qualifier("searchBean")
@Scope("session")
public class SearchBean {

	@Autowired
	private RecipeService<Recipe, Integer> service;
	
	private RecipeFilter filter;
	
	@PostConstruct
	private void init() 
	{
		setFilter(new RecipeFilter());
	}

	public void search() 
	{
		service.searchRecipes(getFilter());
		setFilter(new RecipeFilter());
	}

	public RecipeFilter getFilter() {
		return filter;
	}

	public void setFilter(RecipeFilter filter) {
		this.filter = filter;
	}
}
