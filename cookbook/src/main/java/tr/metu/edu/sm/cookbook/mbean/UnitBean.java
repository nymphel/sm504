package tr.metu.edu.sm.cookbook.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.metu.edu.sm.cookbook.entity.Unit;

@Component
@Qualifier("unitBean")
@Scope("session")
public class UnitBean {

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
		return null;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
