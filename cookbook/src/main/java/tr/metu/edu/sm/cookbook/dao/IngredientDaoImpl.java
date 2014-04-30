package tr.metu.edu.sm.cookbook.dao;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Ingredient;

@Repository
public class IngredientDaoImpl extends GenericDaoImpl<Ingredient, Integer> implements
		IngredientDao {

}
