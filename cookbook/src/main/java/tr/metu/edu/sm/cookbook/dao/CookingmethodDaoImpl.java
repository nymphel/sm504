package tr.metu.edu.sm.cookbook.dao;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Cookingmethod;

@Repository
public class CookingmethodDaoImpl extends GenericDaoImpl<Cookingmethod, Integer> implements
		CookingmethodDao {

}
