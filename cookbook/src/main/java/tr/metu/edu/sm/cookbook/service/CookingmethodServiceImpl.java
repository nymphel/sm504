package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.CookingmethodDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Cookingmethod;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "cookingmethodService")
public class CookingmethodServiceImpl extends
		GenericServiceImpl<Cookingmethod, Integer> implements
		CookingmethodService<Cookingmethod, Integer> {

	@Autowired
	private CookingmethodDao dao;

	@Override
	public GenericDao<Cookingmethod, Integer> getDao() {
		return this.dao;
	}

}
