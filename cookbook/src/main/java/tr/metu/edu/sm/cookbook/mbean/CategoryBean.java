package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Category;
import tr.metu.edu.sm.cookbook.entity.Cuisine;
import tr.metu.edu.sm.cookbook.service.CategoryService;
import tr.metu.edu.sm.cookbook.util.MessagesUtil;

@Component
@Qualifier("categoryBean")
@Scope("session")
public class CategoryBean {

	@Autowired
	private CategoryService<Category, Integer> service;

	private Category category;
	
	@PostConstruct
	private void init() {
		category = new Category();
	}

	public void create() {
		service.create(category);
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("createCategorySuccessful"));
		category = new Category();

	}

	public void update() {
		service.update(category);
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("updateCategorySuccessful"));
	}

	public void delete() {
		try {
			service.delete(category.getId());
			MessagesUtil.setGlobalInfoMessage(MessagesUtil
					.getValue("deleteCategorySuccessful"));
			category = new Category();
		} catch (Exception e) {
			MessagesUtil.setGlobalErrorMessage(MessagesUtil
					.getValue("categoryInUse"));
			e.printStackTrace();
		}

	}

	public Category getById(Integer id) {
		return service.getById(id);
	}

	public List<Category> getAll() {
		List<Category> all = service.getAll();
		if (category != null && category.getId() == null && all != null
				&& !all.isEmpty()) {
			category = all.get(0);
		}
		return all;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void select() {
		Integer selectedId = this.category.getId();
		if (selectedId != null && selectedId != 0) {
			this.category = getById(selectedId);
		}
	}
}
