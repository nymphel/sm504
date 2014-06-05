package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

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
	
	private List<Recipe> list;

	@PostConstruct
	private void init() {
		setFilter(new RecipeFilter());
	}

	public String search() {
		list = service.searchRecipes(filter);
		boolean advanced = filter.isAdvanced();
		setFilter(new RecipeFilter());
		filter.setAdvanced(advanced);
		return "listrecipe";
	}

	public RecipeFilter getFilter() {
		return filter;
	}

	public void setFilter(RecipeFilter filter) {
		this.filter = filter;
	}

	public List<Recipe> getList() {
		return list;
	}

	public void setList(List<Recipe> list) {
		this.list = list;
	}
	
	public String back() {
		if(filter != null && filter.isAdvanced()) {
			return "advancedsearch";
		}
		return "search";
	}
}
