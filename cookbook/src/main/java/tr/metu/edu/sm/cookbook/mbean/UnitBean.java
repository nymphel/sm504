package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Category;
import tr.metu.edu.sm.cookbook.entity.Cuisine;
import tr.metu.edu.sm.cookbook.entity.Unit;
import tr.metu.edu.sm.cookbook.service.UnitService;
import tr.metu.edu.sm.cookbook.util.MessagesUtil;

@Component
@Qualifier("unitBean")
@Scope("session")
public class UnitBean {
	
	@Autowired
	private UnitService<Unit, Integer> service;

	private Unit unit;
	
	@PostConstruct
	private void init() {
		unit = new Unit();
	}

	public void create() {
		service.create(unit);
		MessagesUtil.setGlobalInfoMessage(MessagesUtil
				.getValue("createUnitSuccessful"));
		unit = new Unit();

	}

	public void update() {

	}

	public void delete() {

	}
	
	public Unit getById(Integer id) {
		return null;
	}

	public List<Unit> getAll() {
		return service.getAll();
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
