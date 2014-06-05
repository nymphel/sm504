package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Cookingmethod;
import tr.metu.edu.sm.cookbook.service.CookingmethodService;
import tr.metu.edu.sm.cookbook.util.MessagesUtil;

@Component
@Qualifier("cookingmethodBean")
@Scope("session")
public class CookingmethodBean {

	@Autowired
	private CookingmethodService<Cookingmethod, Integer> service;

	private Cookingmethod cookingmethod;
	
	@PostConstruct
	private void init() {
		cookingmethod = new Cookingmethod();
	}

	public void create() {
		service.create(cookingmethod);
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("createCookingmethodSuccessful"));
		cookingmethod = new Cookingmethod();

	}

	public void update() {

	}

	public void delete() {

	}

	public Cookingmethod getById(Integer id) {
		return null;
	}

	public List<Cookingmethod> getAll() {
		return service.getAll();
	}

	public Cookingmethod getCookingmethod() {
		return cookingmethod;
	}

	public void setCookingmethod(Cookingmethod cookingmethod) {
		this.cookingmethod = cookingmethod;
	}
}
