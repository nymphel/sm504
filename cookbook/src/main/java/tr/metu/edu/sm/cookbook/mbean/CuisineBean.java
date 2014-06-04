package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Cuisine;
import tr.metu.edu.sm.cookbook.service.CuisineService;
import tr.metu.edu.sm.cookbook.util.MessagesUtil;

@Component
@Qualifier("cuisineBean")
@Scope("session")
public class CuisineBean {

	@Autowired
	private CuisineService<Cuisine, Integer> service;

	private Cuisine cuisine;
	
	@PostConstruct
	private void init() {
		cuisine = new Cuisine();
	}

	public void create() {
		service.create(cuisine);
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("createCuisineSuccessful"));
		cuisine = new Cuisine();
	}

	public void update() {

	}

	public void delete() {

	}

	public Cuisine getById(Integer id) {
		return null;
	}

	public List<Cuisine> getAll() {
		return service.getAll();
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
}
