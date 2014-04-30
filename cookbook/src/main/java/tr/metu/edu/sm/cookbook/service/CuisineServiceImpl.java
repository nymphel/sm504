package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.CuisineDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Cuisine;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "cuisineService")
public class CuisineServiceImpl extends
		GenericServiceImpl<Cuisine, Integer> implements
		CuisineService<Cuisine, Integer> {

	@Autowired
	private CuisineDao dao;

	@Override
	public GenericDao<Cuisine, Integer> getDao() {
		return this.dao;
	}

}
