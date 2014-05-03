package tr.metu.edu.sm.cookbook.dao;

import java.util.List;

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

	@Override
	public List<Ingredient> searchIngredients(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
