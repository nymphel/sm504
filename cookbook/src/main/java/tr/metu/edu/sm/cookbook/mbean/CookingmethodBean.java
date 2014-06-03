package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Cookingmethod;
import tr.metu.edu.sm.cookbook.service.CookingmethodService;

@Component
@Qualifier("cookingmethodBean")
@Scope("session")
public class CookingmethodBean {
	
	@Autowired
	private CookingmethodService<Cookingmethod, Integer> service;

	private Cookingmethod cookingmethod;

	public void create() 
	{
		service.create(cookingmethod);
	}

	public void update() {

	}

	public void delete() {

	}
	
	public Cookingmethod getById(Integer id) {
		return null;
	}

	public List<Cookingmethod> getAll() {
		return null;
	}

	public Cookingmethod getCookingmethod() {
		return cookingmethod;
	}

	public void setCookingmethod(Cookingmethod cookingmethod) {
		this.cookingmethod = cookingmethod;
	}
}
