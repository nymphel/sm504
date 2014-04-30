package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.UnitDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Unit;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "unitService")
public class UnitServiceImpl extends
		GenericServiceImpl<Unit, Integer> implements
		UnitService<Unit, Integer> {

	@Autowired
	private UnitDao dao;

	@Override
	public GenericDao<Unit, Integer> getDao() {
		return this.dao;
	}

}
