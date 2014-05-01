package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Category;
import tr.metu.edu.sm.cookbook.service.CategoryService;

@Component
@Qualifier("categoryBean")
@Scope("session")
public class CategoryBean {
	
	@Autowired
	private CategoryService<Category, Integer> service;

	private Category category;

	public void create() {

	}

	public void update() {

	}

	public void delete() {

	}
	
	public Category getById(Integer id) {
		return null;
	}

	public List<Category> getAll() {
		return null;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}