package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Unit;
import tr.metu.edu.sm.cookbook.service.UnitService;

@Component
@Qualifier("unitBean")
@Scope("session")
public class UnitBean {
	
	@Autowired
	private UnitService<Unit, Integer> service;

	private Unit unit;

	public void create() {

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
