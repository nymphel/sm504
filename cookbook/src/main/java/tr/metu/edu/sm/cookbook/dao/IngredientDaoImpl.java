package tr.metu.edu.sm.cookbook.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Ingredient;

@Repository
public class IngredientDaoImpl extends GenericDaoImpl<Ingredient, Integer> implements
		IngredientDao {

	@Override
	public boolean findIngredientWithName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingredient> searchIngredients(String keyword) {
		Query query = entityManager.createQuery("select ing from Ingredient ing where ing.name like :keyword");
		query.setParameter("keyword", "%"+keyword+"%");
		
		return query.getResultList();
	}

}
